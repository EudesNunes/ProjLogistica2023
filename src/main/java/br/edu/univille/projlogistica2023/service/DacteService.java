package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.Dacte;

public interface DacteService {
    List<Dacte> getAll();

    void save(Dacte dacte);
}
