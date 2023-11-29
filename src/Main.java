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
    private int semester;
    private int year;

    public Student(String firstName, String lastName, String id, String address, String department, String college, int semester, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        this.department = department;
        this.college = college;
        this.semester = semester;
        this.year = year;
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
        System.out.println("NAME: " + student.getFirstName().toUpperCase() + "     " + student.getLastName().toUpperCase());
        System.out.println("___________________Here is your slip---------------------------------");
        System.out.println("|Course--------------------------------------|ECTS|-----------|cr.hr.|-------Lectures");
        System.out.println("|course--1....................................| - |...........|  -   |.........|TBA");
        System.out.println("|course--2....................................| - |...........|  -   |.........|TBA");
        System.out.println("|course--3....................................| - |...........|  -   |.........|TBA");
        System.out.println("|course--4....................................| - |...........|  -   |.........|TBA");
        System.out.println("|course--5....................................| - |...........|  -   |.........|TBA");
        System.out.println("|course--6....................................| - |...........|  -   |.........|TBA");
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
                System.out.println("|Semester:........................." + student.getSemester());
                System.out.println("|Year:............................." + student.getYear());
                System.out.println("|\t\t\t\t\t\t\t\t\t|");

                return;
            }
        }
        System.out.println("Sorry, student not found with ID: " + studentId);
    }
}

public class Main{
    public static void main(String[] args) {
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSTUDENT REGISTRATION SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Student Information");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student first name: ");
                    String firstName = scanner.next();

                    System.out.print("Enter student last name: ");
                    String lastName = scanner.next();

                    System.out.print("Enter student ID: ");
                    String id = scanner.next();

                    System.out.print("Enter student address: ");
                    String address = scanner.next();

                    System.out.print("Enter student department: ");
                    String department = scanner.next();

                    System.out.print("Enter student college: ");
                    String college = scanner.next();

                    System.out.print("Enter student semester: ");
                    int semester = scanner.nextInt();

                    System.out.print("Enter student year: ");
                    int year = scanner.nextInt();

                    Student student = new Student(firstName, lastName, id, address, department, college, semester, year);
                    registrationSystem.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter student ID to remove: ");
                    String removeId = scanner.next();
                    registrationSystem.removeStudent(removeId);
                    break;

                case 3:
                    System.out.print("Enter student ID to display information: ");
                    String displayId = scanner.next();
                    registrationSystem.displayStudentInformation(displayId);
                    break;

                case 4:
                    System.out.println("Exiting program... Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}