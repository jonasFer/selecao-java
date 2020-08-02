package com.selecaojava.domain.repository;

import com.selecaojava.domain.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    @Query(value = "SELECT AVG(valorVenda) FROM historico WHERE revenda IN ?1")
    float mediaValorVendaFromRevenda(List<Revenda> revendas);

    @Query(value = "SELECT AVG(valorCompra) FROM historico WHERE revenda IN ?1")
    float mediaValorCompraFromRevenda(List<Revenda> revendas);

    @Query(value = "SELECT AVG(valorCompra) FROM historico WHERE bandeira = ?1")
    float mediaValorCompraFromBandeira(Bandeira bandeira);

    @Query(value = "SELECT AVG(h.valor_compra) FROM historico h " +
                   "JOIN revenda r on r.id = h.revenda_id " +
                   "JOIN municipio m on m.id = r.municipio_id " +
                   "WHERE m.id = ?1",
            nativeQuery = true
    )
    float mediaValorCompraFromMunicipio(Long id);

    @Query(value = "SELECT AVG(valorVenda) FROM historico WHERE bandeira = ?1")
    float mediaValorVendaFromBandeira(Bandeira bandeira);

    @Query(value = "SELECT h FROM historico h " +
            "JOIN FETCH h.revenda r " +
            "JOIN FETCH r.municipio m " +
            "JOIN FETCH m.estado e " +
            "JOIN FETCH e.regiao r " +
            "WHERE r.nome = ?1"
    )
    List<Historico> findHistoricoByRegiao(String nome);

    List<Historico> findHistoricoByData(Date data);

    List<Historico> findHistoricoByRevenda(Revenda revenda);
}
