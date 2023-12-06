package com.example.test11.learn.design.Flyweight;

import java.awt.*;

//文字
public class Character {


    private char c;

    private Font font;

    private int size;

    private int  colorRGB;


    public Character(char c, Font font, int size, int colorRGB) {
        this.c = c;
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }


}
