package com.example.test11.learn.design.Flyweight;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Editor {

    private List<Character> chars = new ArrayList<>();

    public void appendCharactor(char c, Font font, int size, int colorRGB){

        Character character = new Character(c, font, size, colorRGB);
        chars.add(character);
    }
}
