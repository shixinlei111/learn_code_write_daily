package com.example.test11.learn.design.Builder;

public class XQSMealBuilder extends KfcMealBuilder {


    public XQSMealBuilder() {
        meal = new Meal();
    }

    @Override
    void buildDrink() {
        meal.setDrink(new ChengChi());
    }

    @Override
    void buildFood() {
        meal.setFood(new JiTui());
    }
}
