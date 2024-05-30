import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private static int idCounter = 1;
    private static Student[] students = new Student[100];
    private static int studentCount = 0;

    public Student(String name) {
        this.name = name;
        this.id = idCounter++;
    }

    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name:");
        String name = sc.nextLine();
        Student student = new Student(name);
        students[studentCount++] = student;
        System.out.println("Student added successfully.");
    }

    public static void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to delete:");
        int id = sc.nextInt();
        for (int i = 0; i < studentCount; i++) {
            if (students[i].id == id) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--studentCount] = null;
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to update:");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < studentCount; i++) {
            if (students[i].id == id) {
                System.out.println("Enter new name:");
                students[i].name = sc.nextLine();
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to search:");
        int id = sc.nextInt();
        for (int i = 0; i < studentCount; i++) {
            if (students[i].id == id) {
                System.out.println("Student found: " + students[i].name);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void display() {
        if (studentCount == 0) {
            System.out.println("No students available.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println("ID: " + students[i].id + ", Name: " + students[i].name);
            }
        }
    }
}

class Employee {
    private String name;
    private int id;
    private static int idCounter = 1;
    private static Employee[] employees = new Employee[100];
    private static int employeeCount = 0;

    public Employee(String name) {
        this.name = name;
        this.id = idCounter++;
    }

    public static void addEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name:");
        String name = sc.nextLine();
        Employee employee = new Employee(name);
        employees[employeeCount++] = employee;
        System.out.println("Employee added successfully.");
    }

    public static void deleteEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee ID to delete:");
        int id = sc.nextInt();
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].id == id) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--employeeCount] = null;
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void updateEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee ID to update:");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].id == id) {
                System.out.println("Enter new name:");
                employees[i].name = sc.nextLine();
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void display() {
        if (employeeCount == 0) {
            System.out.println("No employees available.");
        } else {
            for (int i = 0; i < employeeCount; i++) {
                System.out.println("ID: " + employees[i].id + ", Name: " + employees[i].name);
            }
        }
    }
}

class Expenditure {
    private double amount;
    private String description;
    private static Expenditure[] expenditures = new Expenditure[100];
    private static int expenditureCount = 0;

    public Expenditure(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public static void addExpense() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expense amount:");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter expense description:");
        String description = sc.nextLine();
        Expenditure expenditure = new Expenditure(amount, description);
        expenditures[expenditureCount++] = expenditure;
        System.out.println("Expense added successfully.");
    }

    public static void displayExpenses() {
        if (expenditureCount == 0) {
            System.out.println("No expenditures available.");
        } else {
            for (int i = 0; i < expenditureCount; i++) {
                System.out.println("Amount: " + expenditures[i].amount + ", Description: " + expenditures[i].description);
            }
        }
    }
}

public class HostelManagementSystem {
    Scanner sc = new Scanner(System.in);

    public void login() {
        while (true) {
            System.out.println("\t\t\t\t\t\t\t\t\t\tEnter your Username.");
            String inputUsername = sc.next();
            System.out.println("\t\t\t\t\t\t\t\t\t\tEnter your Password");
            String inputPassword = sc.next();
            if (inputUsername.equals("admin") && inputPassword.equals("admin")) {
                System.out.println("Login successful");
                return;
            } else {
                System.out.println("Invalid username and password. Please try again.");
            }
        }
    }

    public void mainmenu() {
        boolean start = true;
        while (start) {
            System.out.println("  Please Select one of the following options.  \n ");
            System.out.println("1. Hostelites Management. ");
            System.out.println("2. Employees Management.");
            System.out.println("3. Expenditure");
            System.out.println("4. Back to login");
            System.out.println("5. Exit \n");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    hostlitemenu();
                    break;
                case 2:
                    Employeemenu();
                    break;
                case 3:
                    Expendituremenu();
                    break;
                case 4:
                    login();
                    break;
                case 5:
                    start = false;
                    System.out.println("Exiting the system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public void hostlitemenu() {
        boolean start = true;
        while (start) {
            System.out.println("  Please Select one of the following options.  \n ");
            System.out.println("1. Add a new student.");
            System.out.println("2. Remove a student.");
            System.out.println("3. Update Student Details");
            System.out.println("4. Search student.");
            System.out.println("5. Display all students.");
            System.out.println("6. Back to main menu \n");

            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Student.addStudent();
                    break;
                case 2:
                    Student.deleteStudent();
                    break;
                case 3:
                    Student.updateStudent();
                    break;
                case 4:
                    Student.searchStudent();
                    break;
                case 5:
                    Student.display();
                    break;
                case 6:
                    start = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public void Employeemenu() {
        boolean start = true;
        while (start) {
            System.out.println("  Please Select one of the following options.  \n ");
            System.out.println("1. Add a new Employee.");
            System.out.println("2. Remove an Employee.");
            System.out.println("3. Update Employee Details");
            System.out.println("4. Display all Employees.");
            System.out.println("5. Back to main menu \n");

            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Employee.addEmployee();
                    break;
                case 2:
                    Employee.deleteEmployee();
                    break;
                case 3:
                    Employee.updateEmployee();
                    break;
                case 4:
                    Employee.display();
                    break;
                case 5:
                    start = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public void Expendituremenu() {
        boolean start = true;
        while (start) {
            System.out.println("  Please Select one of the following options.  \n ");
            System.out.println("1. Add Expense.");
            System.out.println("2. Display all Expenses.");
            System.out.println("3. Back to main menu \n");

            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Expenditure.addExpense();
                    break;
                case 2:
                    Expenditure.displayExpenses();
                    break;
                case 3:
                    start = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static void main(String[] args) {
        HostelManagementSystem system = new HostelManagementSystem();
        system.login();
        system.mainmenu();
    }
}
