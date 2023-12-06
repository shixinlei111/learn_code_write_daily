package com.example.test11.learn.design.Builder;

public class shuangRenMealBuilder extends KfcMealBuilder {


    public shuangRenMealBuilder() {
        meal = new Meal();
    }

    @Override
    void buildDrink() {
        meal.setDrink(new KeLe());
    }

    @Override
    void buildFood() {
        meal.setFood(new JiKuai());
    }
}
