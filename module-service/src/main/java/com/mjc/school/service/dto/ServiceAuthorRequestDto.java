package com.mjc.school.service.dto;


public class ServiceAuthorRequestDto {
    private Long id;
    private String name;

    public ServiceAuthorRequestDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ServiceAuthorRequestDto() {
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
