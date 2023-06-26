package com.example.exam.dao;

import com.example.exam.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 14:32
 */
public interface GoodsMapper {

    @Insert("insert into goods(id,name,spec,price)" +
            "values(#{id},#{name},#{spec},#{price}) ")
    int addGoods(Goods goods);

    int updateGoods(Goods goods);

    @Delete("delete from goods where id = #{id}")
    int deleteGoods(String id);

    @Select("select * from goods where name like concat('%',#{name},'%')")
    List<Goods> queryGoods(String name);

    @Select("select price from goods where id = #{goodsId}")
    Double queryPriceById(@Param("goodsId") String goodsId);

}
