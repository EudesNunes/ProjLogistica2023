package br.edu.univille.projlogistica2023.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity()
public class EnderecoEntrega{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdEnderecoEntrega;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String cep;
    private String numero;
    private String complemento;
    private String nomeDestinatario;
    private String instrucoesEntrega;

    
    public String getNomeDestinatario() {
        return nomeDestinatario;
    }
    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }
    public String getInstrucoesEntrega() {
        return instrucoesEntrega;
    }
    public void setInstrucoesEntrega(String instrucoesEntrega) {
        this.instrucoesEntrega = instrucoesEntrega;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public long getCdEnderecoEntrega() {
        return cdEnderecoEntrega;
    }
    public void setCdEnderecoEntrega(long cdEnderecoEntrega) {
        this.cdEnderecoEntrega = cdEnderecoEntrega;
    }   
    
    
    
}
