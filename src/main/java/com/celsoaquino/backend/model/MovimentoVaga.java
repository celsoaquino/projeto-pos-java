package com.celsoaquino.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MovimentoVaga {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime entrada;

    @Column
    private LocalDateTime saida;

    @Column(nullable = false)
    private String veiculoId;

    @Column
    private Long duracao;


}
