package br.usjt.PrevtempArq.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.PrevtempArq.model.Clima;
import br.usjt.PrevtempArq.repository.ClimasRepository;

import java.util.List;

@Service
public class ClimasService {

    @Autowired
    private ClimasRepository repository;

    public void salvar(Clima clima) {
        repository.save(clima);
    }

    public List<Clima> listarTodos() {
        return repository.findAll();
    }

    public List<Clima> buscarCidade(String nome) {
        return repository.BuscaPeloCidadeNome(nome);
    }

    public List<Clima> buscarLateLon(Double lat, Double lon) {
        return repository.BuscaPeloLatELon(lat, lon);
    }



}
