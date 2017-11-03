package sf.test;

import sf.call.CallCenter;
import sf.employee.Fresher;
import sf.employee.Manager;
import sf.employee.Technical;
import sf.problem.ProblemGenerator;

public class Test {

	public static void main(String[] args) {

		Manager manager = new Manager(1, 10);

		Technical technical = new Technical(1, 8);
		technical.setLeader(manager);

		Fresher fresher1 = new Fresher(1, 5);
		fresher1.setLeader(technical);
		Fresher fresher2 = new Fresher(2, 5);
		fresher2.setLeader(technical);

		CallCenter callCenter = new CallCenter();
		callCenter.addEmployee(fresher1);
		callCenter.addEmployee(fresher2);

		Thread t1 = new Thread(new ProblemGenerator(callCenter));
		Thread t2 = new Thread(new ProblemGenerator(callCenter));
		Thread t3 = new Thread(new ProblemGenerator(callCenter));

		t1.setName("T1");
		t2.setName("T2");
		t3.setName("T3");

		t1.start();
		t2.start();
		t3.start();

	}
}
