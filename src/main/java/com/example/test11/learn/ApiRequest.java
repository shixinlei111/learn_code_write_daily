package com.example.test11.learn;

public class ApiRequest {

    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }



    public static ApiRequest  createFromUrl(String url){
        return null;
    }


    public static String getNewUrl(){
        return null;
    }
}
