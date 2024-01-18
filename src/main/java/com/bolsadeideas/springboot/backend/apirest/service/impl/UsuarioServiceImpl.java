package com.bolsadeideas.springboot.backend.apirest.service.impl;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IUsuarioDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import com.bolsadeideas.springboot.backend.apirest.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioDao usuarioDao;

    @Autowired
    public UsuarioServiceImpl(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) this.usuarioDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(Long id) {
        return this.usuarioDao.findById(id).orElse(null);
    }

}
