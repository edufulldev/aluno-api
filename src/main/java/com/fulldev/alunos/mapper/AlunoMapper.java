package com.fulldev.alunos.mapper;

import com.fulldev.alunos.dto.AlunoRequestDTO;
import com.fulldev.alunos.dto.AlunoResponseDTO;
import com.fulldev.alunos.dto.MatriculaDTO;
import com.fulldev.alunos.entity.AlunoEntity;
import com.fulldev.alunos.entity.MatriculaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoMapper {

    public AlunoEntity toEntity(AlunoRequestDTO request) {

        AlunoEntity aluno = new AlunoEntity();
        aluno.setNome(request.nome());
        aluno.setDataNascimento(request.dataNascimento());
        aluno.setTelefone(request.telefone());

        List<MatriculaEntity> matriculas = request.matriculas().stream().map(m -> {

            MatriculaEntity matricula = new MatriculaEntity();
            matricula.setCodigoMatricula(m.codigoMatricula());
            matricula.setDataInicio(m.dataInicio());
            matricula.setNomeCurso(m.nomeCurso());

            matricula.setAluno(aluno);

            return matricula;

        }).toList();
        aluno.setMatriculas(matriculas);

        return aluno;
    }

    public AlunoResponseDTO toResponse(AlunoEntity aluno) {

        List<MatriculaDTO> matriculaDTOS = aluno.getMatriculas().stream().map(m ->

            new MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(), m.getDataInicio())).toList();

        return new AlunoResponseDTO(aluno.getId(), aluno.getNome(), aluno.getTelefone(), aluno.getDataNascimento(), matriculaDTOS);
    }
}
