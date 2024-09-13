package com.elice.project.weeklytest.chapter12.entity;

public class SubjectResponseDto {
    private long subjectId;
    private String name;
    private int price;

    public SubjectResponseDto() {
    }

    public SubjectResponseDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public SubjectResponseDto(long subjectId, String name, int price) {
        this.subjectId = subjectId;
        this.name = name;
        this.price = price;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
