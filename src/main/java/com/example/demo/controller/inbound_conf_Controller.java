package com.example.demo.controller;

import com.example.demo.dto.Lot_inDto;
import com.example.demo.dto.Lot_inListDto;
import com.example.demo.service.InboundService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class inbound_conf_Controller {
    private final InboundService inboundService;

    @GetMapping("/field_staff/inbound_conf")
    public String inbound_confFrom(){
        return "field_staff/inbound_conf";
    }

    @PostMapping("/field_staff/inbound_conf")
    public String inbound_conf(@ModelAttribute Lot_inListDto lot_inListDto,
                               HttpSession session){
        //int confirmer_id=(int)session.getAttribute("webuser_id");
        int confirmer_id=1100;
        List<Lot_inDto> lot_inDtos=lot_inListDto.getLot_inDtos();
        int n=inboundService.insert_confirm(lot_inDtos,confirmer_id);

        return "redirect:/field_staff/inbound_conf";
    }

}
