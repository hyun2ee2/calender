package com.caleander.schedule.repository;

import com.caleander.schedule.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    List<ScheduleEntity> findAllByAuthorOrderByUpdatedAtDesc(String author);

    List<ScheduleEntity> findAllByOrderByUpdatedAtDesc();
}



