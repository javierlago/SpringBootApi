package com.reibax.api_rest.model.entity;

import com.reibax.api_rest.model.dto.RemeroDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Remero")
public class Remero implements Serializable {
    @Id
    @Column(name = "idRemero")// anotacion para indicar el nombre del campo en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotacion para indicar que el campo sera autoincrementable
    private int idRemero;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "position")
    String position;
    @Column(name = "years")
    int years;
    @Column(name = "own")
    boolean own;
    @Column(name = "register_date")
    private Date register_date;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;

    public static Remero fromDto(RemeroDto remeroDto) {
        return Remero.builder()
                .idRemero(remeroDto.getIdRemero())
                .name(remeroDto.getName())
                .surname(remeroDto.getSurname())
                .position(remeroDto.getPosition())
                .years(remeroDto.getYears())
                .own(remeroDto.isOwn())
                .register_date(remeroDto.getRegisterDate())
                .dateOfBirth(remeroDto.getDateOfBirth())
                .club(remeroDto.getClub())
                .build();
    }
}
