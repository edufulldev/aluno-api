package com.fulldev.alunos.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record AlunoRequestDTO(
        String nome,
        String telefone,
        LocalDate dataNascimento,
        @NotNull List<@Valid MatriculaDTO> matriculas
) {
}
