package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outbound_detail {
    private int outbound_detail_id;
    private int outbound_id;
    private int product_id;
    private int quantity;
}
