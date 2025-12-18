package com.pousk.gerenciador_tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pousk.gerenciador_tarefas.model.Tarefa;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
    List<Tarefa> findByCategoriaId(Long id);
}
