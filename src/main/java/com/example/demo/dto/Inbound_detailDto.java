package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inbound_detailDto {
    private int inbound_detail_id;
    private int inbound_id;
    private int product_id;
    private int warehouse_id;
    private String approval_status;
    private String reason;
    private String inbound_status;
    private int quantity;
}
