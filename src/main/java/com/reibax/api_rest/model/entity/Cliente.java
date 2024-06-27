package com.reibax.api_rest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/*
* Clase que se utiliza para mapear la entidad Cliente de la base de datos.
* Con esta clase describimos como sera nuestra tabla en la base de datos y como se relacionan los campos de la tabla.
* Las anotaciones indican que tendra una llave primaria, que sera autoincrementable y que se llamara idCliente.
* Tambien se indica que la tabla se llamara cliente.
* Se utiliza lombok para generar los metodos getter, setter, toString, equals y hashcode.
* Se utiliza la anotacion @Builder para generar un constructor con todos los parametros.
* Se implementa la interfaz Serializable para poder serializar la clase.
* Se utiliza la anotacion @Entity para indicar que es una entidad.
* Se utiliza la anotacion @Table para indicar el nombre de la tabla en la base de datos.
* Se utiliza la anotacion @Data para generar los metodos getter, setter, toString, equals y hashcode.
* Se utiliza la anotacion @AllArgsConstructor para generar un constructor con todos los parametros.
* Se utiliza la anotacion @NoArgsConstructor para generar un constructor vacio.
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @Column(name = "idcliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "register_date")
    private Date register_date;
}
