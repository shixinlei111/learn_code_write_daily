package com.example.test11;

import lombok.Data;

@Data
public class QueryInterestOilsVo {

    /**
     * 主键
     */
    private int id;

    /**
     * 水井编码
     */
    private int waterId;

    /**
     * 油井编码
     */
    private int oilId;

    /**
     * 油井名称
     */
    private String oilName;
}
