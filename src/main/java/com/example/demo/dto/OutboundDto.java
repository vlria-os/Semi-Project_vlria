package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutboundDto {
    private int outbound_id;
    private int webuser_id;
    private Date request_date;
    private String approval_status;
}
