package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.Situacao;

public interface SituacaoService {
    List<Situacao> getAll();

    void save(Situacao situacao);

    void delete(Situacao situacao);
}
