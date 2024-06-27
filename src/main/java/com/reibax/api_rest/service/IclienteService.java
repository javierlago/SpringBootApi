package com.reibax.api_rest.service;

import com.reibax.api_rest.model.dto.ClienteDto;
import com.reibax.api_rest.model.entity.Cliente;

import java.util.List;

public interface IclienteService {
    // CRUD
    // Create
    Cliente  save(ClienteDto clienteDto);
    // Read
    Cliente findById(int id);
    // Update
    Cliente update(ClienteDto clienteDto);
    // Delete
    void delete(ClienteDto clienteDto);

    boolean existsById(int id);

    List<Cliente> findAll();
}
