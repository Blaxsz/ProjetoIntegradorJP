package com.chamado.suporte.sistemachamadodesuporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import com.chamado.suporte.sistemachamadodesuporte.model.ChamadoSuporte;
import com.chamado.suporte.sistemachamadodesuporte.model.Solicitacao;
import com.chamado.suporte.sistemachamadodesuporte.repository.ChamadoSuporteRepository;

@Controller
public class ChamadoSuporteController {

    @Autowired
    ChamadoSuporteRepository repository;

    @GetMapping("/cadastro")
    public String cadastroSuporte() {
        return "cadastro";
    }

    @PostMapping("/salvarCadastro")
    public String salvarCadastro(ChamadoSuporte chamadosuporte) {
        repository.save(chamadosuporte);
        return "redirect:/login";
    }

    @GetMapping("/direcionarlogin")
    public String direcionarlogin() {
        return "index";
    }

    @GetMapping("/login")
    public String loginSuporte() {
        return "index";
    }

    @GetMapping("/solicitacao")
    public String solicitacaoSuporte() {
        return "versolicitacoes";
    }

    @GetMapping("/criarsolicitacao")
    public String criarSolicitacao() {
        return "criarsolicitacao";
    }

    @PostMapping("/enviarsolicitacao")
    public String enviarSolicitacao(Solicitacao enviarSolicitacao) {
        repository.save(enviarSolicitacao);
        return "redirect:/solicitacao";
    }

    @GetMapping("/solicitacao/excluir")
    public String excluirSolicitacao(@PathVariable("idSolicitacao") int idSolicitacao) {
        repository.deleteById(idSolicitacao);
        return "redirect:/repostasolicitacao";

    }

    @GetMapping("/versolicitacoes")
    public String verSolicitacoes() {
        return "versolicitacoes";
        // basicamente cópia da página solicitacoes.html sem botão excluir
    }

    @GetMapping("/respostasolicitacao")
    public String respostasolicitacao() {
        return "solicitacoes";
    }

    @PostMapping("/validacaologin")
    public String validacaoLogin() {
        return "redirect:/solicitacao";
    }
}