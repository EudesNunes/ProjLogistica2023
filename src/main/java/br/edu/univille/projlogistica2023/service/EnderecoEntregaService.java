package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.EnderecoEntrega;

public interface EnderecoEntregaService {
    List<EnderecoEntrega> getAll();

    void save(EnderecoEntrega enderecoEntrega);
}
