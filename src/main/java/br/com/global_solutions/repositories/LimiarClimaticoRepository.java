package br.com.global_solutions.repositories;

import br.com.global_solutions.domain.entities.LimiarClimatico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LimiarClimaticoRepository extends JpaRepository<LimiarClimatico, Long> {
    List<LimiarClimatico> findByParametroSensor(String parametro);
}
