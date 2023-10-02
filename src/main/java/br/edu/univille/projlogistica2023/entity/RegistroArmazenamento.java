package br.edu.univille.projlogistica2023.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class RegistroArmazenamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdRegistro;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    private int quantidade;

    private String endereco;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Produto produto;

    public long getCdRegistro() {
        return cdRegistro;
    }

    public void setCdRegistro(long cdRegistro) {
        this.cdRegistro = cdRegistro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}
