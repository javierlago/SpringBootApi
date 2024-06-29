package com.reibax.api_rest.model.entity;

import com.reibax.api_rest.model.dto.ClubDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Club")
public class Club {
    @Id
    @Column(name = "idClub")// anotacion para indicar el nombre del campo en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotacion para indicar que el campo sera autoincrementable
    private int idClub;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "comunity")
    private String comunity;
    @Column(name = "year_foundation")
    private int yearFoundation;
    @Column(name = "year_in_competition")
    private int yearInCompetition;
    @OneToMany(mappedBy = "club",cascade = CascadeType.ALL)
    private List<Remero> remeros;
    // metodo para buildear un objeto de tipo ClubDto a un objeto de tipo Club
    public static Club fromDto(ClubDto clubDto) {
        return Club.builder()
                .idClub(clubDto.getIdClub())
                .name(clubDto.getName())
                .city(clubDto.getCity())
                .province(clubDto.getProvince())
                .comunity(clubDto.getComunity())
                .yearFoundation(clubDto.getYearFoundation())
                .yearInCompetition(clubDto.getYearInCompetition())
                .remeros(clubDto.getRemeros())
                .build();
    }


}
