package com.example.test11.learn.design.Flyweight;


public class ChessPieceUnit {

    //id
    private Integer id;
    //名字
    private String name;
    //颜色
    private Color color;


    public ChessPieceUnit(Integer id, String name, Color color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
