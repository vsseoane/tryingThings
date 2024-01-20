package com.veroprojects.TryingThings.model;

import java.math.BigDecimal;

public class Student {

    private final String id;
    private final String name;
    private final BigDecimal studentNumber;

    public Student(final String id,
                   final String name,
                   final BigDecimal studentNumber) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;


    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getStudentNumber() {
        return this.studentNumber;
    }

    @Override
    public String toString() {
        return this.name + " " + this.studentNumber;
    }

}
