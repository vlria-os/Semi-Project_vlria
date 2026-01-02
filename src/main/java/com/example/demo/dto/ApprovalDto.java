package com.example.demo.dto;

import java.sql.Date;

public class Approval {
    private int approval_id;
    private int approver_id;
    private String bound_type;
    private int inbound_id;
    private int outbound_id;
    private String status;
    private String reason;
    private Date created_at;
}
