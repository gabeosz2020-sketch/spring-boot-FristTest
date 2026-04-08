package com.gabriel.spring_boot_essentials.DTOs;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ProdutoDTOs {

    private String nome;
    private BigDecimal preco;
    private int quantidade;

}
