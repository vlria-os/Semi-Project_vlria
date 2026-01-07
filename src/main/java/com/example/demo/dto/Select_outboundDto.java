package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Select_outboundDto {
    private int inbound_detail_id;
    private int lot_in_id;
    private int stock_id;
    private int product_id;
    private int warehouse;
    private Date expiration_date;
    private int quantity;
}
