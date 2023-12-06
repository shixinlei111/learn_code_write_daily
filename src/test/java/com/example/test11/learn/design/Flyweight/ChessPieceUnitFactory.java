package com.example.test11.learn.design.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class ChessPieceUnitFactory {


    private static final Map<Integer,ChessPieceUnit> chessUnitMap = new HashMap<>();


    static {
        //忽略
        chessUnitMap.put(1,new ChessPieceUnit(1,"马",Color.Black));
    }


    public static ChessPieceUnit getByUnitId(Integer unitId) {
        return chessUnitMap.get(unitId);
    }
}
