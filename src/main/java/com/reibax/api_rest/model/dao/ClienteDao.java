package com.reibax.api_rest.model.dao;

import com.reibax.api_rest.model.dto.ClienteDto;
import com.reibax.api_rest.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
/*
* ClienteDao es una interfaz que extiende de CrudRepository con
*  dos parametros, el primero es la entidad Cliente
* y el segundo es el tipo de dato de la llave primaria de la entidad Cliente.
* */
public interface ClienteDao extends CrudRepository<Cliente, Integer> {

}
