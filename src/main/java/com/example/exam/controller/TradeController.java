package com.example.exam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.exam.common.OutParamDTO;
import com.example.exam.common.Page;
import com.example.exam.entity.Trade;
import com.example.exam.service.TradeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.exam.common.Constant.*;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 21:20
 */
@RestController
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/inBound")
    public JSONObject inBound(Trade trade){
        OutParamDTO outParamDTO = new OutParamDTO();
        try{
            tradeService.inBound(trade);
            outParamDTO.setCode(SUCCESS_CODE);
            outParamDTO.setSuccess(true);
            outParamDTO.setMessage(INBOUND_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            outParamDTO.setCode(FAILURE_CODE);
            outParamDTO.setSuccess(false);
            outParamDTO.setMessage(INBOUND_FAILURE);
        }

        return (JSONObject) JSON.toJSON(outParamDTO);
    }

    @PostMapping("/outBound")
    public JSONObject outBound(Trade trade){
        OutParamDTO outParamDTO = new OutParamDTO();
        try{
            tradeService.outBound(trade);
            outParamDTO.setCode(SUCCESS_CODE);
            outParamDTO.setSuccess(true);
            outParamDTO.setMessage(OUTBOUND_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            outParamDTO.setCode(FAILURE_CODE);
            outParamDTO.setSuccess(false);
            outParamDTO.setMessage(OUTBOUND_FAILURE);
        }

        return (JSONObject) JSON.toJSON(outParamDTO);
    }

    @PostMapping("queryTrade")
    public JSONObject queryGoods(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "tradeDate") String tradeDate,
                                 @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                                 @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        OutParamDTO<Page<Trade>> outParamDTO = new OutParamDTO<>();
        PageInfo<Trade> pageInfo = null;
        try {
            pageInfo = tradeService.quaryTrade(name,tradeDate, pageNo, pageSize);
            Page<Trade> page = new Page<>();
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
}
