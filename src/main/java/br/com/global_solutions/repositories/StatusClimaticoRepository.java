package br.com.global_solutions.repositories;

import br.com.global_solutions.domain.entities.StatusClimatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusClimaticoRepository extends JpaRepository<StatusClimatico, Long> {

    // Encontra o status climático mais recente para uma dada localização
    Optional<StatusClimatico> findFirstByLocalizacaoOrderByDataHoraAtualizacaoDesc(String localizacao);
}
