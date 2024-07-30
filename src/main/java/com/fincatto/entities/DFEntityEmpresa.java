package com.fincatto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empresa", schema = "public")
public class DFEntityEmpresa {

    @Id
    //@Type(type = "pg-uuid")
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @NotNull
    @CreationTimestamp
    @Column(name = "cadastro", nullable = false, updatable = false)
    private LocalDateTime cadastro;

    @NotNull
    @Size(max = 14)
    @Column(name = "documento", nullable = false, length = 14)
    private String documento;

    @NotNull
    @Size(max = 100)
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
}
