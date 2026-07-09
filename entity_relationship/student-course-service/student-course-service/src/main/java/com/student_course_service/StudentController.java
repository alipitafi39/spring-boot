package com.student_course_service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Map<String, String> request) {
        return studentService.createStudent(request.get("name"));
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public StudentDTO enrollCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {
        return studentService.enrollCourse(studentId, courseId);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
}

