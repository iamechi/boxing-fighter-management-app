package com.boxing_app.boxing_fighter_management_app.model;

import jakarta.persistence.*;
import lombok.*;
//Entity class for the boxers table in the database
@Entity
@Table(name="boxers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fighterID;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="height")
    private double height;

    @Column(name="weight")
    private double weight;

    @Column(name="fights")
    private int fights;

    @Column(name="wins")
    private int wins;

    @Column(name="losses")
    private int losses;

    @Column(name="draws")
    private int draws;

    @Column(name="KOS")
    private int KOS;

    @Column(name="current_state_residence")
    private String current_state_residence;

    @Column(name="current_city_residence")
    private String current_city_residence;

    @Column(name="years_of_boxing")
    private int years_of_boxing;

    @Column(name="knockout_percentage")
    private double knockout_percentage;

    @Column(name="photo_attachment")
    private String photo_attachment;
}
