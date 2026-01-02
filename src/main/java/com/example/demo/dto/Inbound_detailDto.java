package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inbound_detail {
    private int inbound_detail_id;
    private int inound_id;
    private int product_id;
    private int warehouse_id;
    private String status;
    private int quantity;
}
