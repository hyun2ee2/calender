package com.caleander.schedule.repository;

import com.caleander.schedule.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
    Optional<ScheduleEntity> findByAuthor(String author);

    List<ScheduleEntity> findAllByAuthor(String author);
}



