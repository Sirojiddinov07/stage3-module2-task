package com.mjc.school.controller.dto;


public class AuthorRequestDto {
    private Long id;
    private String name;

    public AuthorRequestDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
