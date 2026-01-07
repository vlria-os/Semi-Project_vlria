package com.example.demo.controller;

import com.example.demo.service.Ref_ExpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RefundController {
    private final Ref_ExpService ref_ExpService;

    @GetMapping("/office_staff/inout_list")
    public String refund_req(){
        return "office_staff/inout_list";
    }

    @PostMapping("/office_staff/inout_list")
    public String refund(){

        ref_ExpService.insert_refund();
        return "";
    }
}
