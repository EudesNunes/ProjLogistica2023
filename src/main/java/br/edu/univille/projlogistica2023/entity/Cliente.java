package br.edu.univille.projlogistica2023.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdCliente;
    private String nomeCliente;
    private String telefoneCliente;
    private String emailCliente;
    private String cpfCliente;
    @OneToMany
    @JoinColumn(name = "cdCliente")
    private List<Endereco> enderecoEntrega = 
     new ArrayList<>();
     
    public long getCdCliente() {
        return cdCliente;
    }
    public void setCdCliente(long cdCliente) {
        this.cdCliente = cdCliente;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getTelefoneCliente() {
        return telefoneCliente;
    }
    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
    public String getEmailCliente() {
        return emailCliente;
    }
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    public String getCpfCliente() {
        return cpfCliente;
    }
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    public List<Endereco> getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public void setEnderecoEntrega(List<Endereco> enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

 

}
