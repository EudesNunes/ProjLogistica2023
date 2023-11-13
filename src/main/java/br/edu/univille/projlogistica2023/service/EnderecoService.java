package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.Endereco;

public interface EnderecoService {
    List<Endereco> getAll();

    void save(Endereco enderecoEntrega);

    void delete(Endereco enderecoEntrega);
}
