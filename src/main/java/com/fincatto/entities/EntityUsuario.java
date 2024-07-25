package com.fincatto.entities;

import jakarta.persistence.*;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario", schema = "public")
public class EntityUsuario {

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

    @NotNull
    @Size(max = 100)
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NotNull
    @Size(max = 100)
    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    @Column(name = "confirmacao", nullable = true, updatable = true)
    private LocalDateTime confirmacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private EntityEmpresa empresa;

}
