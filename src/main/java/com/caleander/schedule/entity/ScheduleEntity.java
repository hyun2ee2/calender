package com.caleander.schedule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.awt.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class ScheduleEntity {

    // 사용자 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 일정 제목(1글자 이상 30자 이내)
    @Column(length = 30, nullable = false)
    @Size(min = 1, max = 30)
    @NotBlank
    private String title;

    // 일정 내욜(1글자 이상 200자 이내)
    @Column(length = 200, nullable = false)
    @Size(min = 1, max = 200)
    @NotBlank
    private String content;

    // 작성자명(1글자 이상 20자 이내)
    @Column(length = 20, nullable = false)
    @Size(min = 1, max = 20)
    @NotBlank
    private String author;

    // 비밀번호(5글자 이상 30자 이내)
    @Column(length = 30, nullable = false)
    @Size(min = 5, max = 30)
    @NotBlank
    private String password;

    // 일정 생성일
    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    // 일정 수정일
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ScheduleEntity(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }
}
