package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.ItemNota;
import br.edu.univille.projlogistica2023.service.ItemNotaService;

@Controller
@RequestMapping("/itensnota")
public class ItemNotaController {

    @Autowired
    private ItemNotaService service;

    @GetMapping
    public ModelAndView index() {

        var listaItemNota = service.getAll();
        return new ModelAndView("itemNota/index", "listaItemNota", listaItemNota);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoItemNota = new ItemNota();
        return new ModelAndView("itemNota/form", "itemNota", novoItemNota);
    }

    @PostMapping
    public ModelAndView save(ItemNota itemNota) {
        service.save(itemNota);
        return new ModelAndView("redirect:/itensnota");
    }

    @GetMapping("alterar/{cdItemNota}")
    public ModelAndView alterar(@PathVariable("cdItemNota") ItemNota itemNota) {
        return new ModelAndView("itemNota/form", "itemNota", itemNota);
    }

    @GetMapping("/remover/{cdItemNota}")
    public ModelAndView remover(
            @PathVariable("cdItemNota") ItemNota itemNota) {
        service.delete(itemNota);
        return new ModelAndView("redirect:/itensnota");
    }

}
