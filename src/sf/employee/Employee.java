package sf.employee;

import sf.problem.Problem;

/**
 * 員工抽象類別
 * 
 * @author shihfenghuang
 *
 */
public abstract class Employee implements Skill {

	// 上級員工
	private Leader leader;

	// 員工目前是否有在處理其他問題 true->空閒，false->處理問題中
	private volatile boolean state = true;

	protected int id;

	// 處理問題的能力大小
	protected int capability;

	public Employee(int id, int capability) {
		this.id = id;
		this.capability = capability;
	}

	public boolean isAvailable() {
		return state;
	}

	public void setLeader(Leader leader) {
		this.leader = leader;
	}

	@Override
	public void processProblem(Problem problem) {
		state = false; // 處理問題中

		// 執行處理方法
		handleProblem(problem);

		// 問題無法處理，如果有上級就向上反應
		if (!problem.isSolved() && leader != null) {
			escalate(problem);
		}

		state = true; // 結束處理問題
	}

	protected abstract void handleProblem(Problem problem);

	/**
	 * 員工本身能力不足以解決問題，把問題反應給上級處理
	 * 
	 * @param problem
	 */
	private void escalate(Problem problem) {

		if (!leader.isAvailable()) {
			System.out.println("Thread [" + Thread.currentThread().getName() + "] waiting for available leader");
		}

		synchronized (leader) {

			leader.processProblem(problem);

			// 上級手上問題處理完畢，叫醒其他需要上級處理問題的員工，以便處理下個問題
			leader.notifyAll();
		}

	}

	protected int workTime(Problem problem) {
		return (int) (Math.random() * problem.getDifficultLevel() * (10 - this.capability) / 10 + 1) * 1000;
	}

}
