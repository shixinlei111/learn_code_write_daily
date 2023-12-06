package com.example.test11.learn.design.Flyweight;


import lombok.Data;

// 象棋
@Data
public class ChessPiece {

    private ChessPieceUnit chessPieceUnit;

    //位置
    private Integer positionX;
    private Integer positionY;


    public ChessPiece(ChessPieceUnit chessPieceUnit, Integer positionX, Integer positionY) {
        this.chessPieceUnit = chessPieceUnit;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
