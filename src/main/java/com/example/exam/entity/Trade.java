package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author lwj
 * @Description 台账表
 * @DateTime 2023/6/26 17:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trade {

    /**
     * 流水号
     */
    private String id;

    /**
     * 类型 '1'为出库 '0'为入库
     */
    private Integer type;

    /**
     * 门店id
     */
    private Integer emporiumId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 日期
     */
    private String tradeDate;
}
