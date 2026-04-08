package com.gabriel.spring_boot_essentials.service;

import com.gabriel.spring_boot_essentials.DTOs.ProdutoDTOs;
import com.gabriel.spring_boot_essentials.handler.NotFoundProductException;
import com.gabriel.spring_boot_essentials.model.ProdutoModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoModel> PRODUTOS = new ArrayList<>(List.of(
            ProdutoModel.builder()
                    .id(1L)
                    .nome("Celular")
                    .preco(BigDecimal.valueOf(2000.0))
                    .quantidade(8)
                    .build(),

            ProdutoModel.builder()
                    .id(2L)
                    .nome("Tablet")
                    .preco(BigDecimal.valueOf(5000.0))
                    .quantidade(4)
                    .build(),

            ProdutoModel.builder()
                    .id(3L)
                    .nome("Laptop")
                    .preco(BigDecimal.valueOf(7000.0))
                    .quantidade(3)
                    .build()
    ));

    public static List<ProdutoModel> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    private static long gerarID(){
        return PRODUTOS.stream()
                .map(ProdutoModel::getId)
                .max(Long::compareTo)
                .orElse((long) 0L) + 1;
    }

   public static ProdutoModel createProduct(ProdutoDTOs dtOs){

        ProdutoModel novoProduto = ProdutoModel.builder()
                .id(gerarID())
                .nome(dtOs.getNome())
                .preco(dtOs.getPreco())
                .quantidade(dtOs.getQuantidade())
                .build();

            PRODUTOS.add(novoProduto);
            return novoProduto;

   }

   public static ProdutoModel atualizarProduto(ProdutoDTOs dtos, Long id) throws NotFoundProductException {
        ProdutoModel produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NotFoundProductException("Produto não encontrado"));

        produto.setNome(dtos.getNome());
        produto.setPreco(dtos.getPreco());
        produto.setQuantidade(dtos.getQuantidade());

       return produto;
   }
    public static void deleteProduct(Long id){
        PRODUTOS.removeIf(p -> p .getId().equals(id));

    }

    public ProdutoModel findById(Long id) throws NotFoundProductException {
        return PRODUTOS.stream()
                .filter(p -> id.equals((p.getId())))
                .findFirst()
                .orElseThrow(()-> new NotFoundProductException("Not foud product"));
    }
}
