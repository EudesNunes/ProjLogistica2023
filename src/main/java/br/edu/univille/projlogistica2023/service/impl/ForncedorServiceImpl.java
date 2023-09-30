package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.Fornecedor;
import br.edu.univille.projlogistica2023.repository.FornecedorRepository;
import br.edu.univille.projlogistica2023.service.FornecedorService;

@Service
public class ForncedorServiceImpl implements FornecedorService{

    @Autowired
    private FornecedorRepository repository;
    @Override
    public List<Fornecedor> getAll() {
        return repository.findAll();
    }
    @Override
    public void save(Fornecedor fornecedor) {
        repository.save(fornecedor);
    }
    
    
}
