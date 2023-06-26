package com.example.exam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.exam.common.OutParamDTO;
import com.example.exam.common.Page;
import com.example.exam.entity.Goods;
import com.example.exam.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import static com.example.exam.common.Constant.*;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 14:09
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/addGoods")
    public JSONObject addGoods(Goods goods) {
        OutParamDTO outParamDTO = new OutParamDTO();
        if (goodsService.addGoods(goods)) {
            outParamDTO.setCode(SUCCESS_CODE);
            outParamDTO.setSuccess(true);
            outParamDTO.setMessage(ADD_SUCCESS);
        } else {
            outParamDTO.setCode(FAILURE_CODE);
            outParamDTO.setSuccess(false);
            outParamDTO.setMessage(ADD_FAILURE);
        }
        return (JSONObject) JSON.toJSON(outParamDTO);
    }

    @PostMapping("updateGoods")
    public JSONObject updateGoods(Goods goods) {
        OutParamDTO outParamDTO = new OutParamDTO();
        if (goodsService.updateGoods(goods)) {
            outParamDTO.setCode(SUCCESS_CODE);
            outParamDTO.setSuccess(true);
            outParamDTO.setMessage(UPDATE_SUCCESS);
        } else {
            outParamDTO.setCode(FAILURE_CODE);
            outParamDTO.setSuccess(false);
            outParamDTO.setMessage(UPDATE_FAILURE);
        }
        return (JSONObject) JSON.toJSON(outParamDTO);
    }

    @PostMapping("deleteGoods")
    public JSONObject deleteGoods(@RequestParam(name = "id") String id) {
        OutParamDTO outParamDTO = new OutParamDTO();
        if (goodsService.deleteGoods(id)) {
            outParamDTO.setCode(SUCCESS_CODE);
            outParamDTO.setSuccess(true);
            outParamDTO.setMessage(DELETE_SUCCESS);
        } else {
            outParamDTO.setCode(FAILURE_CODE);
            outParamDTO.setSuccess(false);
            outParamDTO.setMessage(DELETE_FAILURE);
        }
        return (JSONObject) JSON.toJSON(outParamDTO);
    }

    @PostMapping("/queryGoods")
    public JSONObject queryGoods(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                                 @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        OutParamDTO<Page<Goods>> outParamDTO = new OutParamDTO<>();
        PageInfo<Goods> pageInfo = null;
        try {
            pageInfo = goodsService.quaryGoods(name, pageNo, pageSize);
            Page<Goods> page = new Page<>();
            page.setData(pageInfo.getList());
            page.setCurrent(pageInfo.getPageNum());
            page.setSize(pageInfo.getSize());
            page.setTotal(pageInfo.getTotal());
            outParamDTO.setSuccess(true);
            outParamDTO.setData(page);
            outParamDTO.setMessage(QUERY_SUCCESS);
            outParamDTO.setCode(SUCCESS_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            outParamDTO.setSuccess(false);
            outParamDTO.setMessage(QUERY_FAILURE);
            outParamDTO.setCode(FAILURE_CODE);
        }
        return (JSONObject) JSON.toJSON(outParamDTO);
    }

    @PostMapping("/queryGivenGoods")
    public JSONObject queryGivenGoods(@RequestParam(name = "goodsId") String goodsId) {
        OutParamDTO outParamDTO = new OutParamDTO();
        JSONObject jsonObject = goodsService.queryGivenGoods(goodsId);
        if (jsonObject != null) {
            outParamDTO.setCode(SUCCESS_CODE);
            outParamDTO.setData(jsonObject);
            outParamDTO.setSuccess(true);
            outParamDTO.setMessage(QUERY_SUCCESS);
        } else {
            outParamDTO.setCode(FAILURE_CODE);
            outParamDTO.setSuccess(false);
            outParamDTO.setMessage(QUERY_FAILURE);
        }
        return (JSONObject) JSON.toJSON(outParamDTO);
    }
}
