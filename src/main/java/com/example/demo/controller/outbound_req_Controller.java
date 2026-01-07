package com.example.demo.controller;

import com.example.demo.dto.Inbound_reqDto;
import com.example.demo.dto.Inbound_reqListDto;
import com.example.demo.dto.Outbound_reqDto;
import com.example.demo.dto.Outbound_reqListDto;
import com.example.demo.service.OutboundService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class outbound_req_Controller {
    private final OutboundService outboundService;

    @GetMapping("/office_staff/outbound_req")
    public String outbound_reqForm(){
        //재고 현황 불러오기
        return "office_staff/outbound_req";
    }

    @PostMapping("/office_staff/outbound_req")
    public String outbound_req(@ModelAttribute Outbound_reqListDto outbound_reqListDto,
                               HttpSession session,
                               Model model){
        List<Outbound_reqDto> outbound_reqDtos=outbound_reqListDto.getOutbound_reqDtos();
        //int webuser_id=(int)session.getAttribute("webuser_id");
        int webuser_id=1000; //테스트 데이터
        int n=outboundService.insert_request(outbound_reqDtos, webuser_id);

        if(n==1){
            model.addAttribute("result","success");
            model.addAttribute("size",outbound_reqDtos.size());
        }else{
            model.addAttribute("result","failure");
        }

        return "redirect:/office_staff/outbound_req";
    }
}
