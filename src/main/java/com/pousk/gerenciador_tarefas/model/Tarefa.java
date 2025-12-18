package com.pousk.gerenciador_tarefas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate; // Usar quando as datas não necessitarem de horas

@Entity
@Data
public class Tarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo é obrigatório")
    @Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres")
    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @FutureOrPresent(message = "A data de vencimento não pode ser no passado")
    private LocalDate dataVencimento;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
