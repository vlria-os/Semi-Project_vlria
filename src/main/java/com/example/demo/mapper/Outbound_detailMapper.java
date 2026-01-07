package com.example.demo.mapper;

import com.example.demo.dto.Outbound_detailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Outbound_detailMapper {
    int insert(Outbound_detailDto outboundDetailDto);
    int update_status(Outbound_detailDto outbound_detailDto);
    int update_status_rej(int outbound_id);
    int update_status_conf(int outbound_id);
}
