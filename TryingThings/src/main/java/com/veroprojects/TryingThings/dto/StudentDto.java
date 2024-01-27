package com.veroprojects.TryingThings.dto;

import java.math.BigDecimal;

public class StudentDto {

    private int id;
    private String name;
    private BigDecimal studentNumber;

    public StudentDto() {}
    public StudentDto(String name, BigDecimal studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getStudentNumber() {
        return studentNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentNumber(BigDecimal studentNumber) {
        this.studentNumber = studentNumber;
    }
}
