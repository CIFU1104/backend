package com.example.backend.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.ContratoDTO;
import com.example.backend.Service.ContratoService;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {
    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ContratoDTO create(@RequestBody ContratoDTO contratoDTO) {
        return contratoService.createContrato(contratoDTO);
    }

    @PutMapping("/{id}")
    public ContratoDTO update(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        return contratoService.updateContrato(id, contratoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratoService.deleteContrato(id);
    }

    @GetMapping
    public List<ContratoDTO> getAll() {
        return contratoService.getAllContratos();
    }

    @GetMapping("/{id}")
    public ContratoDTO getById(@PathVariable Long id) {
        return contratoService.getContratoById(id);
    }
}

