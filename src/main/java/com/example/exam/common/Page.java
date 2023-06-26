package com.example.exam.common;

import lombok.Data;

import java.util.List;

/**
 * @Author lwj
 * @Description
 * @DateTime 2023/6/26 17:19
 */
@Data
public class Page<T> {

    private Integer current;

    private Integer size;

    private Long total;

    private List<T> data;

}
