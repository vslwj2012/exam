package com.example.exam.dao;

import com.example.exam.entity.Trade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 21:12
 */
public interface TradeMapper {

    int addTrade(Trade trade);

    List<Trade> queryTrade(@Param("goodsId") String goodsId, @Param("tradeDate") String tradeDate);

}
