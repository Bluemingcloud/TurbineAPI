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
@Table(name = "BUSINESS")
@EntityListeners(AuditingEntityListener.class)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno; // PK

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regdate;

    @CreatedDate
    @Column(updatable = true)
    private LocalDateTime update;

    @Column(length = 2000)
    private String title;

    private String userName;

}
