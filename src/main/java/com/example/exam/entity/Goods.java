package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lwj
 * @Description 商品类
 * @DateTime 2023/6/26 14:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    /**
     * 身份标识
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 规格
     */
    private String spec;

    /**
     * 单价
     */
    private Double price;
}
