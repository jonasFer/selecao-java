package com.selecaojava.service;

import com.selecaojava.domain.entity.Produto;

import java.util.List;

public interface ProdutoService {

    public void saveFromCsv(List<String[]> dados);

    public Produto byId(Long id);

    public Produto findProdutoByNome(String nome);
}
