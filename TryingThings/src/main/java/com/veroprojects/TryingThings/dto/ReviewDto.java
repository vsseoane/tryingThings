package com.veroprojects.TryingThings.dto;


public class ReviewDto {

    private int id;
    private String description;
    private int score;

    public ReviewDto(){}
    public ReviewDto(int id, String description, int score) {
        this.id = id;
        this.description = description;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
