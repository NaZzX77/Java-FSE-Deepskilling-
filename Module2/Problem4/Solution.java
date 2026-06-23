class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String toString() {
        return employeeId + " " + name + " " + position + " " + salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees = new Employee[10];
    private int employeeCount = 0;

    public void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount] = employee;
            employeeCount++;
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void displayEmployees() {
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[employeeCount - 1] = null;
                employeeCount--;
                return;
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        system.addEmployee(new Employee(101, "Arun", "Developer", 50000.0));
        system.addEmployee(new Employee(102, "Divya", "Tester", 45000.0));
        System.out.println("Search: " + system.searchEmployee(102));
        system.displayEmployees();
        system.deleteEmployee(101);
        System.out.println("After deletion:");
        system.displayEmployees();

        System.out.println("Add: O(1), Search: O(n), Traverse: O(n), Delete: O(n)");
    }
}
