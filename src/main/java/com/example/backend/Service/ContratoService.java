package com.example.backend.Service;

import org.springframework.stereotype.Service;

import com.example.backend.DTO.ContratoDTO;
import com.example.backend.Model.Contrato;
import com.example.backend.Repository.ContratoRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
public class ContratoService {
    private final ContratoRepository contratoRepository;
    private final ModelMapper modelMapper;

    public ContratoService(ContratoRepository contratoRepository, ModelMapper modelMapper) {
        this.contratoRepository = contratoRepository;
        this.modelMapper = modelMapper;
    }

    public ContratoDTO createContrato(ContratoDTO contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        Contrato savedContrato = contratoRepository.save(contrato);
        return modelMapper.map(savedContrato, ContratoDTO.class);
    }

    public ContratoDTO updateContrato(Long id, ContratoDTO contratoDTO) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        modelMapper.map(contratoDTO, contrato);
        Contrato updatedContrato = contratoRepository.save(contrato);
        return modelMapper.map(updatedContrato, ContratoDTO.class);
    }

    public void deleteContrato(Long id) {
        contratoRepository.deleteById(id);
    }

    public List<ContratoDTO> getAllContratos() {
        return contratoRepository.findAll()
                .stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }

    public ContratoDTO getContratoById(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        return modelMapper.map(contrato, ContratoDTO.class);
    }
}

