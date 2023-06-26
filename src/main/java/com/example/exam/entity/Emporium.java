package com.example.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lwj
 * @Description 门店
 * @DateTime 2023/6/26 18:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emporium {
    private Integer id;

    /**
     * 门店名
     */
    private String name;

    /**
     * 门店地址
     */
    private String address;

}
