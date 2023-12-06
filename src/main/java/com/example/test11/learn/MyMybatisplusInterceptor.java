package com.example.test11.learn;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.apache.ibatis.plugin.Invocation;

public class MyMybatisplusInterceptor extends MybatisPlusInterceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return super.intercept(invocation);
    }

    //2.配置文件  再培一下
}

