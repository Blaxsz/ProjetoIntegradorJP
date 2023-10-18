package com.chamado.suporte.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chamado.suporte.model.ChamadoSuporte;
import com.chamado.suporte.repository.ChamadoSuporteRepository;

@Controller
public class ChamadoSuporteController {

    @Autowired
    ChamadoSuporteRepository repository;

    @GetMapping("/cadastro")
    public String cadastroSuporte(ChamadoSuporte chamadosuporte) {
        return "cadastro";
    }

    @PostMapping
    public String salvarCadastro(ChamadoSuporte chamadosuporte) {
        repository.save(chamadosuporte);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginSuporte() {
        return "index";
    }

    @GetMapping("/solicitacao")
    public String solicitacaoSuporte() {
        return "criacaosolicitacao";
    }

    @PostMapping("/validacaologin")
    public String validacaoLogin(ChamadoSuporte chamadosuporte) {
        List<ChamadoSuporte> chamadossuporte = new ArrayList<>();
        chamadossuporte = repository.findAll();

        for (ChamadoSuporte chamadoSuporte2 : chamadossuporte) {
            if (chamadoSuporte2.getEmail().equals(chamadosuporte.getEmail())
                    && chamadoSuporte2.getSenha().equals(chamadosuporte.getSenha())) {
                return "redirect:/solicitacao";
            }
        }
        return "redirect:/login";
    }

    @GetMapping
}
