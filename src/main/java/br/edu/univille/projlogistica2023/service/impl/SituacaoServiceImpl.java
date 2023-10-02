package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.Situacao;
import br.edu.univille.projlogistica2023.repository.SituacaoRepository;
import br.edu.univille.projlogistica2023.service.SituacaoService;

@Service
public class SituacaoServiceImpl implements SituacaoService {

    @Autowired
    private SituacaoRepository repository;

    @Override
    public List<Situacao> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Situacao situacao) {
        repository.save(situacao);
    }
    

}
