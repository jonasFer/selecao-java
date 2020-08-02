package com.selecaojava.domain.repository;

import com.selecaojava.domain.entity.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

    Optional<Regiao> findRegiaoByNome(String nome);
}
