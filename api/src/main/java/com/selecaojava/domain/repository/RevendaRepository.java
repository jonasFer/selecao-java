package com.selecaojava.domain.repository;

import com.selecaojava.domain.entity.Municipio;
import com.selecaojava.domain.entity.Revenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RevendaRepository extends JpaRepository<Revenda, Long> {

    Optional<Revenda> findFirstRevendaByNome(String nome);

    List<Revenda> findRevendaByMunicipio(Municipio municipio);
}
