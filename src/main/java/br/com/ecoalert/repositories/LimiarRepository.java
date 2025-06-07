package br.com.ecoalert.repositories;

import br.com.ecoalert.domain.entities.LimiarClimatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimiarRepository extends JpaRepository<LimiarClimatico, Long> {
}
