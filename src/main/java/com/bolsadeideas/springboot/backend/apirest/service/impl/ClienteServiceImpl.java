package com.bolsadeideas.springboot.backend.apirest.service.impl;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IClienteDao;
import com.bolsadeideas.springboot.backend.apirest.models.dao.ICreditoDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Credito;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import com.bolsadeideas.springboot.backend.apirest.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteDao clienteDao;
    private final ICreditoDao creditoDao;

    @Autowired
    public ClienteServiceImpl(IClienteDao clienteDao, ICreditoDao creditoDao) {
        this.clienteDao = clienteDao;
        this.creditoDao = creditoDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return this.clienteDao.findAll();
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
    public List<Cliente> findClienteByNombre(String term) {
        return clienteDao.findByNombre(term);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return this.clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Credito> findAllCreditos() {
        return this.creditoDao.findAll();
    }

    @Override
    public Page<Credito> findAllCreditos(Pageable pageable) {
        return this.creditoDao.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAllUsuarios() {
        return this.creditoDao.findAllUsuarios();
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
