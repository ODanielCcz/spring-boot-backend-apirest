package com.bolsadeideas.springboot.backend.apirest.service;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Credito;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();

    Page<Cliente> findAll(Pageable pageable);

    Cliente findById(Long id);

    public List<Cliente> findClienteByNombre(String term);

    Cliente save(Cliente cliente);

    Page<Credito> findAllCreditos(Pageable pageable);

    List<Usuario> findAllUsuarios();

    Credito findCreditoById(Long id);

    Credito saveCredito(Credito credito);


}
