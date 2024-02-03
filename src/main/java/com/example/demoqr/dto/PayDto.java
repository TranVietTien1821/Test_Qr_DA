package com.example.demoqr.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PayDto implements Serializable {
    private String status;
    private String mesage;
    private String url;
}
