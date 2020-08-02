package com.selecaojava.domain.repository;

import com.selecaojava.domain.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Estado findEstadoBySigla(String nome);
}
