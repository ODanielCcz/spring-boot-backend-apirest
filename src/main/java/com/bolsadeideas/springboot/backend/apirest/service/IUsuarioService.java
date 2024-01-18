package com.bolsadeideas.springboot.backend.apirest.service;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> findAll();

    Usuario findById(Long id);

}
