package com.example.demo.controller;

import com.example.demo.dto.Inbound_detailDto;
import com.example.demo.service.InboundService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class inbound_app_Controller {
    private final InboundService inboundService;

    @GetMapping("/admin/inbound_app")
    public String inbound_appForm(){
        return "/admin/inbound_app";
    }

    @PostMapping("/admin/inbound_app")
    public String inbound_app(int inbound_id,
                              @ModelAttribute Inbound_detailDto inbound_detailDto,
                              HttpSession session){

       // int approver_id=(int)session.getAttribute("webuser_id"); //검사 필요
        int approver_id=1000; //
        int n=inboundService.update_approval(inbound_id,inbound_detailDto,approver_id);

        return "redirect:/admin/inbound_app";
    }
}
