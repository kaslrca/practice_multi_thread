package sf.problem;

/**
 * 問題
 * 
 * @author shihfenghuang
 *
 */
public class Problem {

	private int id;

	// 問題困難度，難度由1至10
	private int difficultLevel = 0;

	private boolean isSolved = false;

	public Problem(int id) {
		this.id = id;
		this.difficultLevel = (int) (Math.random() * 10 + 1);
	}

	public int getId() {
		return id;
	}

	public boolean isSolved() {
		return isSolved;
	}

	public void solved() {
		this.isSolved = true;
	}

	public int getDifficultLevel() {
		return difficultLevel;
	}

	public void setDifficultLevel(int difficultLevel) {
		this.difficultLevel = difficultLevel;
	}
}