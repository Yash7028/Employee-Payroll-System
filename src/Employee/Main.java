package Employee;

import java.util.ArrayList;

/**
 * @author yashb
 *
 */
abstract class Employee {
	private String name;
	private int id;

	// Constructor for assign value to variable
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	// Get Name
	public String getName() {
		return name;
	}

	// Get Id
	public int getId() {
		return id;
	}

	// abstract method
	public abstract double calculateSalary();

	@Override
	public String toString() {
		return "Employee[name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
	}
}

// Class for full time employee
class FullTimeEmployee extends Employee {
	private double monthlySalary;

	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name, id);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
}

// Class for partTime employee
class PartTimeEmployee extends Employee {
	private int hoursWorked;
	private double hourlyRate;

	public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
		super(name, id);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double calculateSalary() {
		return hoursWorked * hourlyRate;
	}
}

class PayrollSystem {
	private ArrayList<Employee> employeeList;

	// Constructor save value name, id , salary
	public PayrollSystem() {
		employeeList = new ArrayList<>();
	}

	// Add employee method
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	// Remove employee method
	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		for (Employee employee : employeeList) {
			if (employee.getId() == id) {
				employeeToRemove = employee;
				break;
			}
		}
		if (employeeToRemove != null) {
			employeeList.remove(employeeToRemove);
		}
	}

	// Display employee list
	public void displayEmployees() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}

	}
}

public class Main {
	public static void main(String[] args) {
		PayrollSystem payrollSystem = new PayrollSystem();
		FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000.0);
		PartTimeEmployee emp2 = new PartTimeEmployee("Alexander", 2, 400, 100);

		payrollSystem.addEmployee(emp1);
		payrollSystem.addEmployee(emp2);

		System.out.println("WELCOME");
		System.out.println("Employee details: =====");
		payrollSystem.displayEmployees();
		System.out.println("Remove Employee details:====== ");
		payrollSystem.removeEmployee(2);
		System.out.println("Remain Employee details:====== ");
		payrollSystem.displayEmployees();
	}
}
