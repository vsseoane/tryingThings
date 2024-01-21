package com.veroprojects.TryingThings.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal studentNumber;

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

    @Override
    public String toString() {
        return this.name + " " + this.studentNumber;
    }

}
