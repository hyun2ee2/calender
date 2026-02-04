package com.caleander.schedule.controller;


import com.caleander.schedule.dto.*;
import com.caleander.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calender")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // POST
    @PostMapping
    public ResponseEntity<CreateScheduleResponse> crateSchedule(@RequestBody CreateScheduleRequest request) {
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 작성자 일정 전체 불러오기 GET
    @GetMapping("/{author}")
    public ResponseEntity<List<GetOneScheduleResponse>> getByAuthor(
            @PathVariable String author) {
        List<GetOneScheduleResponse> result = scheduleService.getByAuthor(author);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<UpdateScheduleResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequest request
    ) {
        UpdateScheduleResponse result = scheduleService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            @RequestBody DeleteScheduleRequest request
    ) {
        scheduleService.delete(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
