package com.example.test11;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
public class WaterOil implements Serializable {

    /**
     * 撞见
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


    public WaterOil(int id, int waterId, int oilId) {
        this.id = id;
        this.waterId = waterId;
        this.oilId = oilId;
    }
}



