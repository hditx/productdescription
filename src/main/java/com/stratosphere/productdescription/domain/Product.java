package com.stratosphere.productdescription.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Boolean availability;
}
