package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lot_in {
    private int lot_in_id;
    private int inbound_detail_id;
    private int warehouse_id;
    private Date expiration_date;
    private Date received_date;
    private int qauntity;
}
