package com.reibax.api_rest.model.dao;

import com.reibax.api_rest.model.entity.Club;
import com.reibax.api_rest.model.entity.Remero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClubDao extends CrudRepository<Club, Integer> {
    List<Club> findByYearsInCompeticion(int yearsInCompeticion);
    List<Club> findByYearInCompetitionGreaterThan(int yearInCompetition);
    List<Club> findByYearInCompetitionLessThan(int yearInCompetition);
}
