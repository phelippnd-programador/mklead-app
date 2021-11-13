package br.com.phdigitalcode.mk_lead.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Ligacao {
    private String status;
    private LocalDateTime ultimaLigacao;
    private Curso curso;
    private Lead lead;
}
