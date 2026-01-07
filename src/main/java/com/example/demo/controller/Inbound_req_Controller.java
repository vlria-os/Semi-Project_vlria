package com.example.demo.controller;

import com.example.demo.dto.Inbound_reqDto;
import com.example.demo.dto.Inbound_reqListDto;
import com.example.demo.service.InboundService;
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
public class Inbound_req_Controller {
    private final InboundService inboundService;

    @GetMapping("/office_staff/inbound_req")
    public String inbound_reqForm(){
        return "office_staff/inbound_req";
    }

    @PostMapping("/office_staff/inbound_req")
    public String inbound_req(@ModelAttribute Inbound_reqListDto inbound_reqListDto,
                              HttpSession session,
                              Model model){
        List<Inbound_reqDto> inbound_reqDtos=inbound_reqListDto.getInbound_reqDtos();
        //int webuser_id=(int)session.getAttribute("webuser_id");
        int webuser_id=1000;
        int n=inboundService.insert_request(inbound_reqDtos, webuser_id);

        if(n==1){
            model.addAttribute("result","success");
            model.addAttribute("size",inbound_reqDtos.size());
        }else{
            model.addAttribute("result","failure");
        }
        return "office_staff/inbound_req";
    }
}

/*
<input name="inbound_reqDtos[0].product_id" />
<input name="inbound_reqDtos[0].warehouse_id" />
<input name="inbound_reqDtos[0].quantity" />

<input name="inbound_reqDtos[1].product_id" />
<input name="inbound_reqDtos[1].warehouse_id" />
<input name="inbound_reqDtos[1].quantity" />

<input name="inbound_reqDtos[2].product_id" />
<input name="inbound_reqDtos[2].warehouse_id" />
<input name="inbound_reqDtos[2].quantity" />
 */