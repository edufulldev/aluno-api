package com.fulldev.alunos.controller;

import com.fulldev.alunos.dto.AlunoRequestDTO;
import com.fulldev.alunos.dto.AlunoResponseDTO;
import com.fulldev.alunos.dto.MatriculaDTO;
import com.fulldev.alunos.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> criar(@RequestBody AlunoRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(request));
    }

    @GetMapping
    public List<AlunoResponseDTO> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}/matriculas")
    public List<MatriculaDTO> listarMatriculas(@PathVariable Long id) {
        return alunoService.listarMatriculas(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizar(@PathVariable Long id, @RequestBody AlunoRequestDTO request) {
        return ResponseEntity.ok(alunoService.atualizarAluno(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        alunoService.remover(id);

        return ResponseEntity.noContent().build();
    }

}
