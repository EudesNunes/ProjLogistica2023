package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.RegistroArmazenamento;

public interface RegistroArmazenamentoService {
    
    List<RegistroArmazenamento> getAll();

    void save(RegistroArmazenamento situacao);

    void delete(RegistroArmazenamento registroArmazenamento);
}
