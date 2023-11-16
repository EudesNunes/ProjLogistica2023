package br.edu.univille.projlogistica2023.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.univille.projlogistica2023.Enums.EnumStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Situacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdSituacao;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataAtualizacao;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date previsaoEntrega;
    private EnumStatus status;

     @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private NotaFiscal notaFiscal;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Dacte dacte;
    public Dacte getDacte() {
        return dacte;
    }

    public void setDacte(Dacte dacte) {
        this.dacte = dacte;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(Date previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public long getCdSituacao() {
        return cdSituacao;
    }

    public void setCdSituacao(long cdSituacao) {
        this.cdSituacao = cdSituacao;
    }

}
