package sf.problem;

import sf.call.CallCenter;

/**
 * 問題產生器
 * 
 * @author shihfenghuang
 *
 */
public class ProblemGenerator implements Runnable {

	private CallCenter callCenter;

	public ProblemGenerator(CallCenter callCenter) {
		this.callCenter = callCenter;
	}

	@Override
	public void run() {

		for (int i = 0; i < 3; i++) {
			Problem problem = new Problem(i);

			callCenter.accept(problem);

			System.out.println("Thread [" + Thread.currentThread().getName() + "] Problem [" + problem.getId()
					+ "] Level [" + problem.getDifficultLevel() + "] solved:" + problem.isSolved());
		}
	}

}
