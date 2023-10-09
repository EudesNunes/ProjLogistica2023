package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.ItemNota;
import br.edu.univille.projlogistica2023.repository.ItemNotaRepository;
import br.edu.univille.projlogistica2023.service.ItemNotaService;

@Service
public class ItemNotaServiceImpl implements ItemNotaService {

    @Autowired
    private ItemNotaRepository repository;

    @Override
    public List<ItemNota> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(ItemNota itemNota) {
        repository.save(itemNota);
    }

    @Override
    public void delete(ItemNota itemNota) {
        repository.delete(itemNota);
    }

    

}
