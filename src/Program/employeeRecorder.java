import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeRecorder {
    private ArrayList<Employee> employees;

    public EmployeeRecorder() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void displayAllEmployees() {
        System.out.println("All Employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

public class employeeRecorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeRecorder employeeRecorder = new EmployeeRecorder();

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();

                    Employee employee = new Employee(name, id, salary);
                    employeeRecorder.addEmployee(employee);
                    break;

                case 2:
                    employeeRecorder.displayAllEmployees();
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
