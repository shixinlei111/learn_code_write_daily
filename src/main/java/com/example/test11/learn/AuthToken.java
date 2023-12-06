package com.example.test11.learn;

import java.util.Map;

public class AuthToken {
    // 毫秒
    private static final long default_expire_time_interval = 1*60*1000;
    private String token;
    //还需要 挖掘一些没有出现在功能点描述中属性
    private long expiredTimeInterval = default_expire_time_interval;
    private Long createTime;

    public AuthToken(String token, long expiredTimeInterval, Long createTime) {
        this.token = token;
        this.expiredTimeInterval = expiredTimeInterval;
        this.createTime = createTime;
    }



    //生成token
    public static AuthToken createToken(Long createTime, String baseUrl, Map<String,String> param){
        return null;
    }


    public boolean tokenExpired(){
        return false;
    }

    public boolean match(AuthToken authToken){
        return false;
    }
    public String getToken(){
        return null;
    }

    //从业务模型， url ,appId,这些信息应该不属于 AuthToken , 所以我们不应该放到这个类中，
    //设计类具有哪些属性和方法，不能单纯的依赖当下的需求，
    //还要分析这个类从业务模型上来讲，理应具有哪些属性和方法，
    //
}
