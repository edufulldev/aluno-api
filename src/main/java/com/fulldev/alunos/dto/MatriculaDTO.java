package com.fulldev.alunos.dto;

import java.time.LocalDate;

public record MatriculaDTO(String codigoMatricula, String nomeCurso, LocalDate dataInicio) {

    @Override
    public String codigoMatricula() {
        return codigoMatricula;
    }

    @Override
    public String nomeCurso() {
        return nomeCurso;
    }

    @Override
    public LocalDate dataInicio() {
        return dataInicio;
    }


    public void setCodigoMatricula(String s) {

    }
}
