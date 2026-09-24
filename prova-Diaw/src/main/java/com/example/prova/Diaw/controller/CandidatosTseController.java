package com.example.prova.Diaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.prova.Diaw.service.CandidatosTseService;
@Controller
public class CandidatosTseController {

@Autowired
private CandidatosTseService service;

@GetMapping("/")
public String index(
        @RequestParam(required = false) String nomeCandidato,
        @RequestParam(required = false) String cargo,
        @RequestParam(required = false) String nomePartido,
        Model model) {

    // Envia a lista filtrada
    model.addAttribute("candidatos", service.filtrar(cargo, nomePartido, nomeCandidato));

    // Preenche as opções dos selects
    model.addAttribute("opcoesCargo", service.listarCargos());
    model.addAttribute("opcoesPartido", service.listarPartidos());
    // model.addAttribute("opcoesCandidato", service.listarCandidatos());

    // Devolve os filtros atuais para manter o formulário preenchido
    model.addAttribute("cargoSelecionado", cargo);
    model.addAttribute("partidoSelecionado", nomePartido);
    model.addAttribute("nomeBuscado", nomeCandidato);

    return "index";
}
}