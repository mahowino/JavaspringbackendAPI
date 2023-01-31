package com.example.demo;

import com.example.demo.Models.Student;
import com.example.demo.Models.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mahalon=new Student(
                    "Mahalon",
                    "Mahowino@gmail.com",
                    LocalDate.of(2000, Month.AUGUST,15)

            );
           Student owino= new Student(
                    "owino",
                    "Maho@gmail.com",
                    LocalDate.of(2000, Month.AUGUST,15)

            );

            Student ochieng=new Student(
                    "Ochieng",
                    "Mahowino@gmail.com",
                    LocalDate.of(2000, Month.AUGUST,15)

            );

            repository.saveAll(
                    List.of(mahalon,owino,ochieng)
            );

        };
    }
}
