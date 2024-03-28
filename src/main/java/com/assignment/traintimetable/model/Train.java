package com.assignment.traintimetable.model;


import com.assignment.traintimetable.util.UUIDGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "train")
@Getter
@Setter
@NoArgsConstructor
public class Train {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "description")
    private String description;

    @Column(name = "serial_number", nullable = false)
    private Integer serialNumber;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Builder
    public Train(UUID id, String name, Integer capacity, String description, Integer serialNumber, String manufacturer) {
        this.id = id != null ? id : UUIDGenerator.generateUUID();
        this.name = name;
        this.capacity = capacity;
        this.description = description;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
    }

}
