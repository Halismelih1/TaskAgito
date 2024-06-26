package com.example.demo.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilterProdRes {
    private Integer productId;
    private String productName;
    private Integer productPrice;
}
