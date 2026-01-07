package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WarehouseMapper {
    int warehouse_stock(int warehouse_id);
    int warehouse_capacity(int warehouse_id);
}
