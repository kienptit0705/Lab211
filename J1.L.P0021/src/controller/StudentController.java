package controller;

import java.util.ArrayList;
import java.util.HashMap;
import model.Student;
import service.StudentService;
import view.StudentView;

public class StudentController {
    private Student student = new Student();
    private StudentView studentView = new StudentView();
    private StudentService studentService = new StudentService();

    // Nhận dữ liệu đầu vào cho student
    public void setInputStudent(Student student) {
        this.student = student;
    }
    

    // Hiển thị danh sách sinh viên
    public void displayStudent() {
        ArrayList<Student> listStudent = studentService.getListStudent();
        if (listStudent.isEmpty()) {
            studentView.setHeader("No student found.");
            studentView.displayHeader();
            return;
        }

        String strHeader = String.format("%20s%20s%20s%20s\n", "ID", "Name", "Semester", "CourseName");
        studentView.setHeader(strHeader);
        studentView.displayHeader();

        for (Student s : listStudent) {
            studentView.setBody(s.toString());
            studentView.displayStudent();
        }
    }

    // Thêm sinh viên
    public void insertStudent() {
        if (studentService.insertStudent(student)) {
            studentView.setHeader("Insert Success!");
        } else {
            studentView.setHeader("Insert Failed! Duplicate entry.");
        }
        studentView.displayHeader();
    }

    // Tìm và sắp xếp sinh viên theo tên
    public void findAndSortStudentByName() {
        ArrayList<String> resultList = studentService.findAndSortStudentByName(student);
        if (resultList.isEmpty()) {
            studentView.setHeader("No matching student found.");
            studentView.displayHeader();
        } else {
            for (String s : resultList) {
                studentView.setBody(s);
                studentView.displayStudent();
            }
        }
    }

    // Cập nhật thông tin sinh viên
    public void updateStudent() {
        if (studentService.updateStudent(student)) {
            studentView.setHeader("Update Success!");
        } else {
            studentView.setHeader("Update Failed! ID not found.");
        }
        studentView.displayHeader();
    }

    // Xoá sinh viên
    public void deleteStudent() {
        if (studentService.deleteStudent(student)) {
            studentView.setHeader("Delete Success!");
        } else {
            studentView.setHeader("Delete Failed! ID not found.");
        }
        studentView.displayHeader();
    }

    // Báo cáo số lần đăng ký học phần
    public void reportStudent() {
        HashMap<String, Integer> reportMap = studentService.listReport();
        if (reportMap.isEmpty()) {
            studentView.setHeader("No report data available.");
            studentView.displayHeader();
        } else {
            studentView.setMap(reportMap);
            studentView.displayReport();
        }
    }

    // Hiển thị menu chính
    public void displayMainMenu() {
        StudentView.menu();
    }
}
