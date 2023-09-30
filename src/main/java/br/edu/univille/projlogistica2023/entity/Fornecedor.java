package br.edu.univille.projlogistica2023.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdFornecedor;
    private String nomeFornecedor;
    @OneToMany
    @JoinColumn(name = "id_forncedor")
    private List<Produto> produtosFornecedor;
    
    public long getCdFornecedor() {
        return cdFornecedor;
    }
    public void setCdFornecedor(long cdFornecedor) {
        this.cdFornecedor = cdFornecedor;
    }
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }
    public List<Produto> getProdutosFornecedor() {
        return produtosFornecedor;
    }
    public void setProdutosFornecedor(List<Produto> produtosFornecedor) {
        this.produtosFornecedor = produtosFornecedor;
    }
    
    



}
