package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lot_out {
    private int lot_out_id;
    private int outbound_detail_id;
    private int warehouse_id;
    private String is_expired;
    private int lot_in_id;
    private int quantity;
    private Date created_at;
}
