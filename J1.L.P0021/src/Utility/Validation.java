package Utility;

import java.util.ArrayList;
import java.util.Scanner;
import model.Student;

public class Validation {
    private final static Scanner in = new Scanner(System.in);

    // Check user input string (non-empty)
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.print("Input must not be empty. Enter again: ");
            } else {
                return result;
            }
        }
    }

    // Check input Y/N
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.print("Please input Y or N. Enter again: ");
        }
    }

    // Check input U/D (Update/Delete)
    public static boolean checkInputUD() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.print("Please input U or D. Enter again: ");
        }
    }

    // Check valid course input
    public static String checkInputCourse() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c")
                    || result.equalsIgnoreCase("c++")) {
                return result;
            }
            System.err.print("Course must be one of: Java, .Net, C, C++. Enter again: ");
        }
    }

    // Check if student already exists in list
    public static boolean checkStudentExist(ArrayList<Student> list, String id,
                                            String studentName, String semester, String courseName) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return true; // Student exists
            }
        }
        return false; // Student does not exist
    }

    // Check if ID exists with different name (for validation when updating/inserting)
    public static boolean checkIdExist(ArrayList<Student> list, String id, String name) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return true; // ID exists but with different name
            }
        }
        return false;
    }

    // Check if information has changed
    public static boolean checkChangeInformation(Student student, String id,
                                                 String name, String semester, String course) {
        return !(id.equalsIgnoreCase(student.getId())
                && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName()));
    }
}
