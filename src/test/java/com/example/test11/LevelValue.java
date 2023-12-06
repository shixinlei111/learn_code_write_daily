package com.example.test11;

import lombok.Data;

@Data
public class LevelValue {

    private Integer deviceId;

    private Integer level;

    public LevelValue() {
    }

    public LevelValue(Integer deviceId, Integer level) {
        this.deviceId = deviceId;
        this.level = level;
    }
}