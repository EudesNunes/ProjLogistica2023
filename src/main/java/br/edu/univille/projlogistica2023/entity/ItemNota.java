package br.edu.univille.projlogistica2023.entity;

import java.util.ArrayList;
import java.util.List;

import br.edu.univille.projlogistica2023.Enums.EnumUnidadeMedida;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class ItemNota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdItemNota;

    @ManyToMany
    @JoinTable(name = "Produto_ItemNota", joinColumns = { @JoinColumn(name = "cdItemNota") }, inverseJoinColumns = {
            @JoinColumn(name = "cdProduto") })
    private List<Produto> Produto = 
     new ArrayList<>();

    private double quantidade;

    private EnumUnidadeMedida unidadeMedida;
    
    private long indice;


    public long getCdItemNota() {
        return cdItemNota;
    }
    public void setCdItemNota(long cdItemNota) {
        this.cdItemNota = cdItemNota;
    }
    public List<Produto> getProduto() {
        return Produto;
    }
    public void setProduto(List<Produto> produto) {
        Produto = produto;
    }
    public double getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    public EnumUnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }
    public void setUnidadeMedida(EnumUnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    public long getIndice() {
        return indice;
    }
    public void setIndice(long indice) {
        this.indice = indice;
    }

    
}
