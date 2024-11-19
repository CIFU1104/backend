package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador;
    private double valor;
    private String nombreContratante;
    private String documentoContratante;
    private String nombreContratantista;
    private String documentoContratantista;
    private String fechaInicial;
    private String fechaFinal;
}
