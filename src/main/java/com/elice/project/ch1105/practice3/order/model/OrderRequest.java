package com.elice.project.ch1105.practice3.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OrderRequest {
    private String bookCode;
    private String bookName;
    private long quantity;
}

