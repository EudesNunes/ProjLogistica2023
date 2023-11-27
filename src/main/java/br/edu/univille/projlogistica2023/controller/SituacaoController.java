package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.Situacao;
import br.edu.univille.projlogistica2023.service.DacteService;
import br.edu.univille.projlogistica2023.service.SituacaoService;

@Controller
@RequestMapping("/situacoens")
@PreAuthorize("hasAuthority('APPROLE_Admin')")
public class SituacaoController {

    @Autowired
    private SituacaoService service;
    @Autowired
    private DacteService DacteService;

    @GetMapping
    public ModelAndView index() {
        try {
            var listaSituacoens = service.getAll();
            return new ModelAndView("situacao/index", "listaSituacoens", listaSituacoens);
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        try {
            var novoSituacao = new Situacao();
            var listaDactes = DacteService.getAll();
            ModelAndView modelAndView = new ModelAndView("situacao/form", "situacao", novoSituacao);
            modelAndView.addObject("listDactes", listaDactes);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @PostMapping
    public ModelAndView save(Situacao situacao) {
        try {
            service.save(situacao);
            return new ModelAndView("redirect:/situacoens");
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("situacao/form", "excecao",
                    situacao);
            var listaDactes = DacteService.getAll();
            modelAndView.addObject("listDactes", listaDactes);
            modelAndView.addObject("excecao", e.getMessage());
            return modelAndView;
        }
    }

    @GetMapping("alterar/{cdSituacao}")
    public ModelAndView alterar(@PathVariable("cdSituacao") Situacao situacao) {
        try {
            return new ModelAndView("situacao/form", "situacao", situacao);
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/remover/{cdSituacao}")
    public ModelAndView remover(
            @PathVariable("cdSituacao") Situacao situacao) {
        try {
            service.delete(situacao);
            return new ModelAndView("redirect:/registrosarmazenamento");
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }
}
