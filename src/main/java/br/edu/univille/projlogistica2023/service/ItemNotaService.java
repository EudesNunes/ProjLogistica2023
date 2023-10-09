package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.ItemNota;


public interface ItemNotaService {
    List<ItemNota> getAll();

    void save(ItemNota itemNota);

    void delete(ItemNota itemNota);
}
