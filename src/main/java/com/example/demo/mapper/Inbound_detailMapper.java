package com.example.demo.mapper;

import com.example.demo.dto.InboundDto;
import com.example.demo.dto.Inbound_detailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Inbound_detailMapper {
    int insert(Inbound_detailDto inbound_detailDto);
    int update_status(Inbound_detailDto inbound_detailDto);
    int update_status_rej(int inbound_id);
    int update_status_conf(int inbound_id);
}
