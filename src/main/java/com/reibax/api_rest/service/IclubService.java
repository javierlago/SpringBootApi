package com.reibax.api_rest.service;

import com.reibax.api_rest.model.dto.ClubDto;
import com.reibax.api_rest.model.entity.Club;

import java.util.List;

public interface IclubService {
    // CRUD
    // Create
    Club save(ClubDto clubDto);
    // Read
    Club findById(int id);
    // Update
    Club update(ClubDto clubDto);
    // Delete
    void delete(ClubDto clubDto);

    boolean existsById(int id);

    List<Club> findAll();

    List<Club> findByClubByYears(int idClub);
    List <Club> findByYearInCompetitionGreaterThan(int yearInCompetition);
    List <Club> findByYearInCompetitionLessThan(int yearInCompetition);

}
