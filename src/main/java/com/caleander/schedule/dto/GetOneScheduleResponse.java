package com.caleander.schedule.dto;


import lombok.Getter;

@Getter
public class GetOneScheduleResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public GetOneScheduleResponse(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}