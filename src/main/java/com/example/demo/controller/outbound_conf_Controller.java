package com.example.demo.controller;

import com.example.demo.dto.Lot_outDto;
import com.example.demo.dto.Lot_outListDto;
import com.example.demo.service.OutboundService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class outbound_conf_Controller {
    private final OutboundService outboundService;

    @GetMapping("/field_staff/outbound_confirm")
    public String outbound_confFrom(){
        return "outbound_conf";
    }

    @PostMapping("/field_staff/outbound_confirm")
    public String outbound_conf(int outbound_detail_id,
                               @ModelAttribute Lot_outListDto lot_outListDto,
                               String status,
                               HttpSession session){
        //int confirmer_id=(int)session.getAttribute("webuser_id");
        int confirmer_id=1100;
        List<Lot_outDto> lot_outDtos=lot_outListDto.getLot_outDtos();
        int n=outboundService.insert_confirm(outbound_detail_id,status,confirmer_id);

        return "redirect:/field_staff/outbound_confirm";
    }
}
