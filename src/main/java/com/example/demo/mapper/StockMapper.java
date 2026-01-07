package com.example.demo.mapper;

import com.example.demo.dto.Select_outboundDto;
import com.example.demo.dto.StockDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    int insert(StockDto stockDto);
    int update_out(StockDto stockDto);
    int update_in(StockDto stockDto);
    List<Select_outboundDto> select_outbound(int product_id);
    List<Select_outboundDto> select_expiration();
}
