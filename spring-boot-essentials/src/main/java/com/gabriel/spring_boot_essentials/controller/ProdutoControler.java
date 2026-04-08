package com.gabriel.spring_boot_essentials.controller;

import com.gabriel.spring_boot_essentials.DTOs.ProdutoDTOs;
import com.gabriel.spring_boot_essentials.handler.NotFoundProductException;
import com.gabriel.spring_boot_essentials.model.ProdutoModel;
import com.gabriel.spring_boot_essentials.service.ProdutoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
@Getter
@Setter
public class ProdutoControler {
    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ProdutoModel> findAll(){
        return produtoService.findAll();
    }

   @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel createProduto(@RequestBody ProdutoDTOs dtOs){
        return ProdutoService.createProduct(dtOs);
   }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoModel updateProduct(@PathVariable Long id,@RequestBody ProdutoDTOs dtOs) throws NotFoundProductException {
        return ProdutoService.atualizarProduto(dtOs, id);
   }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        ProdutoService.deleteProduct(id);
    }
}