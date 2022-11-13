package com.example.spring.data.jpa.tutorial.repository;

import com.example.spring.data.jpa.tutorial.entity.Course;
import com.example.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void printTeacher(){
        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course course1 = Course.builder()
                .title("Java")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Vicky")
                .lastName("Anand")
                //.courses(List.of(course,course1))
                .build();

        teacherRepository.save(teacher);
    }
}