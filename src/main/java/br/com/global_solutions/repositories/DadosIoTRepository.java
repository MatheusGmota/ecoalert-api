package br.com.global_solutions.repositories;

import br.com.global_solutions.domain.entities.DadosIoT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosIoTRepository extends JpaRepository<DadosIoT, Long> {}
