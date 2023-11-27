package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        String notaFiscal = registroArmazenamento.getNotaFiscal() == null ? "Nota Fiscal inválida" : null;
        String data = registroArmazenamento.getData() == null ? "Data inválida" : null;
        String endereco = registroArmazenamento.getEndereco().isEmpty() ? "Endereço  inválido" : null;

        String errorMessage = Stream.of(notaFiscal, data, endereco)
                .filter(msg -> msg != null)
                .collect(Collectors.joining("; "));

        if (!errorMessage.isEmpty()) {
            throw new RuntimeException(errorMessage);
        }
        repository.save(registroArmazenamento);
    }

    @Override
    public void delete(RegistroArmazenamento registroArmazenamento) {
        repository.delete(registroArmazenamento);
    }

}
