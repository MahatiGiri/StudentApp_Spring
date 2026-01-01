package com.example.StudentApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    @SequenceGenerator(name="student_seq",initialValue = 1,allocationSize = 1)
    private int id;
    @NotBlank(message = "Enter your name here")
    private String name;
    @Email
    private String email;
    @NotBlank(message = "This field is required")
    private String branch;
    @NotBlank(message = "Enter your city here")
    private String city;
    @NotBlank(message = "This field is required")
    private String course;
    @Min(2500)
    private int fees;

    public StudentEntity() {
    }

    public StudentEntity(String name, String email, String branch, String city, String course, int fees) {
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.city = city;
        this.course = course;
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", city='" + city + '\'' +
                ", course='" + course + '\'' +
                ", fees=" + fees +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
}
