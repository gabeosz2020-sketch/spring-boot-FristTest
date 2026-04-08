package com.gabriel.spring_boot_essentials.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ErroResponse {

    private int status;
    private String message;

}
