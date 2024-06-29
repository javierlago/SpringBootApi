package com.reibax.api_rest.service.implentation;
import com.reibax.api_rest.model.dao.RemeroDao;
import com.reibax.api_rest.model.dto.RemeroDto;
import com.reibax.api_rest.model.entity.Club;
import com.reibax.api_rest.model.entity.Remero;
import com.reibax.api_rest.service.IremeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Service
public class RemeroImplementation implements IremeroService {
    @Autowired
    private RemeroDao remeroDao;


    @Transactional
    @Override
    public Remero save(RemeroDto remeroDto) {
       return remeroDao.save(Remero.fromDto(remeroDto));
    }
    @Transactional(readOnly = true)
    @Override
    public Remero findById(int id) {
        return remeroDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Remero update(RemeroDto remeroDto) {
       return remeroDao.save(Remero.fromDto(remeroDto));
    }
    @Transactional
    @Override
    public void delete(RemeroDto remeroDto) {
        remeroDao.deleteById(remeroDto.getIdRemero());
    }

    @Override
    public boolean existsById(int id) {
        return remeroDao.existsById(id);
    }

    @Override
    public List<Remero> findAll() {
        return (List<Remero>) remeroDao.findAll();
    }

    @Override
    public List<Remero> findByClub(int idClub) {
        return remeroDao.findByClub_IdClub(idClub);
    }


}


