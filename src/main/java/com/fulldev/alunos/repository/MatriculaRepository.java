package com.fulldev.alunos.repository;

import com.fulldev.alunos.entity.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Long> {
}
