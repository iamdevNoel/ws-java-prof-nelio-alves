package entities;

public class Employee {
	private int id;
	private String name;
	private double salary;
	// private double grossSalary;
	// private double tax;

	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}

	/*
	 * public double netSalary() { return grossSalary - tax; }
	 */ 
	 public void increaseSalary(double percentage) { 
		 salary = salary * (1 + percentage / 100);
	 }
	 
	
}
