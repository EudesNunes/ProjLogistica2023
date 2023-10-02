package br.edu.univille.projlogistica2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.projlogistica2023.entity.RegistroArmazenamento;

@Repository
public interface RegistroArmazenamentoRepository extends JpaRepository<RegistroArmazenamento, Long> {

}
