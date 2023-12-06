package com.example.test11.learn.design.Builder;

public class KfcWaiter {


    private KfcMealBuilder mealBuilder;

    public Meal construct(){
      mealBuilder.buildDrink();
      mealBuilder.buildFood();
      return mealBuilder.getMeal();
    }

    public void setMealBuilder(KfcMealBuilder mealBuilder){
       this.mealBuilder = mealBuilder;
    }
}
