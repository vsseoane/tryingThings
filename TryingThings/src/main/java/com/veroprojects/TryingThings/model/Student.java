package com.veroprojects.TryingThings.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal studentNumber;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<Review>();

    public Student(final int id,
                   final String name,
                   final BigDecimal studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;


    }
    public Student() {


    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getStudentNumber() {
        return this.studentNumber;
    }

    public void setId(int id) {
         this.id =id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentNumber(BigDecimal studentNumber) {
         this.studentNumber = studentNumber;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return this.name + " " + this.studentNumber;
    }

}
