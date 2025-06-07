package br.com.ecoalert.repositories;

import br.com.ecoalert.domain.entities.LimiarClimatico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LimiarClimaticoRepository extends JpaRepository<LimiarClimatico, Long> {
    List<LimiarClimatico> findByParametroSensor(String parametro);
}
