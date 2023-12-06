package com.example.test11.learn.design.viewer;

import com.google.common.eventbus.Subscribe;

public class RegPromotionObserver  {

    private PromotionService promotionService;

    @Subscribe
    public void handleRegSuccess(Long userId) {
         //promotionService.issueNewUserExperienceCash(userId);

        System.out.println("给userid 为"+ userId+"优惠券，金额为10元");


    }
}
