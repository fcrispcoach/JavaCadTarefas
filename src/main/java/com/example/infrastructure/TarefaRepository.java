package com.example.infrastructure;

import com.example.domain.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    public void save(Tarefa tarefa) {
        tarefa.setId(String.valueOf(tarefas.size() + 1));
        tarefas.add(tarefa);
    }

    public List<Tarefa> findAll() {
        return new ArrayList<>(tarefas);
    }
}