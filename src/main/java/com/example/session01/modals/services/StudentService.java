package com.example.session01.modals.services;

import com.example.session01.modals.entities.Student;
import com.example.session01.modals.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    // Mục tiêu là để tiêm từ Spring Container
    @Autowired // Cơ chế tiêm DI Dependency Injection
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student updateStudent(Student student, Long id) {
        return studentRepository.updateStudent(student, id);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

}
