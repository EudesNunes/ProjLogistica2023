package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
           String dataEmissao = dacte.getDataEmissao()== null ? "Data de Emissão inválido" : null;
           String notafiscal = dacte.getNotasFiscal().isEmpty()  ? "Notas fiscais inválidas" : null;          
           String numerodacte = dacte.getNumeroDacte() <= 0 ? "Numero dacte inválido" : null;    

    String errorMessage = Stream.of(dataEmissao, notafiscal, numerodacte)
                                 .filter(msg -> msg != null)
                                 .collect(Collectors.joining("; "));

    if (!errorMessage.isEmpty()) {
        throw new RuntimeException(errorMessage);
    }

        repository.save(dacte);
    }

    @Override
    public void delete(Dacte dacte) {
        repository.delete(dacte);
    }

    

}
