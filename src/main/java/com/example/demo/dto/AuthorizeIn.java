package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class AuthorizeIn implements Serializable {

    @NotBlank(message = "缺少response_type参数")
    private String responseType;
    @NotBlank(message ="缺少client_id参数")
    private String clientId;

    private String state;


}
