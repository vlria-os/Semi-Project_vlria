package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo.dto.ApprovalDto;
import com.example.demo.service.ExcelService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExcelController {
    private final ExcelService excelService;

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        String date=LocalDateTime.now().toString();
        String fileName = URLEncoder.encode("approval_list"+date+".xlsx", "UTF-8").replaceAll("\\+", "%20");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

        List<ApprovalDto> approvalDtos=excelService.download();

        EasyExcel.write(response.getOutputStream(), ApprovalDto.class)
                .sheet("Approval List")
                .doWrite(approvalDtos);
    }
}
