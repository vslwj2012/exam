package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 21:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    /**
     * 门店id
     */
    private Integer emporiumId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 库存
     */
    private Integer num;
}
