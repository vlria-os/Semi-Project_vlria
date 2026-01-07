package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundDto {
    private int inbound_id;
    private int webuser_id;
    private Date request_date;
    private String approval_status;
    private String is_refund;
    private int lot_out_id;
}
