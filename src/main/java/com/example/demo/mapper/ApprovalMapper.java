package com.example.demo.mapper;

import com.example.demo.dto.ApprovalDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApprovalMapper {
    int insert_inbound(ApprovalDto approvalDto);
    int insert_outbound(ApprovalDto approvalDto);
    List<ApprovalDto> selectAll();
}
