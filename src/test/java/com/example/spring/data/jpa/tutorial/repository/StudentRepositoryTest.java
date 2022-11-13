package com.example.spring.data.jpa.tutorial.repository;

import com.example.spring.data.jpa.tutorial.entity.Guardian;
import com.example.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("sumanshuanand01@gmail.com")
                .firstName("Sumanshu0101")
                .lastName("Anand")
                //.guardianName("Manoj Kumar")
                //.guardianEmail("manoj@gmail.com")
                //.guardianMobile("999999999")
                .build();

        //studentRepository.save(student);
    }

    @Test
    public void saveStudentWithguardian() {

        Guardian guardian = Guardian.builder()
                .email("manoj@gmail.com")
                .name("Manoj Kumar")
                .mobile("9999999999")
                .build();


        Student student = Student.builder()
                .firstName("Shivam0505")
                .lastName("Kumar")
                .emailId("shivam@gmail.com")
                .guardian(guardian)
                .build();
        //studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Shivam");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Sh");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedonGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Manoj");
        System.out.println("students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("sumanshuanand@gmail.com");
        System.out.println("Student = "+student);
    }
    @Test
    public void printgetStudentByEmailAddressNativeParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeParam("sumanshuanand01@gmail.com");
        System.out.println("Studemt = "+ student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Sulekha",
                "sumanshuanand01@gmail.com");

    }
}