package com.pousk.gerenciador_tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pousk.gerenciador_tarefas.model.Categoria;
import com.pousk.gerenciador_tarefas.repository.CategoriaRepository;
import java.util.List;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }
}
