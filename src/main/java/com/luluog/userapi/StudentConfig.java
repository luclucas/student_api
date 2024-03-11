package com.luluog.userapi;

import com.luluog.userapi.model.Student;
import com.luluog.userapi.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return  args -> {
            Student ana = new Student("Ana", "ana@mail",
                    LocalDate.of(2004, Month.APRIL, 9));

      //      repository.save(ana);
        };
    }
}
