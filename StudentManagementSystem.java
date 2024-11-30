import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private ArrayList<Integer> grades;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? (double) sum / grades.size() : 0.0;
    }

    public void printGrades() {
        System.out.println("Grades for " + name + ": " + grades);
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void clearGrades() {
        grades.clear();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Average Grade: " + getAverageGrade();
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    addGradeToStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Student Management System:");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Add Grade to Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents() {
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void addGradeToStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine(); // consume newline
            student.addGrade(grade);
            System.out.println("Grade added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            student.updateName(name);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void exit() {
        System.out.println("Exiting Student Management System. Goodbye!");
        System.exit(0);
    }

    private static Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}
