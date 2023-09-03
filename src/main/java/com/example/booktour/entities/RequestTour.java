package com.example.booktour.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "request")
public class RequestTour {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "date")
    private Date requestDate;

    @Column(name = "approved")
    private boolean isApproved;
}
