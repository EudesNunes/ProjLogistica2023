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
import br.edu.univille.projlogistica2023.service.NotaFiscalService;
import br.edu.univille.projlogistica2023.service.RegistroArmazenamentoService;

@Controller
@RequestMapping("/registrosarmazenamento")
@PreAuthorize("hasAuthority('APPROLE_Admin')")
public class RegistroArmazenamentoController {

    @Autowired
    private RegistroArmazenamentoService service;
    @Autowired
    private NotaFiscalService NotaFiscalservice;;

    @GetMapping
    public ModelAndView index() {
        try {
            var listaRegistrosArmazenamento = service.getAll();
            return new ModelAndView("registroarmazenamento/index", "listaRegistrosArmazenamento",
                    listaRegistrosArmazenamento);
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        try {
            var ListaNotaFiscal = NotaFiscalservice.getAll();

            var novoRegistroArmazenamento = new RegistroArmazenamento();
            ModelAndView modelAndView = new ModelAndView("registroarmazenamento/form", "novoRegistroArmazenamento",
                    novoRegistroArmazenamento);
            modelAndView.addObject("listanotaFiscal", ListaNotaFiscal);

            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }

    }

    @PostMapping
    public ModelAndView save(RegistroArmazenamento registroArmazenamento) {
        try {
            service.save(registroArmazenamento);
            return new ModelAndView("redirect:/registrosarmazenamento");
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("registroarmazenamento/form", "novoRegistroArmazenamento",
                    registroArmazenamento);
            var ListaNotaFiscal = NotaFiscalservice.getAll();
            modelAndView.addObject("listanotaFiscal", ListaNotaFiscal);
            modelAndView.addObject("excecao", e.getMessage());
            return modelAndView;
        }
    }

    @GetMapping("alterar/{cdRegistro}")
    public ModelAndView alterar(@PathVariable("cdRegistro") RegistroArmazenamento registroArmazenamento) {
        try {
            ModelAndView modelAndView = new ModelAndView("registroarmazenamento/form", "novoRegistroArmazenamento",
                    registroArmazenamento);

            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/remover/{cdRegistro}")
    public ModelAndView remover(
            @PathVariable("cdRegistro") RegistroArmazenamento registroArmazenamento) {
        try {
            service.delete(registroArmazenamento);
            return new ModelAndView("redirect:/registrosarmazenamento");
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }
}
