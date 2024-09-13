package com.elice.project.weeklytest.chapter12.entity;


public class SubjectPostDto {
    private String name;
    private int price;

    public SubjectPostDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public SubjectPostDto() {
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

    public Subject toEntity() {
        return new Subject(name, price);
    }
}
