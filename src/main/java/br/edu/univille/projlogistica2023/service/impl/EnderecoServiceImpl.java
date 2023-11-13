package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.Endereco;
import br.edu.univille.projlogistica2023.repository.EnderecoRepository;
import br.edu.univille.projlogistica2023.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public List<Endereco> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Endereco enderecoEntrega) {
        repository.save(enderecoEntrega);
    }

    @Override
    public void delete(Endereco enderecoEntrega) {
        repository.delete(enderecoEntrega);
    }

    

}
