package com.example.exam.service;

import com.alibaba.fastjson.JSONObject;
import com.example.exam.entity.Goods;
import com.github.pagehelper.PageInfo;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 14:28
 */
public interface GoodsService {
    boolean addGoods(Goods goods);

    boolean updateGoods(Goods goods);

    boolean deleteGoods(String id);

    PageInfo<Goods> quaryGoods(String name, int pageNo, int pageSize);

    JSONObject queryGivenGoods(String goodsId);
}
