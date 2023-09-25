package br.edu.univille.projlogistica2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.projlogistica2023.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor,Long>{
    
}
