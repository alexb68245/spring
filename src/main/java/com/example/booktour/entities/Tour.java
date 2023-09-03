package com.example.booktour.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "tour_name")
    private String tourName;

    @Column(name = "tour_duration")
    private int tourDuration;

    @Column(name = "tour_price")
    private int tourPrice;
}
