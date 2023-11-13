package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.RegistroArmazenamento;
import br.edu.univille.projlogistica2023.service.RegistroArmazenamentoService;

@Controller
@RequestMapping("/registrosarmazenamento")
@PreAuthorize("hasAuthority('APPROLE_Admin')")
public class RegistroArmazenamentoController {

    @Autowired
    private RegistroArmazenamentoService service;

   
    @GetMapping
    public ModelAndView index() {

        var listaRegistrosArmazenamento = service.getAll();
        return new ModelAndView("registroarmazenamento/index", "listaRegistrosArmazenamento",
                listaRegistrosArmazenamento);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoRegistroArmazenamento = new RegistroArmazenamento();
        ModelAndView modelAndView = new ModelAndView("registroarmazenamento/form", "novoRegistroArmazenamento",
                novoRegistroArmazenamento);
        return modelAndView;

    }

    @PostMapping
    public ModelAndView save(RegistroArmazenamento registroArmazenamento) {
        service.save(registroArmazenamento);
        return new ModelAndView("redirect:/registrosarmazenamento");
    }

    @GetMapping("alterar/{cdRegistro}")
    public ModelAndView alterar(@PathVariable("cdRegistro") RegistroArmazenamento registroArmazenamento) {
        ModelAndView modelAndView = new ModelAndView("registroarmazenamento/form", "novoRegistroArmazenamento",
                registroArmazenamento);

        return modelAndView;
    }

    @GetMapping("/remover/{cdRegistro}")
    public ModelAndView remover(
            @PathVariable("cdRegistro") RegistroArmazenamento registroArmazenamento) {
        service.delete(registroArmazenamento);
        return new ModelAndView("redirect:/registrosarmazenamento");
    }
}
