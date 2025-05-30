package main;

import controller.StudentController;
import model.Student;
import Utility.Validation;

public class Main {

    public static void main(String[] args) {
        StudentController controller = new StudentController();
        
        // Add 10 students individually
        controller.setInputStudent(new Student("S001", "Alice", "Fall", "Java"));
        controller.insertStudent();
        controller.setInputStudent(new Student("S002", "Bob", "Fall", ".Net"));
        controller.insertStudent();
        controller.setInputStudent(new Student("S003", "Charlie", "Spring", "C++"));
        controller.insertStudent();
        controller.setInputStudent(new Student("S004", "David", "Summer", "Java"));
        controller.insertStudent();
        controller.setInputStudent(new Student("S005", "Eva", "Fall", "C"));
        controller.insertStudent();
        controller.setInputStudent(new Student("S006", "Frank", "Winter", "Java"));
        controller.insertStudent();
        controller.setInputStudent(new Student("S007", "Grace", "Spring", "C++"));
        controller.insertStudent();
        controller.setInputStudent(new Student("S008", "Hannah", "Fall", ".Net"));
        controller.insertStudent();
        controller.setInputStudent(new Student("S009", "Ian", "Summer", "Java"));
        controller.insertStudent();
        controller.setInputStudent(new Student("S010", "Judy", "Winter", "C"));
        controller.insertStudent();
       
        while (true) {
            controller.displayMainMenu();
            System.out.print("Enter your choice (1-6): ");
            String choice = Validation.checkInputString();

            switch (choice) {
                case "1":
                    // Add student
                    Student newStudent = inputStudent();
                    controller.setInputStudent(newStudent);
                    controller.insertStudent();
                    break;

                case "2":
                    // Find and sort
                    System.out.print("Enter student name to search: ");
                    String nameToSearch = Validation.checkInputString();
                    controller.setInputStudent(new Student("", nameToSearch, "", ""));
                    controller.findAndSortStudentByName();
                    break;

                case "3":
                    // Update/Delete student
                    System.out.print("Enter student ID: ");
                    String id = Validation.checkInputString();
                    Student temp = new Student();
                    temp.setId(id);
                    controller.setInputStudent(temp);

                    if (!askUpdateOrDelete()) {
                        // Delete
                        controller.deleteStudent();
                    } else {
                        // Update
                        Student updatedStudent = inputStudent();
                        updatedStudent.setId(id); // Keep ID unchanged
                        controller.setInputStudent(updatedStudent);
                        controller.updateStudent();
                    }
                    break;

                case "4":
                    // Display student list
                    controller.reportStudent();
                    break;

                case "5":
                    // Report
                    controller.reportStudent();
                    break;

                case "6":
                    // Exit
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.err.println("Invalid choice. Please choose 1-6.");
            }
            System.out.println("\nDo you want to continue? (Y/N): ");
            if (!Validation.checkInputYN()) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    // Nhập thông tin sinh viên từ người dùng
    private static Student inputStudent() {
        System.out.print("Enter student name: ");
        String name = Validation.checkInputString();

        System.out.print("Enter semester: ");
        String semester = Validation.checkInputString();

        System.out.print("Enter course (Java/.Net/C/C++): ");
        String course = Validation.checkInputCourse();

        System.out.print("Enter student ID: ");
        String id = Validation.checkInputString();

        return new Student(id, name, semester, course);
    }

    // Xác định cập nhật hay xóa
    private static boolean askUpdateOrDelete() {
        System.out.print("Do you want to Update (U) or Delete (D)? ");
        return Validation.checkInputUD(); // true: update, false: delete
    }
}
