package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.NotaFiscal;
import br.edu.univille.projlogistica2023.repository.NotaFiscalRepository;
import br.edu.univille.projlogistica2023.service.NotaFiscalService;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {

    @Autowired
    private NotaFiscalRepository repository;

    @Override
    public List<NotaFiscal> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(NotaFiscal notaFiscal) {
        repository.save(notaFiscal);
    }

    

}
