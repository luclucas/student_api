package com.luluog.userapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )

    private long id;
    private String name;
    private String email;
    private LocalDate dateBirth;

    @Transient
    private Integer age;

    public Student() {
    }

    public Student(long id, String name, String email, LocalDate dateBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateBirth = dateBirth;

        this.age = age;
    }

    public Student(String name, String email, LocalDate dateBirth) {
        this.name = name;
        this.email = email;
        this.dateBirth = dateBirth;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Integer getAge() {

        return Period.between(this.dateBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
