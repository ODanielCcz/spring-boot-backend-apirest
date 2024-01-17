package com.bolsadeideas.springboot.backend.apirest.models.dao;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreditoDao extends JpaRepository<Credito, Long> {
}
