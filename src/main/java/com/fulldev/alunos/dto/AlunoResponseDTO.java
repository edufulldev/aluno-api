package com.fulldev.alunos.dto;

import java.time.LocalDate;
import java.util.List;

public record AlunoResponseDTO(Long id, String nome, String telefone, LocalDate dataNascimento, List<MatriculaDTO> matriculas) {
}
