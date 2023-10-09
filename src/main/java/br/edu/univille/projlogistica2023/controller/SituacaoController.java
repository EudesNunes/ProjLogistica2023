package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.Situacao;
import br.edu.univille.projlogistica2023.service.SituacaoService;

@Controller
@RequestMapping("/situacoens")
public class SituacaoController {

    @Autowired
    private SituacaoService service;

    @GetMapping
    public ModelAndView index() {

        var listaSituacoens = service.getAll();
        return new ModelAndView("situacao/index", "listaSituacoens", listaSituacoens);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoSituacao = new Situacao();
        return new ModelAndView("situacao/form", "situacao", novoSituacao);
    }

    @PostMapping
    public ModelAndView save(Situacao situacao) {
        service.save(situacao);
        return new ModelAndView("redirect:/situacoens");
    }

    @GetMapping("alterar/{cdSituacao}")
    public ModelAndView alterar(@PathVariable("cdSituacao") Situacao situacao) {
        return new ModelAndView("situacao/form", "situacao", situacao);
    }

    @GetMapping("/remover/{cdSituacao}")
    public ModelAndView remover(
            @PathVariable("cdSituacao") Situacao situacao) {
        service.delete(situacao);
        return new ModelAndView("redirect:/registrosarmazenamento");
    }
}
