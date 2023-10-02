package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.Cliente;


public interface ClienteService {
    List<Cliente> getAll();

    void save(Cliente cliente);

    void delete(Cliente cliente);
}
