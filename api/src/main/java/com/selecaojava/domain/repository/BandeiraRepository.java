package com.selecaojava.domain.repository;

import com.selecaojava.domain.entity.Bandeira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BandeiraRepository extends JpaRepository<Bandeira, Long> {

    Optional<Bandeira> findBandeiraByNome(String nome);
}
