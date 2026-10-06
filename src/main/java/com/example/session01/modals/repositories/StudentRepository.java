package com.example.session01.modals.repositories;

import com.example.session01.modals.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

// Spring IOC + Spring DI

@Repository // Đánh dấu để khỏi tạo và cho vào Spring Container
public class StudentRepository {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1L, "Nguyễn Văn A", 18),
                    new Student(2L, "Phạm Văn M", 19),
                    new Student(3L, "Trần Minh C", 17),
                    new Student(4L, "Nguyễn Nhật M", 22),
                    new Student(5L, "Nguyễn Huy K", 25)
            )
    );

    public List<Student> findAll() {
        return students;
    }

    public Student addStudent(Student student) {
        // Xử lý id tự tăng được đây ? --> tìm ra id max sau đó + 1

        Optional<Student> studentMaxId = students.stream().max(Comparator.comparingLong(Student::getId));

        Long nextId = studentMaxId.isPresent() ? studentMaxId.get().getId() + 1 : 1;

        student.setId(nextId);

        students.add(student);

        return student;
    }

    public Student updateStudent(Student student, Long id) {
        // Quy trình:
        /*
            B1: Tìm đối tượng có tồn tại hay không thông qua id
            B2: nếu không thì thông báo lỗi
            B3: nếu có thì gán các giá trị mới ở body gửi lên cho đối tượng cần cập nhật
            B4: Cập nhật vào danh sách sản phẩm
        */

        Student oldStudent = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (oldStudent != null) {
            oldStudent.setName(student.getName());
            oldStudent.setAge(student.getAge());
        } else {
            System.err.println("Không tồn tại sinh viên");
            return null;
        }
        return oldStudent;
    }

    public void deleteStudent(Long id) {
        Student oldStudent = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(oldStudent != null) {
            students.remove(oldStudent);
        } else {
            System.err.println("Không tòn tại sinh viên");
        }

    }

}
