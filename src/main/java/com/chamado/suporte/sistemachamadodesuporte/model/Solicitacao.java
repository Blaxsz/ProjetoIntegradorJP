package com.chamado.suporte.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "nome")
public class Solicitacao extends ChamadoSuporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitacao;
    private String solicitacao;
    private String detalhesDaSolicitacao;

    public Solicitacao(int id, String nome, String email, String senha, String conta, int idSolicitacao,
            String solicitacao, String detalhesDaSolicitacao) {
        super(id, nome, email, senha, conta);
        this.idSolicitacao = idSolicitacao;
        this.solicitacao = solicitacao;
        this.detalhesDaSolicitacao = detalhesDaSolicitacao;
    }

    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public String getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
    }

    public String getDetalhesDaSolicitacao() {
        return detalhesDaSolicitacao;
    }

    public void setDetalhesDaSolicitacao(String detalhesDaSolicitacao) {
        this.detalhesDaSolicitacao = detalhesDaSolicitacao;
    }

}