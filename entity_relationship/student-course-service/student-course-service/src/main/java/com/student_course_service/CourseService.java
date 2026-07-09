package com.student_course_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(String title) {
        Course course = new Course();
        course.setTitle(title);
        return courseRepository.save(course);
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    private CourseDTO mapToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        return dto;
    }
}

