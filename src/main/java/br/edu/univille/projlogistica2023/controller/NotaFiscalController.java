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
    private NotaFiscalService service;
 @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public ModelAndView index() {

        var listaNotasFiscal = service.getAll();
        var listaEndereco = enderecoService.getAll();
        ModelAndView modelAndView = new ModelAndView("notaFiscal/index", "listaNotasFiscal", listaNotasFiscal);
        modelAndView.addObject("enderecos", listaEndereco);
        return modelAndView;
    }

    
    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoNotaFiscal = new NotaFiscal();
        var listaEndereco = enderecoService.getAll();
        var listaClientes = clienteService.getAll();
        ModelAndView modelAndView = new ModelAndView("notaFiscal/form", "notafiscal", novoNotaFiscal);
        modelAndView.addObject("endereco", listaEndereco);
        modelAndView.addObject("cliente", listaClientes);

        return modelAndView;
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
