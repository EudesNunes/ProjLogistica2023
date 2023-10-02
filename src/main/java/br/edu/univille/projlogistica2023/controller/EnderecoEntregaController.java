package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.EnderecoEntrega;
import br.edu.univille.projlogistica2023.service.EnderecoEntregaService;

@Controller
@RequestMapping("/enderecosentrega")
public class EnderecoEntregaController {

    @Autowired
    private EnderecoEntregaService service;
    @GetMapping
    public ModelAndView index() {
       
        var listaEnderecoEntrega = service.getAll();
        return new ModelAndView("enderecoentrega/index","listaEnderecoEntrega", listaEnderecoEntrega);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var novoEnderecoEntrega = new EnderecoEntrega();
        return new ModelAndView ("enderecoentrega/form","enderecoEntrega", novoEnderecoEntrega);
    }

    @PostMapping
    public ModelAndView save(EnderecoEntrega enderecoEntrega){
        service.save(enderecoEntrega);
        return new ModelAndView("redirect:/enderecosentrega");
    }

    @GetMapping("alterar/{cdEnderecoEntrega}")
    public ModelAndView alterar(@PathVariable("cdEnderecoEntrega") EnderecoEntrega enderecoEntrega){
        return new ModelAndView ("enderecoentrega/form","enderecoEntrega",enderecoEntrega);
    }
}
