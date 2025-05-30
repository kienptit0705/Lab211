package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import model.Student;

public class StudentService {

    private ArrayList<Student> listStudent = new ArrayList<>();

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }
    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public HashMap<String, Integer> listReport() {
        HashMap<String, Integer> reportMap = new HashMap<>();
        HashSet<String> uniqueEnrollments = new HashSet<>();
        for (Student s : listStudent) {
            String id = s.getId();
            String course = s.getCourseName();
            String semester = s.getSemester();
            String name = s.getStudentName();
            // Key để tránh trùng: ID|Course|Semester
            String uniqueKey = id + "|" + course + "|" + semester;

            // Nếu đã thêm thì bỏ qua
            if (uniqueEnrollments.contains(uniqueKey)) {
                continue;
            }

            // Thêm key vào set
            uniqueEnrollments.add(uniqueKey);

            // Tạo key cho report
            String reportKey = String.format("%20s|%20s", name,course);
            // Cộng vào report
            reportMap.put(reportKey, reportMap.getOrDefault(reportKey, 0) + 1);
        }
        return reportMap;
    }

    // Insert a student
    public boolean insertStudent(Student newStudent) {
        for (Student existingStudent : listStudent) {
            if (existingStudent.getId().equalsIgnoreCase(newStudent.getId())
                    && existingStudent.getCourseName().equalsIgnoreCase(newStudent.getCourseName())
                    && existingStudent.getSemester().equalsIgnoreCase(newStudent.getSemester())) {
                // Student already enrolled in this course in this semester
                return false;
            }
        }
        listStudent.add(new Student(newStudent.getId(), newStudent.getStudentName(),
                newStudent.getSemester(), newStudent.getCourseName()));
        return true;
    }

    // Find and sort student by name
    public ArrayList<String> findAndSortStudentByName(Student searchStudent) {
        ArrayList<Student> result = new ArrayList<>();
        String keyword = searchStudent.getStudentName().toLowerCase();

        for (Student s : listStudent) {
            if (s.getStudentName().toLowerCase().contains(keyword)) {
                result.add(s);
            }
        }

        result.sort(Comparator.comparing(Student::getStudentName));

        ArrayList<String> finalResult = new ArrayList<>();
        for (Student s : result) {
            finalResult.add(s.toString());
        }
        return finalResult;
    }

    // Update student by ID
    public boolean updateStudent(Student updatedStudent) {
        for (Student s : listStudent) {
            if (s.getId().equalsIgnoreCase(updatedStudent.getId())) {
                s.setStudentName(updatedStudent.getStudentName());
                s.setSemester(updatedStudent.getSemester());
                s.setCourseName(updatedStudent.getCourseName());
                return true;
            }
        }
        return false;
    }

    // Delete student by ID
    public boolean deleteStudent(Student studentToDelete) {
        for (int i = 0; i < listStudent.size(); i++) {
            Student s = listStudent.get(i);
            if (s.getId().equalsIgnoreCase(studentToDelete.getId())) {
                listStudent.remove(i);
                return true;
            }
        }
        return false;
    }
}
