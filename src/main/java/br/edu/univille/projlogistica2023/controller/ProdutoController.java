package br.edu.univille.projlogistica2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projlogistica2023.entity.Produto;
import br.edu.univille.projlogistica2023.service.FornecedorService;
import br.edu.univille.projlogistica2023.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ModelAndView index() {

        var listaProdutos = service.getAll();
        return new ModelAndView("produto/index", "listaProdutos", listaProdutos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoProduto = new Produto();
        var listaFornecedor = fornecedorService.getAll();
        ModelAndView modelAndView = new ModelAndView("produto/form", "produto", novoProduto);
        modelAndView.addObject("fornecedores", listaFornecedor);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(Produto produto) {
        service.save(produto);
        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping("alterar/{cdProduto}")
    public ModelAndView alterar(@PathVariable("cdProduto") Produto produto) {
        var listaFornecedor = fornecedorService.getAll();
        ModelAndView modelAndView = new ModelAndView("produto/form", "produto", produto);
        modelAndView.addObject("fornecedores", listaFornecedor);
        return modelAndView;

    }

    @GetMapping("/remover/{cdProduto}")
    public ModelAndView remover(
            @PathVariable("cdProduto") Produto produto) {
        service.delete(produto);
        return new ModelAndView("redirect:/itensnota");
    }
}
