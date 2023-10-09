package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.Dacte;
import br.edu.univille.projlogistica2023.service.DacteService;
import br.edu.univille.projlogistica2023.service.NotaFiscalService;

@Controller
@RequestMapping("/dactes")
public class DacteController {

    @Autowired
    private DacteService service;
    @Autowired
    private NotaFiscalService notaFiscalService;

    @GetMapping
    public ModelAndView index() {

        var listaDactes = service.getAll();
        return new ModelAndView("dacte/index", "listaDactes", listaDactes);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoDacte = new Dacte();
        var ListaNotaFiscal = notaFiscalService.getAll();
        ModelAndView modelAndView = new ModelAndView("dacte/form", "dacte", novoDacte);
        modelAndView.addObject("LNotaFiscal", ListaNotaFiscal);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(Dacte dacte) {
        service.save(dacte);
        return new ModelAndView("redirect:/dactes");
    }

    @GetMapping("alterar/{cdDacte}")
    public ModelAndView alterar(@PathVariable("cdDacte") Dacte dacte) {
        var ListaNotaFiscal = notaFiscalService.getAll();
        ModelAndView modelAndView = new ModelAndView("dacte/form", "dacte", dacte);
        modelAndView.addObject("LNotaFiscal", ListaNotaFiscal);
        return modelAndView;
    }

    @GetMapping("/remover/{cdDacte}")
    public ModelAndView remover(
            @PathVariable("cdDacte") Dacte dacte) {
        service.delete(dacte);
        return new ModelAndView("redirect:/dactes");
    }
}
