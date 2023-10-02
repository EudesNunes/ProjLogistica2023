package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.Fornecedor;
import br.edu.univille.projlogistica2023.service.FornecedorService;
import br.edu.univille.projlogistica2023.service.ProdutoService;


@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService service;
    @Autowired
    private ProdutoService produtoService;
    @GetMapping
    public ModelAndView index(){
        var listaFornecedores = service.getAll();
        return new ModelAndView("fornecedor/index","listaFornecedores", listaFornecedores);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novoFornecedor = new Fornecedor();
        var ListaProdutos = produtoService.getAll();
        ModelAndView modelAndView = new ModelAndView("fornecedor/form","fornecedor", novoFornecedor);
        modelAndView.addObject("ListaProdutos", ListaProdutos);

        return modelAndView;

    }

    @PostMapping
    public ModelAndView save(Fornecedor fornecedor){
        service.save(fornecedor);
        return new ModelAndView("redirect:/fornecedores");

    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Fornecedor fornecedor){
         var ListaProdutos = produtoService.getAll();
        ModelAndView modelAndView = new ModelAndView("fornecedor/form","fornecedor", fornecedor);
        modelAndView.addObject("ListaProdutos", ListaProdutos);

        return modelAndView;

    }
}

