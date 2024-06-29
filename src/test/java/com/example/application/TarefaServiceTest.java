package com.example.application;

import com.example.domain.Tarefa;
import com.example.infrastructure.TarefaRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class TarefaServiceTest {
    private TarefaService tarefaService;
    private TarefaRepository tarefaRepository;

    @Before
    public void setUp() {
        tarefaRepository = mock(TarefaRepository.class);
        tarefaService = new TarefaService(tarefaRepository);
    }

    @Test
    public void deveCadastrarTarefaComSucesso() {
        // Arrange
        String titulo = "Estudar muito Java";
        String descricao = "Estudar arquitetura hexagonal em Java";
        Tarefa tarefa = new Tarefa(titulo, descricao);

        // Act
        Tarefa tarefaCadastrada = tarefaService.cadastrarTarefa(titulo, descricao);

        // Assert
        verify(tarefaRepository).save(any(Tarefa.class)); // Verifica se o método save foi chamado
        assertEquals(titulo, tarefaCadastrada.getTitulo()); // Verifica se o título da tarefa retornada está correto
        assertEquals(descricao, tarefaCadastrada.getDescricao()); // Verifica se a descrição da tarefa retornada está correta
    }

    @Test
    public void deveListarTodasAsTarefas() {
        // Arrange
        Tarefa tarefa1 = new Tarefa("Estudar Java", "Estudar arquitetura hexagonal em Java");
        Tarefa tarefa2 = new Tarefa("Estudar TDD", "Praticar Test Driven Development");

        // Mock do retorno do repositório
        when(tarefaRepository.findAll()).thenReturn(Arrays.asList(tarefa1, tarefa2));

        // Act
        List<Tarefa> tarefas = tarefaService.listarTarefas();

        // Assert
        assertEquals(2, tarefas.size());
        assertEquals(tarefa1.getTitulo(), tarefas.get(0).getTitulo());
        assertEquals(tarefa2.getTitulo(), tarefas.get(1).getTitulo());
    }
}