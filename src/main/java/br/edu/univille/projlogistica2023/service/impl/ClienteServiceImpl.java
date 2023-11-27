package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.Cliente;
import br.edu.univille.projlogistica2023.repository.ClienteRepository;
import br.edu.univille.projlogistica2023.repository.NotaFiscalRepository;
import br.edu.univille.projlogistica2023.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;
     @Autowired
    private NotaFiscalRepository NotaFiscalrepository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Cliente cliente) {        
     
        String nomeMsg = cliente.getNomeCliente().isEmpty() ? "Nome do cliente inválido" : null;
        String telefoneMsg = cliente.getTelefoneCliente().length() != 11 ? "Telefone do cliente inválido" : null;
        String emailMsg = !cliente.getEmailCliente().contains("@") ? "Email do cliente inválido" : null;
        String cpfMsg = cliente.getCpfCliente().length() != 11 ? "CPF do cliente inválido" : null;
        String enderecoMsg = cliente.getEnderecoEntrega() == null ? "Endereço do cliente inválido" : null;
    

    String errorMessage = Stream.of(nomeMsg, telefoneMsg, emailMsg, cpfMsg, enderecoMsg)
                                 .filter(msg -> msg != null)
                                 .collect(Collectors.joining("; "));

    if (!errorMessage.isEmpty()) {
        throw new RuntimeException(errorMessage);
    }

        repository.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        repository.delete(cliente);
    }

    

}
