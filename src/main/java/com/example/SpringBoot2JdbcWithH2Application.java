package com.example;

import com.example.student.Student1;
import com.example.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.student.Student;
import com.example.student.StudentJdbcRepository;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentJdbcRepository repository;

    @Autowired
    StudentRepository repository1;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Student id 10001 -> {}", repository.findById(10001L));

        logger.info("Inserting -> {}", repository.insert(new Student(10010L, "John", "A1234657")));

        logger.info("Update 10003 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));

        repository.deleteById(10002L);

        logger.info("All users -> {}", repository.findAll());



        //JPA work here
        logger.info("Student id 10001 -> {}", repository1.findById(10001L));

        logger.info("Inserting -> {}", repository1.save(new Student1(10010L, "John", "A1234657")));

        logger.info("Update 10003 -> {}", repository1.save(new Student1(10001L, "Name-Updated", "New-Passport")));

        repository.deleteById(10002L);

        logger.info("All users -> {}", repository1.findAll());






    }
}