package br.edu.univille.projlogistica2023.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projlogistica2023.entity.Endereco;
import br.edu.univille.projlogistica2023.repository.EnderecoRepository;
import br.edu.univille.projlogistica2023.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public List<Endereco> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Endereco enderecoEntrega) {
        String bairro = enderecoEntrega.getBairro().isEmpty() ? "Bairro inválido" : null;       
        String cep = enderecoEntrega.getCep().isEmpty()  ? "CEP inválido" : null;
        String cidade = enderecoEntrega.getCidade().isEmpty()  ? "Cidade inválido" : null;
        String estado = enderecoEntrega.getEstado().isEmpty()  ? "Estado inválido" : null;
        String nome = enderecoEntrega.getNomeDestinatario().isEmpty()  ? "Nome inválido" : null;
        String numero = enderecoEntrega.getNumero().isEmpty()  ? "Número inválido" : null;
        String pais = enderecoEntrega.getPais().isEmpty() ? "País inválido" : null;
        String rua = enderecoEntrega.getRua().isEmpty()  ? "Rua inválido" : null;

        String errorMessage = Stream.of(bairro,cep,cidade,estado,nome,numero,pais,rua)
                .filter(msg -> msg != null)
                .collect(Collectors.joining("; "));

        if (!errorMessage.isEmpty()) {
            throw new RuntimeException(errorMessage);
        }
        repository.save(enderecoEntrega);
    }

    @Override
    public void delete(Endereco enderecoEntrega) {
        repository.delete(enderecoEntrega);
    }

}
