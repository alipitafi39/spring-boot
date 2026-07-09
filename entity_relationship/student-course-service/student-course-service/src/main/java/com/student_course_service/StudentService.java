package com.student_course_service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student createStudent(String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.save(student);
    }

//    public Student enrollCourse(Long studentId, Long courseId) {
//        Student student = studentRepository.findById(studentId)
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//
//        Course course = courseRepository.findById(courseId)
//                .orElseThrow(() -> new RuntimeException("Course not found"));
//
//        student.getCourses().add(course);
//        return studentRepository.save(student);
//    }
    
    public StudentDTO enrollCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);
        studentRepository.save(student);

        return mapToDTO(student);   // ✅ return DTO
    }


    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    private StudentDTO mapToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setCourses(
                student.getCourses()
                        .stream()
                        .map(Course::getTitle)
                        .collect(Collectors.toSet())
        );
        return dto;
    }
}


