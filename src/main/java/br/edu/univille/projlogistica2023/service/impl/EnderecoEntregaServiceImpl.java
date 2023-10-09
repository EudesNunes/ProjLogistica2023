package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.EnderecoEntrega;
import br.edu.univille.projlogistica2023.repository.EnderecoEntregaRepository;
import br.edu.univille.projlogistica2023.service.EnderecoEntregaService;

@Service
public class EnderecoEntregaServiceImpl implements EnderecoEntregaService {

    @Autowired
    private EnderecoEntregaRepository repository;

    @Override
    public List<EnderecoEntrega> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(EnderecoEntrega enderecoEntrega) {
        repository.save(enderecoEntrega);
    }

    @Override
    public void delete(EnderecoEntrega enderecoEntrega) {
        repository.delete(enderecoEntrega);
    }

    

}
