package com.reibax.api_rest.controller;

import com.reibax.api_rest.model.Payload.MensageResponse;
import com.reibax.api_rest.model.dto.ClienteDto;
import com.reibax.api_rest.model.entity.Cliente;
import com.reibax.api_rest.service.IclienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ClienteController {
    @Autowired
    private IclienteService clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?>create(@RequestBody ClienteDto clienteDto) {
        Cliente clienteSave = null;
        try {
            clienteSave = clienteService.save(clienteDto);
            ClienteDto.builder()
                    .idCliente(clienteSave.getIdCliente())
                    .name(clienteSave.getName())
                    .surname(clienteSave.getSurname())
                    .email(clienteSave.getEmail())
                    .register_date(clienteSave.getRegister_date())
                    .build();
            return new ResponseEntity<>(MensageResponse.builder()
                    .message("Cliente creado correctamente")
                    .data(clienteDto)
                    .build(), HttpStatus.CREATED);
        } catch (DataAccessException dataAccessException) {
            return new ResponseEntity<>(MensageResponse.builder()
                    .message(dataAccessException.getMessage())
                    .data(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);

        }
    }

    @PutMapping("cliente")
    public ResponseEntity<?>update(@RequestBody ClienteDto clienteDto) {
        Cliente clienteUpdate;
            try {
                if (!this.clienteService.existsById(clienteDto.getIdCliente())) {
                    return new ResponseEntity<>(MensageResponse.builder().message("No se ha encontrado cliente con la id " + clienteDto.getIdCliente()).build(), HttpStatus.OK);
                }
                clienteUpdate = clienteService.update(clienteDto);
                ClienteDto.builder()
                        .idCliente(clienteUpdate.getIdCliente())
                        .name(clienteUpdate.getName())
                        .surname(clienteUpdate.getSurname())
                        .email(clienteUpdate.getEmail())
                        .register_date(clienteUpdate.getRegister_date())
                        .build();
                return new ResponseEntity<>(MensageResponse.builder().message("Cliente actualizado").data(clienteDto).build(), HttpStatus.CREATED);
            } catch (DataAccessException dataAccessException) {
                return new ResponseEntity<>(MensageResponse.builder().message(dataAccessException.getMessage()).build(), HttpStatus.METHOD_NOT_ALLOWED);
            }
        }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            Cliente cliente = this.clienteService.findById(id);
            if (cliente == null) {
                return new ResponseEntity<>(MensageResponse.builder().message("No se ha encontrado cliente con la id " + id).build(), HttpStatus.OK);
            }
            ClienteDto clienteDelete = ClienteDto.builder()
                    .idCliente(cliente.getIdCliente())
                    .name(cliente.getName())
                    .surname(cliente.getSurname())
                    .email(cliente.getEmail())
                    .register_date(cliente.getRegister_date())
                    .build();
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(MensageResponse.builder().message("Cliente eliminado").data(clienteDelete).build(), HttpStatus.OK);
        } catch (DataAccessException dataAccessException) {
            return new ResponseEntity<>(MensageResponse.builder().message(dataAccessException.getMessage()).build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> showByid(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cliente cliente = this.clienteService.findById(id);
            if (cliente == null) {
                response.put("message", "Cliente no encontrado con ID: " + id);
                return new ResponseEntity<>(MensageResponse.builder().message("El cliente que buscas no existe").data(null).build(), HttpStatus.OK);
            }
            ClienteDto clienteShowById = ClienteDto.builder()
                    .idCliente(cliente.getIdCliente())
                    .name(cliente.getName())
                    .surname(cliente.getSurname())
                    .email(cliente.getEmail())
                    .register_date(cliente.getRegister_date())
                    .build();
            return new ResponseEntity<>(MensageResponse.builder().message("Cliente encontrado").data(clienteShowById).build(), HttpStatus.OK);
        } catch (DataAccessException dataAccessException) {
            return new ResponseEntity<>(MensageResponse.builder().message(dataAccessException.getMessage()).data(null).build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> showAll() {
        return this.clienteService.findAll();
    }

}


// Response codes:
// GET-DELETE  200 (OK),
// POST 200(OK)201(Created),
// PUT 200(OK) 201(CREATE)
// ERROR 404 (Not Found), 405 (Metod not allowed)