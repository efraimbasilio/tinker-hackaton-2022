package com.example.mycrud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDate;
//@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblDevices")
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Integer status;

    @Column(name = "relay_name")
    private String relayName;

    @Column(name = "type")
    private String type;

    @Column(name = "schedule_on")
    private LocalDate scheduleOn;

    @Column(name = "schedule_off")
    private LocalDate scheduleOff;

    @Column(name = "idle_status")
    private Integer idleStatus;

}
