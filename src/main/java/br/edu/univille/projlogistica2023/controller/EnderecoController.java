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
        try {
            var listaEnderecoEntrega = service.getAll();
            return new ModelAndView("endereco/index", "listaEnderecoEntrega", listaEnderecoEntrega);
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        try {
            var novoEnderecoEntrega = new Endereco();
            return new ModelAndView("endereco/form", "enderecoEntrega", novoEnderecoEntrega);
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @PostMapping
    public ModelAndView save(Endereco enderecoEntrega) {
        try {
            service.save(enderecoEntrega);
            return new ModelAndView("redirect:/enderecosentrega");
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("endereco/form", "enderecoEntrega", enderecoEntrega);
            modelAndView.addObject("excecao", e.getMessage());
            return modelAndView;
        }
    }

    @GetMapping("alterar/{cdEnderecoEntrega}")
    public ModelAndView alterar(@PathVariable("cdEnderecoEntrega") Endereco enderecoEntrega) {
        try {
            return new ModelAndView("endereco/form", "enderecoEntrega", enderecoEntrega);
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/remover/{cdEnderecoEntrega}")
    public ModelAndView remover(
            @PathVariable("cdEnderecoEntrega") Endereco enderecoEntrega) {
        try {
            service.delete(enderecoEntrega);
            return new ModelAndView("redirect:/enderecosentrega");
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }
}
