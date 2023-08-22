package com.mjc.school.service.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ServiceAuthorResponseDto {
    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;

    public ServiceAuthorResponseDto(Long id, String name,
                                    LocalDateTime createDate, LocalDateTime lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public ServiceAuthorResponseDto() {
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        return "AuthorResponseDto[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + formatter.format(createDate) +
                ", lastUpdateDate=" + formatter.format(lastUpdateDate) +
                ']';
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
