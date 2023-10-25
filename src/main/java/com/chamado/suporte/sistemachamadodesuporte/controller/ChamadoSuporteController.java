package com.chamado.suporte.sistemachamadodesuporte.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("direcionarcadastro")
    public String direcionarcadastro() {
        return "cadastro";
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

    @GetMapping("/respostasolicitacao")
    public String respostasolicitacao() {
        return "solicitacoes";
    }

    @GetMapping("/gersolicitacao")
    public String gersolicitacao() {
        return "gersolicitacao";
    }

    @PostMapping("/validacaoLogin")
    public String validacaologin(ChamadoSuporte chamadoSuporte) {
        List<ChamadoSuporte> chamados = new ArrayList();
        String conta = "";
        int validaUsuario = 0;
        chamados = repository.findAll();
        for (ChamadoSuporte chamadoSuporte2 : chamados) {
            if (chamadoSuporte.getEmail().equals(chamadoSuporte2.getEmail())
                    && chamadoSuporte.getSenha().equals(chamadoSuporte2.getSenha())) {
                conta = chamadoSuporte2.getConta();
                validaUsuario = 1;
            }
        }
        if (validaUsuario == 0) {
            return "index";
        }

        if (conta.equals("admin")) {
            return "gersolicitacao";
        } else {
            return "versolicitacoes";
        }

    }
}