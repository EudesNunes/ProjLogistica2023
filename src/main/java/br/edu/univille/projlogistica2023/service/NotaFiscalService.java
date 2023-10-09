package br.edu.univille.projlogistica2023.service;

import java.util.List;

import br.edu.univille.projlogistica2023.entity.NotaFiscal;


public interface NotaFiscalService {
    List<NotaFiscal> getAll();

    void save(NotaFiscal notaFiscal);

    void delete(NotaFiscal notafiscal);
}
