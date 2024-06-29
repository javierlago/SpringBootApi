package com.reibax.api_rest.controller;

import com.reibax.api_rest.model.Payload.MensageResponse;
import com.reibax.api_rest.model.dto.ClubDto;
import com.reibax.api_rest.model.entity.Club;
import com.reibax.api_rest.service.IclubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Anotación que indica que esta clase es un controlador.Ineternamente esta anotación incluye @Controller y @ResponseBody
@RequestMapping("/api/v1/")
public class ClubController {
    @Autowired
    private IclubService clubService;

    @PostMapping("club")
    public ResponseEntity<?> create(@RequestBody ClubDto clubDto) {
        Club clubSave = null;
        try {
            clubSave = clubService.save(clubDto);
            ClubDto savedClubDto = ClubDto.fromEntity(clubSave);
            return new ResponseEntity<>(MensageResponse.fromData("Club creado", savedClubDto), org.springframework.http.HttpStatus.CREATED);
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("club")
    // Anotación que indica que el método manejará las solicitudes HTTP PUT utilizada para actualizar recursos
    public ResponseEntity<?> update(@RequestBody ClubDto clubDto) {
        Club clubUpdate;
        try {
            if (this.clubService.existsById(clubDto.getIdClub())) {
                return new ResponseEntity<>(MensageResponse.fromData("No se ha encontrado el club con id " + clubDto.getIdClub(), clubDto), HttpStatus.OK);
            }
            clubUpdate = clubService.update(clubDto);
            ClubDto savedClubDto = ClubDto.fromEntity(clubUpdate);
            return new ResponseEntity<>(MensageResponse.fromData("Club actualizado correctamente", savedClubDto), HttpStatus.OK);
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("club/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            if (this.clubService.existsById(id)) {
                return new ResponseEntity<>(MensageResponse.fromData("No se ha encontrado el club con id " + id, null), HttpStatus.OK);
            }
            Club club = this.clubService.findById(id);
            ClubDto clubDelete = ClubDto.fromEntity(club);
            clubService.delete(clubDelete);
            return new ResponseEntity<>(MensageResponse.fromData("Club eliminado correctamente", clubDelete), HttpStatus.OK);
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("club/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            if (this.clubService.existsById(id)) {
                return new ResponseEntity<>(MensageResponse.fromData("No se ha encontrado el club con id " + id, null), HttpStatus.OK);
            }
            Club club = this.clubService.findById(id);
            ClubDto clubDto = ClubDto.fromEntity(club);
            return new ResponseEntity<>(MensageResponse.fromData("Club encontrado", clubDto), HttpStatus.OK);
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("clubs")
    public ResponseEntity<?> findAll() {
        try {
            List<Club> clubs = this.clubService.findAll();
            if (clubs.isEmpty()) {
                return new ResponseEntity<>(MensageResponse.fromData("No hay clubes", null), HttpStatus.OK);
            }else {
            return new ResponseEntity<>(MensageResponse.fromData("Lista de clubes", this.clubService.findAll()), HttpStatus.OK);
            }
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("clubs/equal/{yearsInCompetition}")
    public ResponseEntity<?> getClubsByYearsInCompetition(@PathVariable int yearsInCompetition) {
        try {
            List<Club> clubs = this.clubService.findByClubByYears(yearsInCompetition);
            if (clubs.isEmpty()) {
                return new ResponseEntity<>(MensageResponse.fromData("No hay clubes con " + yearsInCompetition + " años en competición", null), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(MensageResponse.fromData("Lista de clubes con " + yearsInCompetition + " años en competición", clubs), HttpStatus.OK);
            }
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("clubs/greater/{yearsInCompetition}")
    public ResponseEntity<?> getClubsByYearsInCompetitionGreaterThan(@PathVariable int yearsInCompetition) {
        try {
            List<Club> clubs = this.clubService.findByYearInCompetitionGreaterThan(yearsInCompetition);
            if (clubs.isEmpty()) {
                return new ResponseEntity<>(MensageResponse.fromData("No hay clubes con más de " + yearsInCompetition + " años en competición", null), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(MensageResponse.fromData("Lista de clubes con más de " + yearsInCompetition + " años en competición", clubs), HttpStatus.OK);
            }
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("clubs/less/{yearsInCompetition}")
    public ResponseEntity<?> getClubsByYearsInCompetitionLessThan(@PathVariable int yearsInCompetition) {
        try {
            List<Club> clubs = this.clubService.findByYearInCompetitionLessThan(yearsInCompetition);
            if (clubs.isEmpty()) {
                return new ResponseEntity<>(MensageResponse.fromData("No hay clubes con menos de " + yearsInCompetition + " años en competición", null), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(MensageResponse.fromData("Lista de clubes con menos de " + yearsInCompetition + " años en competición", clubs), HttpStatus.OK);
            }
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

}
