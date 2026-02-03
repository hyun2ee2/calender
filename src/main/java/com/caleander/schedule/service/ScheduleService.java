package com.caleander.schedule.service;

import com.caleander.schedule.dto.*;
import com.caleander.schedule.entity.ScheduleEntity;
import com.caleander.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository repository;

    // 저장
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        ScheduleEntity schedule = new ScheduleEntity(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        ScheduleEntity savedSchedule = repository.save(schedule);

        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getAuthor()
        );
    }

    // 단 건 조회
    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOne(String author) {
        ScheduleEntity schedule = repository.findByAuthor(author)
                .orElseThrow(() -> new IllegalArgumentException("해당 작성자의 일정이 없습니다."));

        return new GetOneScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor()
        );
    }

    // 다 건 조회
    @Transactional(readOnly = true)
    public List<GetOneScheduleResponse> getAll() {
        List<ScheduleEntity> scheduleEntities = repository.findAll();

        List<GetOneScheduleResponse> dtos = new ArrayList<>();
        for(ScheduleEntity scheduleEntity : scheduleEntities) {
            GetOneScheduleResponse dto = new GetOneScheduleResponse(
                    scheduleEntity.getId(),
                    scheduleEntity.getTitle(),
                    scheduleEntity.getContent(),
                    scheduleEntity.getAuthor()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    // 수정
    @Transactional
    public UpdateScheduleResponse update(Long scheduled, UpdateScheduleRequest request) {
        ScheduleEntity schedule = repository.findById(scheduled).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 작성자입니다.")
        );
        schedule.update(
                request.getTitle(),
                request.getAuthor()
        );
        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getAuthor()
        );
    }

    // 삭제
    @Transactional
    public void delete(Long scheduled) {
        boolean existence = repository.existsById(scheduled);

        // 작성자명이 존재하지 않을 경우
        if(!existence) {
            throw new IllegalArgumentException("존재하지 않는 작성자입니다.");
        }
        // 작성자가 존재할 경우
        repository.deleteById(scheduled);
    }
}
