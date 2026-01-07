package com.example.demo.mapper;

import com.example.demo.dto.OutboundDto;
import com.example.demo.dto.Outbound_detailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OutboundMapper {
    int insert(OutboundDto outboundDto);
    int update_status(int outbound_id);
    String select_status(int outbound_id);
}
