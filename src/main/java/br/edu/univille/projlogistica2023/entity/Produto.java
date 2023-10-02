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
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdProduto;
    private String nomeProduto;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtFabricacaoProduto;
    private long numeroSerialProduto;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Fornecedor fornecedorProduto;

    public long getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(long cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Date getDtFabricacaoProduto() {
        return dtFabricacaoProduto;
    }

    public void setDtFabricacaoProduto(Date dtFabricacaoProduto) {
        this.dtFabricacaoProduto = dtFabricacaoProduto;
    }

    public long getNumeroSerialProduto() {
        return numeroSerialProduto;
    }

    public void setNumeroSerialProduto(long numeroSerialProduto) {
        this.numeroSerialProduto = numeroSerialProduto;
    }

    public Fornecedor getFornecedorProduto() {
        return fornecedorProduto;
    }

    public void setFornecedorProduto(Fornecedor fornecedorProduto) {
        this.fornecedorProduto = fornecedorProduto;
    }

}
