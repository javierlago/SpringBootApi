package com.reibax.api_rest.model.dao;

import com.reibax.api_rest.model.entity.Remero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
* ClienteDao es una interfaz que extiende de CrudRepository con
*  dos parametros, el primero es la entidad Cliente
* y el segundo es el tipo de dato de la llave primaria de la entidad Cliente.
* */
public interface RemeroDao extends CrudRepository<Remero, Integer> {
    List<Remero> findByClub_IdClub(int idClub);
}
