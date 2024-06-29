package com.reibax.api_rest.service;

import com.reibax.api_rest.model.dto.RemeroDto;
import com.reibax.api_rest.model.entity.Remero;

import java.util.List;

public interface IremeroService {
    // CRUD
    // Create
    Remero save(RemeroDto remeroDto);
    // Read
    Remero findById(int id);
    // Update
    Remero update(RemeroDto remeroDto);
    // Delete
    void delete(RemeroDto remeroDto);

    boolean existsById(int id);

    List<Remero> findAll();

    List<Remero> findByClub(int idClub);
}
