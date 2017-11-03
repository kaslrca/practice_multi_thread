package sf.employee;

/**
 * 擁有管理權限的抽象類別
 * 
 * @author shihfenghuang
 *
 */
public abstract class Leader extends Employee {

	public Leader(int id, int capability) {
		super(id, capability);
	}

}
