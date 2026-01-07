package com.example.demo.service;

import com.example.demo.dto.ApprovalDto;
import com.example.demo.mapper.ApprovalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelService {
    private final ApprovalMapper approvalMapper;

    public List<ApprovalDto> download(){
        List<ApprovalDto> approvalDtos=approvalMapper.selectAll();
        return approvalDtos;
    }
}
