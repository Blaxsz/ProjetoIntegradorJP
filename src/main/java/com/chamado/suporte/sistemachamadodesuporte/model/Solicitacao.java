package com.chamado.suporte.sistemachamadodesuporte.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Solicitacao extends ChamadoSuporte {

    private String detalhesDaSolicitacao;

    public Solicitacao(String detalhesDaSolicitacao) {
        this.detalhesDaSolicitacao = detalhesDaSolicitacao;
    }

    public Solicitacao(int id, String nome, String email, String senha, String conta,
            String detalhesDaSolicitacao) {
        super(id, nome, email, senha, conta);
        this.detalhesDaSolicitacao = detalhesDaSolicitacao;
    }

    public String getDetalhesDaSolicitacao() {
        return detalhesDaSolicitacao;
    }

    public void setDetalhesDaSolicitacao(String detalhesDaSolicitacao) {
        this.detalhesDaSolicitacao = detalhesDaSolicitacao;
    }

}