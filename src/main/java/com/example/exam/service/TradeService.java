package com.example.exam.service;

import com.example.exam.entity.Goods;
import com.example.exam.entity.Trade;
import com.github.pagehelper.PageInfo;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 21:21
 */
public interface TradeService {

    void inBound(Trade trade) throws Exception;

    void outBound(Trade trade) throws Exception;

    PageInfo<Trade> quaryTrade(String name,String tradeDate, int pageNo, int pageSize);
}
