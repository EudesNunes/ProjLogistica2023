package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasAuthority('APPROLE_Admin')")
public class DacteController {

    @Autowired
    private DacteService service;
    @Autowired
    private NotaFiscalService notaFiscalService;

    @GetMapping
    public ModelAndView index() {
        try {
            var listaDactes = service.getAll();
            return new ModelAndView("dacte/index", "listaDactes", listaDactes);
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        try {
            var novoDacte = new Dacte();
            var ListaNotaFiscal = notaFiscalService.getAll();
            ModelAndView modelAndView = new ModelAndView("dacte/form", "dacte", novoDacte);
            modelAndView.addObject("LNotaFiscal", ListaNotaFiscal);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @PostMapping
    public ModelAndView save(Dacte dacte) {
        try {
            service.save(dacte);
            return new ModelAndView("redirect:/dactes");
        } catch (Exception e) {
            var ListaNotaFiscal = notaFiscalService.getAll();
            ModelAndView modelAndView = new ModelAndView("dacte/form", "dacte", dacte);
            modelAndView.addObject("LNotaFiscal", ListaNotaFiscal);
            modelAndView.addObject("excecao", e.getMessage());
            return modelAndView;
        }
    }

    @GetMapping("alterar/{cdDacte}")
    public ModelAndView alterar(@PathVariable("cdDacte") Dacte dacte) {
        try {
            var ListaNotaFiscal = notaFiscalService.getAll();
            ModelAndView modelAndView = new ModelAndView("dacte/form", "dacte", dacte);
            modelAndView.addObject("LNotaFiscal", ListaNotaFiscal);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/remover/{cdDacte}")
    public ModelAndView remover(
            @PathVariable("cdDacte") Dacte dacte) {
        try {
            service.delete(dacte);
            return new ModelAndView("redirect:/dactes");
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }
}
