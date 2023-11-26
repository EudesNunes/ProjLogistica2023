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

@Entity()
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdNotaFiscal;

    private long numeroPedido;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFaturamento;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Cliente clienteRemetente;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Cliente clienteDestinatario;

    public long getCdNotaFiscal() {
        return cdNotaFiscal;
    }

    public void setCdNotaFiscal(long cdNotaFiscal) {
        this.cdNotaFiscal = cdNotaFiscal;
    }

    public long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataFaturamento() {
        return dataFaturamento;
    }

    public void setDataFaturamento(Date dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    public Cliente getClienteRemetente() {
        return clienteRemetente;
    }

    public void setClienteRemetente(Cliente clienteRemetente) {
        this.clienteRemetente = clienteRemetente;
    }

    public Cliente getClienteDestinatario() {
        return clienteDestinatario;
    }

    public void setClienteDestinatario(Cliente clienteDestinatario) {
        this.clienteDestinatario = clienteDestinatario;
    }

  
 

}
