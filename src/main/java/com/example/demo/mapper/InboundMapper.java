package com.example.demo.mapper;

import com.example.demo.dto.InboundDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InboundMapper {
    int insert(InboundDto inboundDto);
    int update_status(int inbound_id);
    String select_status(int inbound_id);
}
