package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.Endereco;
import br.edu.univille.projlogistica2023.service.EnderecoService;

@Controller
@RequestMapping("/enderecosentrega")
@PreAuthorize("hasAuthority('APPROLE_Admin')")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ModelAndView index() {

        var listaEnderecoEntrega = service.getAll();
        return new ModelAndView("endereco/index", "listaEnderecoEntrega", listaEnderecoEntrega);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoEnderecoEntrega = new Endereco();
        return new ModelAndView("endereco/form", "enderecoEntrega", novoEnderecoEntrega);
    }

    @PostMapping
    public ModelAndView save(Endereco enderecoEntrega) {
        service.save(enderecoEntrega);
        return new ModelAndView("redirect:/enderecosentrega");
    }

    @GetMapping("alterar/{cdEnderecoEntrega}")
    public ModelAndView alterar(@PathVariable("cdEnderecoEntrega") Endereco enderecoEntrega) {
        return new ModelAndView("endereco/form", "enderecoEntrega", enderecoEntrega);
    }

    @GetMapping("/remover/{cdEnderecoEntrega}")
    public ModelAndView remover(
            @PathVariable("cdEnderecoEntrega") Endereco enderecoEntrega) {
        service.delete(enderecoEntrega);
        return new ModelAndView("redirect:/enderecosentrega");
    }
}
