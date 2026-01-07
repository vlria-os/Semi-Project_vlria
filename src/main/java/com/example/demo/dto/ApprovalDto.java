package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalDto {
    private int approval_id;
    private int approver_id;
    private String bound_type;
    private int inbound_id;
    private int outbound_id;
    private String approval_status;
    private LocalDate created_at;
}
