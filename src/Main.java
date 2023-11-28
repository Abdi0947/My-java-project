import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private String id;
    private String address;
    private String department;
    private String college;

    public Student(String firstName, String lastName, String id, String address, String department, String college) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        this.department = department;
        this.college = college;
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}

class StudentRegistrationSystem {
    private List<Student> students;

    public StudentRegistrationSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("You are registered successfully.");
        System.out.println("NAME: " + student.getFirstName().toUpperCase()+ "     " + student.getLastName().toUpperCase());
        System.out.println("___________________Here is your slip---------------------------------");
        System.out.println("|Course--------------------------------------|ECTS|-----------|cr.hr.|-------Lestures");
        System.out.println("|OBJECT ORIENTED..............................| 5  |...........|  3   |.........|TBA");
        System.out.println("|STATISTIC GRADE..............................| 5  |...........|  3   |.........|TBA");
        System.out.println("|COMPUTER ORGANIZATION........................| 5  |...........|  3   |.........|TBA");
        System.out.println("|OPERATING SYSTEM.............................| 7  |...........|  4   |.........|TBA");
        System.out.println("|NETWORKING...................................| 7  |...........|  4   |.........|TBA");
        System.out.println("|DATA STRUCTURE...............................| 5  |...........|  3   |.........|TBA");
        System.out.println(" ");
    }

    public void removeStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                students.remove(student);
                System.out.println("Student removed: " + student.getFirstName() + " " + student.getLastName());
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }

    public void displayStudentInformation(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                System.out.println("================================================================");
                System.out.println("|\t\t\t\t\t\t\t\t\t|");
                System.out.println("|\t\t     STUDENT INFORMATION\t\t\t|");
                System.out.println("|\t\t\t\t\t\t\t\t\t|");
                System.out.println("|Name:............................." + student.getFirstName() + " " + student.getLastName());
                System.out.println("|ID:..............................." + student.getId());
                System.out.println("|Address:.........................." + student.getAddress());
                System.out.println("|College:.........................." + student.getCollege());
                System.out.println("|Department:......................." + student.getDepartment());
                System.out.println("|Student Type:....................." + getStudentType(student.getDepartment()));
                System.out.println("|\t\t\t\t\t\t\t\t\t|");

                return;
            }
        }
        System.out.println("Sorry, student not found with ID: " + studentId);
    }

    private String getStudentType(String department) {
        if (department.equalsIgnoreCase("distance")) {
            return "Distance Education";
        } else {
            return "Regular";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║                                              ║");
            System.out.println("║         Welcome to the Student Registration  ║");
            System.out.println("║                  System                      ║");
            System.out.println("║          prepared by Abdi Debela             ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.println("------------------------------------------------");
            System.out.println();

            while (true) {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Add a new student");
                System.out.println("2. Remove a student");
                System.out.println("3. Display student information");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    switch (choice) {
                        case 1:
                            System.out.print("Enter student first name: ");
                            String firstName = scanner.nextLine();

                            System.out.print("Enter student last name: ");
                            String lastName = scanner.nextLine();

                            String id;
                            while (true) {
                                System.out.print("Enter student ID (e.g., 0000/00): ");
                                id = scanner.nextLine();

                                if (id.matches("\\d+/\\d+")) {
                                    break;
                                } else {
                                    System.out.println("Invalid ID format. Please enter the ID in the correct format (e.g., number/year).");
                                }
                            }

                            System.out.print("Enter student college: ");
                            String college = scanner.nextLine();

                            System.out.print("Enter student department : ");
                            String department = scanner.nextLine();

                            System.out.print("Enter student address: ");
                            String address = scanner.nextLine();

                            Student student = new Student(firstName, lastName, id, address, department, college);
                            registrationSystem.addStudent(student);
                            break;

                        case 2:
                            System.out.print("Enter student ID to remove: ");
                            String removeId = scanner.nextLine();

                            registrationSystem.removeStudent(removeId);
                            break;

                        case 3:
                            System.out.print("Enter student ID to display information: ");
                            String displayId = scanner.nextLine();

                            registrationSystem.displayStudentInformation(displayId);
                            break;

                        case 4:
                            System.out.println("Exiting the program...");
                            System.exit(0);

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}