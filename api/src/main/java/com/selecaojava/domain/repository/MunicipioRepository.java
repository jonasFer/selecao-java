package com.selecaojava.domain.repository;

import com.selecaojava.domain.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    Optional<Municipio> findMunicipioByNome(String nome);
}
