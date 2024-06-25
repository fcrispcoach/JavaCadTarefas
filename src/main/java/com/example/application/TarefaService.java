package com.example.application;

import com.example.domain.Tarefa;
import com.example.infrastructure.TarefaRepository;

import java.util.List;

public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa cadastrarTarefa(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(titulo, descricao);
        tarefaRepository.save(tarefa);
        return tarefa;
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }
}