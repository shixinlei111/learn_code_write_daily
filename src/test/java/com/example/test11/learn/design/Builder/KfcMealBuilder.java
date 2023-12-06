package com.example.test11.learn.design.Builder;

//
public abstract class KfcMealBuilder   {

    Meal meal;

    abstract void buildDrink();
    abstract void buildFood();

    public Meal getMeal(){
        return this.meal;
    }


}
