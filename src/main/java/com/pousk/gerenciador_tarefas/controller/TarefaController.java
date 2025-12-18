package com.pousk.gerenciador_tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pousk.gerenciador_tarefas.model.Tarefa;
import com.pousk.gerenciador_tarefas.repository.TarefaRepository;
import jakarta.validation.*;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    
    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody @Valid Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @GetMapping("/categoria/{id}")
    public List<Tarefa> listarPorCategoria(@PathVariable Long id) {
        return tarefaRepository.findByCategoriaId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody @Valid Tarefa tarefaAtualizada) {

        if (!tarefaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        tarefaAtualizada.setId(id);
        Tarefa tarefaSalva = tarefaRepository.save(tarefaAtualizada);

        return ResponseEntity.ok(tarefaSalva);
    }
}
