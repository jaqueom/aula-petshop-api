package br.com.tt.petshop.infra.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "tb_animal")
public class Animal {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private TipoAnimal tipo;

    @Column
    private String nome;

    @Column
    private LocalDate nascimento;

    @Column
    private String foto;

//    @Column
//    private Long clienteId;

    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private Cliente tutor;
}
