package com.example.spring.data.jpa.tutorial.repository;

import com.example.spring.data.jpa.tutorial.entity.Course;
import com.example.spring.data.jpa.tutorial.entity.Student;
import com.example.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses =" + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Anand")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPagewithTwoRecords =
                PageRequest.of(0,2);

        List<Course> courses = courseRepository.findAll(secondPagewithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(secondPagewithTwoRecords).getTotalElements();

        long totalPages = courseRepository.findAll(secondPagewithTwoRecords).getTotalPages();
        System.out.println("totalPages ="+ totalPages);
        System.out.println("totalElements ="+totalElements);

        System.out.println("courses = "+courses);
    }
    @Test
    public void findallSorting(){
        Pageable sortBytitle =
                PageRequest.of(0,2,Sort.by("title"));
        Pageable sortByCredit =
                PageRequest.of(0,22,Sort.by("credit").descending());
        Pageable sortByTitleAndDescending =
                PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("credit").descending()));
        List<Course> courses = courseRepository.findAll(sortBytitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCoursewithStudentandTeache(){

        Teacher teacher = Teacher.builder()
                .firstName("Sulekha")
                .lastName("Anand")
                .build();
        Student student = Student.builder()
                .firstName("Simran")
                .lastName("Anand")
                .emailId("simrananand@gmail.com")
                .build();
    Course course =Course.builder()
            .title("AI ML")
            .credit(12)
            .teacher(teacher)
            .build();
            course.addStudents(student);

            courseRepository.save(course);
    }
}