package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.NotaFiscal;
import br.edu.univille.projlogistica2023.service.NotaFiscalService;

@Controller
@RequestMapping("/notasfiscal")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService service;

    @GetMapping
    public ModelAndView index() {

        var listaNotasFiscal = service.getAll();
        return new ModelAndView("notaFiscal/index", "listaNotasFiscal", listaNotasFiscal);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoNotaFiscal = new NotaFiscal();
        return new ModelAndView("notaFiscal/form", "notafiscal", novoNotaFiscal);
    }

    @PostMapping
    public ModelAndView save(NotaFiscal notaFiscal) {
        service.save(notaFiscal);
        return new ModelAndView("redirect:/notasfiscal");
    }

    @GetMapping("alterar/{cdNotaFiscal}")
    public ModelAndView alterar(@PathVariable("cdNotaFiscal") NotaFiscal notafiscal) {
        return new ModelAndView("notaFiscal/form", "notafiscal", notafiscal);
    }

    @GetMapping("/remover/{cdNotaFiscal}")
    public ModelAndView remover(
            @PathVariable("cdNotaFiscal") NotaFiscal notafiscal) {
        service.delete(notafiscal);
        return new ModelAndView("redirect:/itensnota");
    }
}
