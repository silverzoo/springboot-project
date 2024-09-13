package com.elice.project.weeklytest.chapter12.entity;

public class SubjectPatchDto {
    private Long subjectId;
    private String name;
    private int price;

    public SubjectPatchDto() {
    }

    public SubjectPatchDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public SubjectPatchDto(Long subjectId, String name, int price) {
        this.subjectId = subjectId;
        this.name = name;
        this.price = price;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
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
