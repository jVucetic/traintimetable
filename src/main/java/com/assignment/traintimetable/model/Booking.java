package com.assignment.traintimetable.model;

import com.assignment.traintimetable.util.UUIDGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
public class Booking {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "timetable_id", nullable = false)
    private Timetable timetable;

    @Column(name = "is_reserved")
    private Boolean isReserved;

    @Builder
    public Booking(UUID id, User user, Timetable timetable, Boolean isReserved) {
        this.id = id != null ? id : UUIDGenerator.generateUUID();
        this.user = user;
        this.timetable = timetable;
        this.isReserved = isReserved;
    }
}
