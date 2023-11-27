package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.NotaFiscal;
import br.edu.univille.projlogistica2023.service.ClienteService;
import br.edu.univille.projlogistica2023.service.EnderecoService;
import br.edu.univille.projlogistica2023.service.NotaFiscalService;

@Controller
@RequestMapping("/notasfiscal")
@PreAuthorize("hasAuthority('APPROLE_Admin')")

public class NotaFiscalController {

    @Autowired
    private NotaFiscalService service;;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView index() {
        try {
            var listaNotasFiscal = service.getAll();
            ModelAndView modelAndView = new ModelAndView("notaFiscal/index", "notafiscal", listaNotasFiscal);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        try {
            var novoNotaFiscal = new NotaFiscal();
            var listaClientes = clienteService.getAll();
            ModelAndView modelAndView = new ModelAndView("notaFiscal/form", "notafiscal", novoNotaFiscal);
            modelAndView.addObject("listaClientes", listaClientes);

            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @PostMapping
    public ModelAndView save(NotaFiscal notaFiscal) {
        try {
            service.save(notaFiscal);
            return new ModelAndView("redirect:/notasfiscal");

        } catch (Exception e) {
            var listaClientes = clienteService.getAll();
            ModelAndView modelAndView = new ModelAndView("notaFiscal/form", "notafiscal", notaFiscal);
            modelAndView.addObject("listaClientes", listaClientes);
            modelAndView.addObject("excecao", e.getMessage());
            return modelAndView;
        }
    }

    @GetMapping("alterar/{cdNotaFiscal}")
    public ModelAndView alterar(@PathVariable("cdNotaFiscal") NotaFiscal notafiscal) {
        try {
            var listaClientes = clienteService.getAll();
            ModelAndView modelAndView = new ModelAndView("notaFiscal/form", "notafiscal", notafiscal);
            modelAndView.addObject("listaClientes", listaClientes);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/remover/{cdNotaFiscal}")
    public ModelAndView remover(
            @PathVariable("cdNotaFiscal") NotaFiscal notafiscal) {
        try {
            service.delete(notafiscal);
            return new ModelAndView("redirect:/itensnota");
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }
}
