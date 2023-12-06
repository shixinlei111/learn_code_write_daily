package com.example.test11.learn.design.Flyweight;


import java.util.HashMap;



//棋局 ，
public class CheeseBoard {

    //以位置为key(x,y)
    HashMap<String, ChessPiece> pieceHashMap = new HashMap<>();


    //初始化
    public CheeseBoard() {
        init();
    }

    private void init() {
        pieceHashMap.put("0,0",new ChessPiece(ChessPieceUnitFactory.getByUnitId(1),0,0));
        pieceHashMap.put("0,1",new ChessPiece(ChessPieceUnitFactory.getByUnitId(2),0,0));
        pieceHashMap.put("0,2",new ChessPiece(ChessPieceUnitFactory.getByUnitId(3),0,0));

    }


    public void remove(Integer postionX, Integer positionY){
        String key = postionX + "," + positionY;
        pieceHashMap.remove(key);
    }
}
