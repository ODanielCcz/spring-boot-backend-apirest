package com.bolsadeideas.springboot.backend.apirest.service.impl;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IClienteDao;
import com.bolsadeideas.springboot.backend.apirest.models.dao.ICreditoDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Credito;
import com.bolsadeideas.springboot.backend.apirest.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteDao clienteDao;
    private final ICreditoDao creditoDao;

    @Autowired
    public ClienteServiceImpl(IClienteDao clienteDao, ICreditoDao creditoDao) {
        this.clienteDao = clienteDao;
        this.creditoDao = creditoDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return this.clienteDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return this.clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return this.clienteDao.save(cliente);
    }


    @Override
    public Page<Credito> findAllCreditos(Pageable pageable) {
        return this.creditoDao.findAll(pageable);
    }

    @Override
    public Credito findCreditoById(Long id) {
        return this.creditoDao.findById(id).orElse(null);
    }

    @Override
    public Credito saveCredito(Credito credito) {
        return this.creditoDao.save(credito);
    }
}
