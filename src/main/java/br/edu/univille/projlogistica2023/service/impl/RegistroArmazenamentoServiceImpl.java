package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.RegistroArmazenamento;
import br.edu.univille.projlogistica2023.repository.RegistroArmazenamentoRepository;
import br.edu.univille.projlogistica2023.service.RegistroArmazenamentoService;



@Service
public class RegistroArmazenamentoServiceImpl implements RegistroArmazenamentoService {

    @Autowired
    private RegistroArmazenamentoRepository repository;

    @Override
    public List<RegistroArmazenamento> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(RegistroArmazenamento registroArmazenamento) {
        repository.save(registroArmazenamento);
    }

    @Override
    public void delete(RegistroArmazenamento registroArmazenamento) {
        repository.delete(registroArmazenamento);
    }

    

}
