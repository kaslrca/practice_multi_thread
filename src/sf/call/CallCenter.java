package sf.call;

import java.util.ArrayList;
import java.util.List;

import sf.employee.Employee;
import sf.problem.Problem;

/**
 * 客服系統
 * 
 * 指派員工處理問題
 * 
 * @author shihfenghuang
 *
 */
public class CallCenter {

	/**
	 * 目前所擁有的員工
	 */
	private List<Employee> employees = new ArrayList<Employee>();

	/**
	 * 接受問題處理
	 * 
	 * @param problem
	 */
	public void accept(Problem problem) {
		Employee employee = lookupAvailEmployee();

		employee.processProblem(problem);

		addEmployee(employee);

	}

	/**
	 * 找出目前有空閒的員工
	 * 
	 * @return
	 */
	private Employee lookupAvailEmployee() {
		Employee empSelected = null;

		synchronized (employees) {

			while (employees.size() == 0) {
				try {
					System.out.println(
							"Thread [" + Thread.currentThread().getName() + "] waiting for available employee");
					employees.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			empSelected = employees.remove(0);

		}

		return empSelected;
	}

	/**
	 * 加入有空閒的員工
	 * 
	 * @param emp
	 */
	public void addEmployee(Employee emp) {
		synchronized (employees) {
			this.employees.add(emp);
			employees.notifyAll();
		}
	}

}
