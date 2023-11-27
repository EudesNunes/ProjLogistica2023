package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        String destinatario = notaFiscal.getClienteDestinatario() == null ? "Destinatário inválido" : null;
        String remetente = notaFiscal.getClienteRemetente() == null ? "Remetente inválido" : null;
        String remetenteIgualDestino = notaFiscal.getClienteRemetente().equals(notaFiscal.getClienteDestinatario())? "Destinatário e Remetente não podem ser iguais" : null;

        String data = notaFiscal.getDataFaturamento() == null ? "Data de faturamento inválido" : null;
        String pedido = notaFiscal.getNumeroPedido() <= 0 ? "Número Pedido inválido" : null;

        String errorMessage = Stream.of(destinatario, remetente, data,pedido,remetenteIgualDestino)
                .filter(msg -> msg != null)
                .collect(Collectors.joining("; "));

        if (!errorMessage.isEmpty()) {
            throw new RuntimeException(errorMessage);
        }
        repository.save(notaFiscal);
    }

    @Override
    public void delete(NotaFiscal notafiscal) {
        repository.delete(notafiscal);
    }

}
