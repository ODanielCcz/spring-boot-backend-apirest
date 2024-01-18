package com.bolsadeideas.springboot.backend.apirest.controllers;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Credito;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Usuario;
import com.bolsadeideas.springboot.backend.apirest.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api/v1")
public class CreditoRestController {

    private final IClienteService clienteService;

    @Autowired
    public CreditoRestController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/creditos/page/{page}")
    public Page<Credito> index (@PathVariable Integer page) {
        return this.clienteService.findAllCreditos(PageRequest.of(page, 5));
    }

    @GetMapping("/creditos/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Credito credito;
        Map<String, Object> response = new HashMap<>();

        try {
            credito = this.clienteService.findCreditoById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (credito == null) {
            response.put("mensaje", "El credito con ID: ".concat(id.toString().concat(" no existe en la base de datos!!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(credito, HttpStatus.OK);
    }

    @PostMapping("/creditos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Credito credito, BindingResult result) {
        Credito creditoCreate;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            return responseEntity(response, result);
        }

        try {
            creditoCreate = this.clienteService.saveCredito(credito);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El credito ha sido creado con éxito!");
        response.put("credito", creditoCreate);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/creditos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@Valid @RequestBody Credito credito, BindingResult result, @PathVariable Long id) {
        Credito creditoUpdated;
        Credito creditoActual = this.clienteService.findCreditoById(id);

        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            return responseEntity(response, result);
        }

        if (creditoActual == null) {
            response.put("mensaje", "Error: no se pudo editar el credito con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {
            creditoActual.setMontoCredito(credito.getMontoCredito());
            creditoActual.setFechaEntrega(credito.getFechaEntrega());
            creditoActual.setNumeroPago(credito.getNumeroPago());
            creditoActual.setFrecuenciaPago(credito.getFrecuenciaPago());
            creditoActual.setEstatusCredito(credito.getEstatusCredito());
            creditoActual.setCliente(credito.getCliente());
            creditoActual.setUsuario(credito.getUsuario());

            creditoUpdated = this.clienteService.saveCredito(creditoActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El credito ha sido actualizado con éxito!");
        response.put("data", creditoUpdated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/creditos/usuarios")
    public List<Usuario> listarUsuarios() {
        return this.clienteService.findAllUsuarios();
    }

    private ResponseEntity<Map<String, Object>> responseEntity(Map<String, Object> response, BindingResult result) {
        List<String> errors = result.getFieldErrors()
                .stream()
                .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                .collect(Collectors.toList());

        response.put("errors", errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
