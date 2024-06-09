package com.slashmark.internship;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private String position;

    // Constructor
    public Employee(String name, int id, String position) {
        this.name = name;
        this.id = id;
        this.position = position;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private int nextEmployeeId = 1;

    public void addEmployee(String name, String position) {
        Employee employee = new Employee(name, nextEmployeeId, position);
        nextEmployeeId++;
        employeeList.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nEmployee List:");
            for (Employee employee : employeeList) {
                System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Position: " + employee.getPosition());
            }
        }
    }

    public void updateEmployee(int id, String newName, String newPosition) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employee.setName(newName);
                employee.setPosition(newPosition);
                System.out.println("Employee information updated successfully!");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void deleteEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
}

public class EmployeeManagementApplication {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			EmployeeManagementSystem ems = new EmployeeManagementSystem();

			int choice;
			do {
			    System.out.println("\nEmployee Management Application");
			    System.out.println("1. Add Employee");
			    System.out.println("2. View Employees");
			    System.out.println("3. Update Employee Information");
			    System.out.println("4. Delete Employee");
			    System.out.println("5. Exit");
			    System.out.print("Enter your choice: ");
			    choice = scanner.nextInt();

			    switch (choice) {
			        case 1:
			            System.out.print("Enter employee name: ");
			            String name = scanner.next();
			            System.out.print("Enter employee position: ");
			            String position = scanner.next();
			            ems.addEmployee(name, position);
			            break;
			        case 2:
			            ems.viewEmployees();
			            break;
			        case 3:
			            System.out.print("Enter employee ID to update: ");
			            int updateId = scanner.nextInt();
			            System.out.print("Enter new name: ");
			            String newName = scanner.next();
			            System.out.print("Enter new position: ");
			            String newPosition = scanner.next();
			            ems.updateEmployee(updateId, newName, newPosition);
			            break;
			        case 4:
			            System.out.print("Enter employee ID to delete: ");
			            int deleteId = scanner.nextInt();
			            ems.deleteEmployee(deleteId);
			            break;
			        case 5:
			            System.out.println("Exiting the Employee Management Application. Thank you!");
			            break;
			        default:
			            System.out.println("Invalid choice. Please try again.");
			    }

			} while (choice != 5);
		}
      
    }
}
