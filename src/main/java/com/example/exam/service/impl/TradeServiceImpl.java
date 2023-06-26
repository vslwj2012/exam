package com.example.exam.service.impl;

import com.example.exam.common.Page;
import com.example.exam.dao.GoodsMapper;
import com.example.exam.dao.StockMapper;
import com.example.exam.dao.TradeMapper;
import com.example.exam.entity.Goods;
import com.example.exam.entity.Stock;
import com.example.exam.entity.Trade;
import com.example.exam.service.TradeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.exam.common.Constant.INBOUND;
import static com.example.exam.common.Constant.OUTBOUND;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 21:21
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeMapper tradeMapper;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void inBound(Trade trade) {
        trade.setType(INBOUND);
        trade.setTradeDate(tempDate.format(new Date()));
        tradeMapper.addTrade(trade);
        Stock stock = stockMapper.queryStock(trade.getGoodsId(), trade.getEmporiumId());
        if (stock == null) {
            stockMapper.addStock(trade.getGoodsId(), trade.getEmporiumId(), trade.getNum());
        } else {
            stockMapper.updateStock(trade.getGoodsId(), trade.getEmporiumId(), trade.getNum());
        }
    }

    @Override
    public void outBound(Trade trade) throws Exception {
        trade.setType(OUTBOUND);
        trade.setTradeDate(tempDate.format(new Date()));
        Stock stock = stockMapper.queryStock(trade.getGoodsId(), trade.getEmporiumId());
        if (stock == null) {
            throw new Exception();
        }
        if (stock.getNum() < trade.getNum()) {
            throw new Exception();
        }
        tradeMapper.addTrade(trade);
        trade.setNum(Integer.valueOf(0 - trade.getNum()));
        stockMapper.updateStock(trade.getGoodsId(), trade.getEmporiumId(), trade.getNum());

    }

    @Override
    public PageInfo<Trade> quaryTrade(String name, String tradeDate, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Goods> goodsList = goodsMapper.queryGoods(name);
        List<Trade> tradeList = new ArrayList<>();
        for (Goods goods:goodsList){
             tradeList.addAll(tradeMapper.queryTrade(goods.getId(), tradeDate));
        }

        PageInfo<Trade> pageInfo = new PageInfo<>(tradeList);
        return pageInfo;
    }
}
