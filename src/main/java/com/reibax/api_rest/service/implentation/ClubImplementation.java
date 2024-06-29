package com.reibax.api_rest.service.implentation;

import com.reibax.api_rest.model.dao.ClubDao;
import com.reibax.api_rest.model.dto.ClubDto;
import com.reibax.api_rest.model.entity.Club;
import com.reibax.api_rest.service.IclubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ClubImplementation implements IclubService {
    @Autowired
    private ClubDao clubDao;
    @Override
    public Club save(ClubDto clubDto) {
       return clubDao.save(Club.fromDto(clubDto));
    }
    @Transactional(readOnly = true)
    @Override
    public Club findById(int id) {
        return clubDao.findById(id).orElse(null);
    }

    @Override
    public Club update(ClubDto clubDto) {
        return clubDao.save(Club.fromDto(clubDto));
    }

    @Override
    public void delete(ClubDto clubDto) {
        clubDao.deleteById(clubDto.getIdClub());
    }

    @Override
    public boolean existsById(int id) {
        return !clubDao.existsById(id);
    }

    @Override
    public List<Club> findAll() {
        return (List<Club>) clubDao.findAll();
    }

    @Override
    public List<Club> findByClubByYears(int yearsInCompeticion) {
        return clubDao.findByYearsInCompeticion(yearsInCompeticion);

    }
}
