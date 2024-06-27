package com.reibax.api_rest.model.dto;

import jakarta.persistence.*;
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
public class ClienteDto implements Serializable {
    private int idCliente;
    private String name;
    private String surname;
    private String email;
    private Date register_date;
}
