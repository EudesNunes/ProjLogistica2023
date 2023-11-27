package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        String dataAtualizacao = situacao.getDataAtualizacao() == null ? "Data de Atualização inválida" : null;
        String dataentrega = situacao.getPrevisaoEntrega() == null ? "Data inválida" : null;
        String status = situacao.getStatus() == null ? "Status inválido" : null;

        String errorMessage = Stream.of(dataAtualizacao, dataentrega, status)
                .filter(msg -> msg != null)
                .collect(Collectors.joining("; "));

        if (!errorMessage.isEmpty()) {
            throw new RuntimeException(errorMessage);
        }
        repository.save(situacao);
    }

    @Override
    public void delete(Situacao situacao) {
        repository.delete(situacao);
    }
    

}
