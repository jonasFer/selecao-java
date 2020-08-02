package com.selecaojava.service.impl;

import com.selecaojava.domain.entity.Produto;
import com.selecaojava.domain.repository.ProdutoRepository;
import com.selecaojava.exception.RegisterNotFoundException;
import com.selecaojava.service.ProdutoService;
import com.selecaojava.util.Csv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void saveFromCsv(List<String[]> dados) {
        HashMap<String, Produto> produtoHashMap = new HashMap<String, Produto>();
        for (String[] dado : dados) {

            if (dado.length == Csv.QTD_CAMPOS) {
                String nome = dado[Csv.PRODUTO];

                if (!produtoHashMap.containsKey(nome)) {
                    Produto produto = new Produto(nome);
                    produtoRepository.save(produto);
                    produtoHashMap.put(nome, produto);
                }
            }
        }
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto byId(Long id) {
        return produtoRepository
                .findById(id)
                .orElseThrow(() -> new RegisterNotFoundException("Produto não encontrado"));
    }

    @Override
    public Produto findProdutoByNome(String nome) {
        return produtoRepository
                .findFirstProdutoByNome(nome)
                .orElseThrow(() -> new RegisterNotFoundException("Produto não encontrado"));
    }
}
