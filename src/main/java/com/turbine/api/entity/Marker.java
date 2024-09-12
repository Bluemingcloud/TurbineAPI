package com.turbine.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MARKER")
@EntityListeners(AuditingEntityListener.class)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno; // PK

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regdate;

    @CreatedDate
    @Column(updatable = true)
    private LocalDateTime update;

    private Long degree;
    private Double latitude;
    private Double longitude;
    private Long bno;
    private String model;
}
