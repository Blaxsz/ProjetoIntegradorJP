package com.chamado.suporte.sistemachamadodesuporte.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Solicitacao extends ChamadoSuporte {

    private String solicitacao;
    private String detalhesDaSolicitacao;

    public Solicitacao(String solicitacao, String detalhesDaSolicitacao) {
        this.solicitacao = solicitacao;
        this.detalhesDaSolicitacao = detalhesDaSolicitacao;
    }

    public Solicitacao(int id, String nome, String email, String senha, String conta, String solicitacao,
            String detalhesDaSolicitacao) {
        super(id, nome, email, senha, conta);
        this.solicitacao = solicitacao;
        this.detalhesDaSolicitacao = detalhesDaSolicitacao;
    }

    public Solicitacao() {
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