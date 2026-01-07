package com.example.demo.mapper;

import com.example.demo.dto.Lot_inDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Lot_inMapper {
    int insert(Lot_inDto lot_inDto);
}
