package com.caleander.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class CreateScheduleRequest {

    private String title;
    private String content;
    private String author;
    private String password;

}
