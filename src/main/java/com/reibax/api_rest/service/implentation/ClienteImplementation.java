package com.reibax.api_rest.service.implentation;
import com.reibax.api_rest.model.dao.ClienteDao;
import com.reibax.api_rest.model.dto.ClienteDto;
import com.reibax.api_rest.model.entity.Cliente;
import com.reibax.api_rest.service.IclienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Service
public class ClienteImplementation implements IclienteService {
    @Autowired
    private ClienteDao clienteDao;
    @Transactional
    @Override
    public Cliente save(ClienteDto clienteDto) {
        Cliente cliente =  Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .name(clienteDto.getName())
                .surname(clienteDto.getSurname())
                .email(clienteDto.getEmail())
                .register_date(clienteDto.getRegister_date())
                .build();
        return clienteDao.save(cliente);
    }
    @Transactional(readOnly = true)
    @Override
    public Cliente findById(int id) {
        return clienteDao.findById(id).orElse(null);
    }



    @Transactional
    @Override
    public Cliente update(ClienteDto clienteDto) {
        Cliente clienteDt0 =  Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .name(clienteDto.getName())
                .surname(clienteDto.getSurname())
                .email(clienteDto.getEmail())
                .register_date(clienteDto.getRegister_date())
                .build();
        return clienteDao.save(clienteDt0);
    }
    @Transactional
    @Override
    public void delete(ClienteDto clienteDto) {
        clienteDao.deleteById(clienteDto.getIdCliente());
    }

    @Override
    public boolean existsById(int id) {
        return clienteDao.existsById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }
}


