package br.com.global_solutions.services;

import br.com.global_solutions.domain.entities.LimiarClimatico;
import br.com.global_solutions.repositories.LimiarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LimiarService {

    @Autowired
    private LimiarRepository repository;

    public List<LimiarClimatico> ObterTodos() {
        return repository.findAll();
    }

    public LimiarClimatico ObterPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public LimiarClimatico SalvarDados(LimiarClimatico limiar){
        if (limiar != null)
            return repository.save(limiar);
        return null;
    }

    public LimiarClimatico EditarDados(LimiarClimatico limiar){
        if (limiar != null)
            return repository.save(limiar);
        return null;
    }

    public LimiarClimatico DeletarDados(Long id){
        LimiarClimatico limiar = repository.findById(id).orElse(null);
        if (limiar != null)
            repository.delete(limiar);
        return limiar;
    }
}
