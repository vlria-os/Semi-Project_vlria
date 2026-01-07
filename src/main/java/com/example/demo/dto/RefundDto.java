package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundDto {
    private int webuser_id;
    private int lot_out_id;
    private int product_id;
    private int warehouse_id;
    private int quantity;
}
