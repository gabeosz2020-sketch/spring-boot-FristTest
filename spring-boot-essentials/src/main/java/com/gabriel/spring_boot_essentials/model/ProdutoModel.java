package com.gabriel.spring_boot_essentials.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ProdutoModel {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private int quantidade;

}
