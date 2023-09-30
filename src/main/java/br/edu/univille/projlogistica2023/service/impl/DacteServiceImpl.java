package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.Dacte;
import br.edu.univille.projlogistica2023.repository.DacteRepository;
import br.edu.univille.projlogistica2023.service.DacteService;

@Service
public class DacteServiceImpl implements DacteService {

    @Autowired
    private DacteRepository repository;

    @Override
    public List<Dacte> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Dacte dacte) {
        repository.save(dacte);
    }

    

}
