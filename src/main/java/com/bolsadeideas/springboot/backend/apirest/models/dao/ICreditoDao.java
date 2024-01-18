package com.bolsadeideas.springboot.backend.apirest.models.dao;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Credito;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICreditoDao extends JpaRepository<Credito, Long> {

    @Query("from Usuario ")
    public List<Usuario> findAllUsuarios();

}
