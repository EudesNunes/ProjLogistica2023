package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.Produto;

public interface ProdutoService {
     List<Produto> getAll();

    void save(Produto produto);
}
