package com.reibax.api_rest.controller;

import com.reibax.api_rest.model.Payload.MensageResponse;
import com.reibax.api_rest.model.dto.RemeroDto;
import com.reibax.api_rest.model.entity.Remero;
import com.reibax.api_rest.service.IclubService;
import com.reibax.api_rest.service.IremeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RemeroController {
    @Autowired
    private IremeroService remeroService;
    @Autowired
    private IclubService clubService;

    @PostMapping("remero")
    public ResponseEntity<?>create(@RequestBody RemeroDto remeroDto) {
        Remero remeroSave = null;
        try {
            remeroSave = remeroService.save(remeroDto);
            RemeroDto savedRemeroDto = RemeroDto.fromEntity(remeroSave);
            return new ResponseEntity<>(MensageResponse.fromData("Remero creado",savedRemeroDto), HttpStatus.CREATED);
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(),null), HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("remero")
    public ResponseEntity<?>update(@RequestBody RemeroDto remeroDto) {
        Remero remeroUpdate;
            try {
                if (!this.remeroService.existsById(remeroDto.getIdRemero())) {
                    return new ResponseEntity<>(MensageResponse.fromData("No se ha encontrado el remero con id "+remeroDto.getIdRemero(),remeroDto), HttpStatus.OK);
                }
                remeroUpdate = remeroService.update(remeroDto);
                RemeroDto savedRemeroDto = RemeroDto.fromEntity(remeroUpdate);
                return new ResponseEntity<>(MensageResponse.fromData("Cliente actualizado correctamente", savedRemeroDto), HttpStatus.OK);
            } catch (DataAccessException dae) {
                return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(),null), HttpStatus.BAD_REQUEST);
            }
        }

    @DeleteMapping("remero/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            Remero remero = this.remeroService.findById(id);
            if (remero == null) {
                return new ResponseEntity<>(MensageResponse.fromData("No se ha encontrado el remero con id "+id,null), HttpStatus.OK);
            }
            RemeroDto remeroDelete = RemeroDto.fromEntity(remero);
            remeroService.delete(remeroDelete);
            return new ResponseEntity<>(MensageResponse.fromData("Cliente con id "+remeroDelete.getIdRemero()+"eliminado",remeroDelete), HttpStatus.OK);
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(),null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("remero/{id}")
    public ResponseEntity<?> showByid(@PathVariable int id) {
        try {
            Remero remero = this.remeroService.findById(id);
            if (remero == null) {
                return new ResponseEntity<>(MensageResponse.fromData("Remero con ID:"+id + "no encontrado",null), HttpStatus.OK);
            }
            RemeroDto remeroDto = RemeroDto.fromEntity(remero);
            return new ResponseEntity<>(MensageResponse.fromData("Cliente encontrado",remeroDto), HttpStatus.OK);
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.builder().message(dae.getMessage()).data(null).build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("remeros")
    public ResponseEntity<?> showAll() {
        try{
            List <Remero> remeros = this.remeroService.findAll();
            if (remeros.isEmpty()) {
                return new ResponseEntity<>(MensageResponse.builder().message("No hay remeros registrados").data(null).build(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(MensageResponse.fromData("Se ha encontrado "+remeros.size()+" en la bade de datos",remeros), HttpStatus.OK);
            }
        }catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(),null), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    @GetMapping("remeros/{idClub}")
    public ResponseEntity<?> remerosByClub(@PathVariable int idClub) {
        if(clubService.existsById(idClub)){
            return new ResponseEntity<>(MensageResponse.fromData("No se ha encontrado ningún club con el ID:"+idClub,null), HttpStatus.OK);
        }
        try {
            List<Remero> remeros = this.remeroService.findByClub(idClub);
            if (remeros.isEmpty()) {
                return new ResponseEntity<>(MensageResponse.fromData("El club no dispone de remeros en sus listas",null), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(MensageResponse.fromData("Se ha encontrado "+remeros.size()+" remeros en el club con id "+idClub,remeros), HttpStatus.OK);
            }
        } catch (DataAccessException dae) {
            return new ResponseEntity<>(MensageResponse.fromData(dae.getMessage(),null), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

}


// Response codes:
// GET-DELETE  200 (OK),
// POST 200(OK)201(Created),
// PUT 200(OK) 201(CREATE)
// ERROR 404 (Not Found), 405 (Metod not allowed)