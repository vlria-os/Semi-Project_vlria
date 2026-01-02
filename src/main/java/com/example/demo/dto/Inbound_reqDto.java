package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class inbound_reqDto {
    private int product_id;
    private int warehouse_id;
    private int quantity;
}
