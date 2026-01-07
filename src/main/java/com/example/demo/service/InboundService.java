package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InboundService {
    private final InboundMapper inboundMapper;
    private final Inbound_detailMapper inbound_detailMapper;
    private final ApprovalMapper approvalMapper;
    private final Lot_inMapper lot_inMapper;
    private final StockMapper stockMapper;

    @Transactional
    public int insert_request(List<Inbound_reqDto> inbound_reqDtos,
                              int webuser_id){
        int n=0;
        int m=0;

        InboundDto inboundDto = new InboundDto(
                0, webuser_id, null, null, "N", 0);
        n += inboundMapper.insert(inboundDto);

        for(Inbound_reqDto inbound_reqDto:inbound_reqDtos) {
            int product_id = inbound_reqDto.getProduct_id();
            int warehouse_id = inbound_reqDto.getWarehouse_id();
            int quantity = inbound_reqDto.getQuantity();

            Inbound_detailDto inbound_detailDto = new Inbound_detailDto(
                    0, inboundDto.getInbound_id(),product_id,warehouse_id,
                    null, null, null, quantity);

            m += inbound_detailMapper.insert(inbound_detailDto);

        }

        if(n==1&&m==inbound_reqDtos.size()){
            return 1;
        }else{
            return -1;
        }
    }

    @Transactional
    public int update_approval(int inbound_id,
                               Inbound_detailDto inbound_detailDto,
                               int approver_id){

        int n=inbound_detailMapper.update_status(inbound_detailDto);
        int m=inboundMapper.update_status(inbound_id);
        String status=inboundMapper.select_status(inbound_id);

        if(!status.equals("REQUEST")){
            ApprovalDto approvalDto=new ApprovalDto(
                    0,approver_id,"IN",inbound_id,0,
                    status,null);
            int a=approvalMapper.insert_inbound(approvalDto);
        }
        return 1;
    }

    @Transactional
    public int insert_confirm(int inbound_detail_id,
                              List<Lot_inDto> lot_inDtos,
                              String status,
                              int confirmer_id){

        if(status.equals("REJECTED")){
            int m=inbound_detailMapper.update_status_rej(inbound_detail_id);
        }
        else {
            for (Lot_inDto lot_inDto : lot_inDtos) {
                int n = lot_inMapper.insert(lot_inDto);
                int q = stockMapper.insert(new StockDto(0, lot_inDto.getLot_in_id(), lot_inDto.getQuantity()));
            }
            int m = inbound_detailMapper.update_status_conf(inbound_detail_id);
        }

        return 1;
    }
}
