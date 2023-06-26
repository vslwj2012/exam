package com.example.exam.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.exam.dao.GoodsMapper;
import com.example.exam.dao.StockMapper;
import com.example.exam.dao.TradeMapper;
import com.example.exam.entity.Goods;
import com.example.exam.entity.Stock;
import com.example.exam.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 14:28
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public boolean addGoods(Goods goods) {
        goods.setId(String.valueOf(UUID.randomUUID()));
        return goodsMapper.addGoods(goods) == 1;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods) == 1;
    }

    @Override
    public boolean deleteGoods(String id) {
        return goodsMapper.deleteGoods(id) == 1;
    }

    @Override
    public PageInfo<Goods> quaryGoods(String name, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Goods> goodsList = goodsMapper.queryGoods(name);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo;
    }

    @Override
    public JSONObject queryGivenGoods(String goodsId) {
        Double among = (double) 0;
        Double price = goodsMapper.queryPriceById(goodsId);
        List<Stock> stockList = stockMapper.queryStockByGoodsId(goodsId);
        JSONObject stockMap = new JSONObject();
        if (stockList == null || stockList.size() == 0) {
            return null;
        }
        for (Stock stock : stockList) {
            String emporiumName = stockMapper.queryEmporiumNameById(stock.getEmporiumId());
            stockMap.put(emporiumName, stock.getNum());
            among = among + price * stock.getNum();
        }
        JSONObject stockMapJSON = new JSONObject();
        stockMapJSON.put("商品库存", stockMap);
        stockMapJSON.put("现有商品总价", among);
        return stockMapJSON;
    }
}
