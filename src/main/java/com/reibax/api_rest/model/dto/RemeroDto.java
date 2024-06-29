package com.reibax.api_rest.model.dto;

import com.reibax.api_rest.model.entity.Club;
import com.reibax.api_rest.model.entity.Remero;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/*
* Clase que se utiliza para manejar operaciones de la entidad Cliente.Es una clase espejo de la entidad Cliente.
* Se utiliza para enviar y recibir datos de la entidad Cliente.
* Se podria decir que es como una clase intermediaria entre la entidad Cliente y el controlador.
* */
@Data
@ToString
@Builder
public class RemeroDto implements Serializable {
    private int idRemero;
    private String name;
    private String surname;
    private String position;
    private int years;
    private boolean own;
    private Date registerDate;
    private Date dateOfBirth;
    private Club club;

    public static RemeroDto fromEntity(Remero remero) {
        return RemeroDto.builder()
                .idRemero(remero.getIdRemero())
                .name(remero.getName())
                .surname(remero.getSurname())
                .position(remero.getPosition())
                .years(remero.getYears())
                .own(remero.isOwn())
                .registerDate(remero.getRegister_date())
                .dateOfBirth(remero.getDateOfBirth())
                .club(remero.getClub())
                .build();

    }
}