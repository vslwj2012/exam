package com.example.exam.dao;

import com.example.exam.entity.Stock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 21:52
 */
public interface StockMapper {

    @Select("select * from stock where g_id = #{goodsId} and e_id = #{emporiumId}")
    Stock queryStock(@Param("goodsId") String goodsId, @Param("emporiumId") Integer emporiumId);

    @Insert("insert into stock(e_id, g_id, num) values(#{emporiumId}, #{goodsId}, #{num})")
    int addStock(@Param("goodsId") String goodsId,@Param("emporiumId") Integer emporiumId,@Param("num") Integer num);

    int updateStock(@Param("goodsId") String goodsId,@Param("emporiumId") Integer emporiumId,@Param("num") Integer num);

    List<Stock> queryStockByGoodsId(@Param("goodsId")String goodsId);

    @Select("select name from emporium where id = #{emporiumId}")
    String queryEmporiumNameById(@Param("emporiumId") Integer emporiumId);
}
