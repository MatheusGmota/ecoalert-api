package br.com.global_solutions.repositories;

import br.com.global_solutions.domain.entities.LimiarClimatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimiarRepository extends JpaRepository<LimiarClimatico, Long> {
}
