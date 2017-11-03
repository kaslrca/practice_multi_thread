package sf.employee;

import sf.problem.Problem;

/**
 * Technical Leader
 * 
 * @author shihfenghuang
 *
 */
public class Technical extends Leader {

	public Technical(int id, int capability) {
		super(id, capability);
	}

	@Override
	protected void handleProblem(Problem problem) {
		System.out.println("Thread [" + Thread.currentThread().getName() + "] " + this.getClass().getSimpleName()
				+ this.id + " starting handle Problem [" + problem.getId() + "]");

		int s = workTime(problem);

		try {
			Thread.sleep(s);
			if (this.capability >= problem.getDifficultLevel()) {
				problem.solved();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread [" + Thread.currentThread().getName() + "] " + this.getClass().getSimpleName()
				+ this.id + " finished problem [" + problem.getId() + "] [" + problem.isSolved() + "] time [" + s
				+ " ms]");
	}

}
