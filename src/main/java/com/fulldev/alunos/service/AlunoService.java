package com.fulldev.alunos.service;

import com.fulldev.alunos.dto.AlunoRequestDTO;
import com.fulldev.alunos.dto.AlunoResponseDTO;
import com.fulldev.alunos.dto.MatriculaDTO;
import com.fulldev.alunos.entity.AlunoEntity;
import com.fulldev.alunos.entity.MatriculaEntity;
import com.fulldev.alunos.mapper.AlunoMapper;
import com.fulldev.alunos.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public AlunoResponseDTO salvar(AlunoRequestDTO request) {
        AlunoEntity aluno = alunoMapper.toEntity(request);
        alunoRepository.save(aluno);

        return alunoMapper.toResponse(aluno);
    }

    public List<AlunoResponseDTO> listarTodos() {

        return alunoRepository.findAll().stream().map(alunoMapper::toResponse).toList();
    }

    public List<MatriculaDTO> listarMatriculas(Long id) {

        AlunoEntity aluno = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluno nao encontrado"));

        return aluno.getMatriculas()
                .stream()
                .map(
                m -> new MatriculaDTO(
                        m.getCodigoMatricula(),
                        m.getNomeCurso(),
                        m.getDataInicio()))
                .toList();
    }

    public void remover(Long id) {
        if(!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Id nao encontrado do aluno");
        }
        alunoRepository.deleteById(id);
    }

    public AlunoResponseDTO atualizarAluno(Long id, AlunoRequestDTO request) {
        AlunoEntity alunoAtual = alunoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Aluno nao encontrado"));
        alunoAtual.setNome(request.nome());
        alunoAtual.setTelefone(request.telefone());
        alunoAtual.setDataNascimento(request.dataNascimento());

        for(MatriculaDTO matriculaDTO : request.matriculas()) {
            MatriculaEntity matricula = new MatriculaEntity();

            matricula.setCodigoMatricula(matriculaDTO.codigoMatricula());
            matricula.setDataInicio(matriculaDTO.dataInicio());
            matricula.setNomeCurso(matriculaDTO.nomeCurso());
            alunoAtual.getMatriculas().add(matricula);
        }

        return alunoMapper.toResponse(alunoRepository.save(alunoAtual));
    }
}
