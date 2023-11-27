package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.Cliente;
import br.edu.univille.projlogistica2023.service.ClienteService;
import br.edu.univille.projlogistica2023.service.EnderecoService;

@Controller
@RequestMapping("/clientes")
@PreAuthorize("hasAuthority('APPROLE_Admin')")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private EnderecoService enderecoEntregaService;

    @GetMapping
    public ModelAndView index() {
        try {
            var listaClientes = service.getAll();
            return new ModelAndView("cliente/index", "listaClientes", listaClientes);
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        try {

            var novoCliente = new Cliente();
            var listaEnderecoEntrega = enderecoEntregaService.getAll();
            ModelAndView modelAndView = new ModelAndView("cliente/form", "cliente", novoCliente);
            modelAndView.addObject("EnderecosEntrega", listaEnderecoEntrega);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @PostMapping
    public ModelAndView save(Cliente cliente) {
        try {
            service.save(cliente);
            return new ModelAndView("redirect:/clientes");
        } catch (Exception e) {
            var listaEnderecoEntrega = enderecoEntregaService.getAll();
            ModelAndView modelAndView = new ModelAndView("cliente/form", "cliente", cliente);
            modelAndView.addObject("EnderecosEntrega", listaEnderecoEntrega);
            modelAndView.addObject("excecao", e.getMessage());
            return modelAndView;
        }
    }

    @GetMapping("alterar/{cdCliente}")
    public ModelAndView alterar(@PathVariable("cdCliente") Cliente cliente) {
        try {
            var listaEnderecoEntrega = enderecoEntregaService.getAll();
            ModelAndView modelAndView = new ModelAndView("cliente/form", "cliente", cliente);
            modelAndView.addObject("EnderecosEntrega", listaEnderecoEntrega);
            return modelAndView;

        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

    @GetMapping("/remover/{cdCliente}")
    public ModelAndView remover(
            @PathVariable("cdCliente") Cliente cliente) {
        try {
            service.delete(cliente);
            return new ModelAndView("redirect:/clientes");
        } catch (Exception e) {
            return new ModelAndView("home/index", "excecao", e.getMessage());
        }
    }

}
