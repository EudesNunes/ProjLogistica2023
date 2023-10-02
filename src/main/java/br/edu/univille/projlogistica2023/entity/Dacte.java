package br.edu.univille.projlogistica2023.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Dacte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdDacte;
    private long numeroDacte;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataEmissao;
    @ManyToMany
    @JoinColumn(name = "cdDacte")
    private List<NotaFiscal> notasFiscal = 
     new ArrayList<>();

    public long getCdDacte() {
        return cdDacte;
    }

    public void setCdDacte(long cdDacte) {
        this.cdDacte = cdDacte;
    }

    public long getNumeroDacte() {
        return numeroDacte;
    }

    public void setNumeroDacte(long numeroDacte) {
        this.numeroDacte = numeroDacte;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public List<NotaFiscal> getNotasFiscal() {
        return notasFiscal;
    }

    public void setNotasFiscal(List<NotaFiscal> notasFiscal) {
        this.notasFiscal = notasFiscal;
    }

}
