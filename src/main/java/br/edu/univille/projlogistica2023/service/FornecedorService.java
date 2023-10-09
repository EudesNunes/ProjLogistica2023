package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.Fornecedor;

public interface FornecedorService {
    List<Fornecedor> getAll();

    void save(Fornecedor fornecedor);

    void delete(Fornecedor fornecedor);
}
