package com.example.test11.learn.design;


import cn.hutool.core.collection.ListUtil;
import com.example.test11.learn.currentLearn.Park;
import com.example.test11.learn.design.Bridge.*;
import com.example.test11.learn.design.Builder.KfcWaiter;
import com.example.test11.learn.design.Builder.Meal;
import com.example.test11.learn.design.Builder.XQSMealBuilder;
import com.example.test11.learn.design.Builder.shuangRenMealBuilder;
import com.example.test11.learn.design.abstractFactoryMethod.Cake;
import com.example.test11.learn.design.abstractFactoryMethod.ElectricCar;

import com.example.test11.learn.design.abstractFactoryMethod.BYDFactory;
import com.example.test11.learn.design.abstractFactoryMethod.YadiFactory;
import com.example.test11.learn.design.adapter.Adaptee;
import com.example.test11.learn.design.adapter.AdapterMy;
import com.example.test11.learn.design.adapter.Target;
import com.example.test11.learn.design.appearance.StereoSystem;
import com.example.test11.learn.design.command.*;
import com.example.test11.learn.design.proxy.ProxyImage;
import com.example.test11.learn.design.template.AbstractClass;
import com.example.test11.learn.design.template.RealUse1;
import com.example.test11.learn.design.template.RealUse2;
import com.example.test11.learn.design.template.UseMethod1;
import com.example.test11.learn.design.viewer.*;
import com.example.test11.learn.learnConcurrent.Worker;
import com.google.common.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;



/**
 * 设计模式  测试
 */
@Slf4j
public class DesignTest {


    @Test
    public void testLiKou2(){
        YadiFactory yadiFactory = new YadiFactory();
        ElectricCar electricCarOfYadi = yadiFactory.createProductA();
        Cake cakeYadi = yadiFactory.createProductB();
        electricCarOfYadi.use();
        cakeYadi.eat();

        BYDFactory bydFactory = new BYDFactory();
        ElectricCar electricCarOfBYD = bydFactory.createProductA();
        Cake CakeByd = bydFactory.createProductB();
        electricCarOfBYD.use();
        CakeByd.eat();
    }



    //测试CountDownLatch
    @Test
    public void testLatch(){

        //模拟王者荣耀 10人加载完 进入 战斗场地

        int  num = 10;
        CountDownLatch toZhanDouArea = new CountDownLatch(num);

        for (int i = 0; i < num; i++) {
            Thread thread = new Thread(new Worker(null, toZhanDouArea));
            thread.start();
        }

        try {
            toZhanDouArea.await();
        } catch (InterruptedException e) {
            log.error("发生异常",e);
            throw new RuntimeException(e);
        }

        System.out.println("10个人开始一起进入 决赛界面");


    }


    //有固定数量的线程执行的操作，将相应的结果 到一个列表中，当所有线程都到 都准备好时，
    // 再执行某个动作

    private  CyclicBarrier cyclicBarrier;
    private List<Integer>   results = Collections.synchronizedList(new ArrayList<>());
    Random random = new Random();
    //每个工作线程要产生的结果数量
    private int resultNums = 3;
    //要执行的线程数量
    private int workerNums = 10;

    //1.变量  个数 线程 ，做一个任务， 加载 各自的 王者荣耀 匹配时 确认过的按钮

    @Test
    public  void testCyclicBarrier(){

        cyclicBarrier = new CyclicBarrier(workerNums,()->{
            if (!CollectionUtils.isEmpty(results) && results.size() == 10){
                //在屏障外等待的线程  最后一个线程执行该任务。
                String thisThreadName = Thread.currentThread().getName();
                System.out.println(thisThreadName+"  已确认：一共"+ workerNums +"人，都已确认，正在进入选择英雄环节");
            }else {
                System.out.println("未集齐 "+workerNums+"人，失败");
            }

        });
        for (int i = 0; i < workerNums; i++) {
            Thread thread = new Thread(new EveryOne());
            thread.start();
        }


    }


    class EveryOne implements Runnable{

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            String threadName = thread.getName();

            for (int i = 0; i < resultNums; i++) {
                int num = random.nextInt(resultNums);
                System.out.println(threadName+"产出的结果：-   "+ num);
            }
            results.add(1);

            try {
                System.out.println(threadName+" 确认之前，已经有 "+cyclicBarrier.getNumberWaiting()+" 个线程在等待");
                cyclicBarrier.await();
            } catch (Exception e) {
               //记录错误
                log.error("发生异常",e);
            }
        }
    }



    @Test
    public void testLatch2(){
//        try{
//            System.out.println("出错前");
//            int i = 1/0;
//            System.out.println("出错后");
//        }finally {
//            System.out.println("检测到出错信号");
//        }

//        ArrayList<Integer> integers = new ArrayList<>();
//
//        boolean contains = integers.contains(1);
//
//        System.out.println(contains);


        String  wsl  = "rtsp://admin:111111hk@192.168.21.195:554/cam/realmonitor?channel=1&subtype=0";
        String  jz = "rtsp://admin:111111hk@192.168.21.195:554/cam/realmonitor?channel=1&subtype=0";
        boolean equals = wsl.equals(jz);
        System.out.println(equals);
    }


    @Test
    public void testParking(){

        //测试一个停车场 场景 ，多个车停位置，
        Park park = new Park(3);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                Thread thread = Thread.currentThread();
                String name = thread.getName();
                park.park(name);
                try {
                    //模拟 停车时间
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                park.leave(name);

            }).start();
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public void testBuilderDesign(){
        KfcWaiter kfcWaiter = new KfcWaiter();
        kfcWaiter.setMealBuilder(new shuangRenMealBuilder());
        Meal construct = kfcWaiter.construct();
        System.out.println(construct);
    }


    @Test
    public void testAdapter(){
        Target target = new AdapterMy(new Adaptee());
        target.request();
    }


    @Test
    public void testVideoPlayer(){

        VideoFormat mp4Format = new MP4Format();
        VideoFormat aviFormat = new AVIFormat();

        Platform windowPlatform = new WindowPlatform();
        Platform linuxPlatform = new LinuxPlatform();

        VideoPlayer videoPlayer = new VideoPlayer(windowPlatform);
        videoPlayer.playVideo(mp4Format);
        videoPlayer.playVideo(aviFormat);

        VideoPlayer videoPlayer2 = new VideoPlayer(linuxPlatform);
        videoPlayer2.playVideo(mp4Format);
        videoPlayer2.playVideo(aviFormat);


    }



    @Test
    public void testAppearance(){

        StereoSystem stereoSystem = new StereoSystem();

        System.out.println("打开音响");
        stereoSystem.startMusic();
        System.out.println("关闭音响");
        stereoSystem.endMusic();

    }



    @Test
    public void testProxy(){

        ProxyImage proxyImage = new ProxyImage("test1.png");
        proxyImage.display();
    }



    @Test
    public void testCommand() throws InterruptedException {

        LIght light = new LIght();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        LightOnAndOffCommand lightOnAndOffCommand = new LightOnAndOffCommand();
        lightOnAndOffCommand.setLightOnCommand(lightOnCommand);
        lightOnAndOffCommand.setLightOffCommand(lightOffCommand);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOnAndOffCommand);
        remoteControl.pressButton();
    }




    //测试观察者模式
    @Test
    public void testViewer() {

//        ConcreteSubject concreteSubject = new ConcreteSubject();
//
 //      ConcreteObserver observer1 = new ConcreteObserver("observer1");
//        ConcreteObserver observer2 = new ConcreteObserver("observer 2");
//
//        concreteSubject.addObserver(observer1);
//        concreteSubject.addObserver(observer2);
//        //状态发生变更，
//        concreteSubject.setState("new State1");
//        concreteSubject.setState("new State2");

//        UserController userController = new UserController();
//        RegNotificationObserver regNotificationObserver = new RegNotificationObserver();
//        RegPromotionObserver regPromotionObserver = new RegPromotionObserver();
//        List<Object> objects = ListUtil.toList(regPromotionObserver,regNotificationObserver);
//
//        userController.setRegObservers(objects);
//        userController.setRegObservers(objects);
//
//        Long userId = userController.register("13934334000", "wadsadfsdfa");
//
//        System.out.println(userId);

//        ArrayList<String> strings = new ArrayList<>();
//        TypeToken<? extends ArrayList> of = TypeToken.of(strings.getClass());
//        Class<?> rawType = of.getRawType();
//        System.out.println(rawType);


        Class<Son1> son1Class = Son1.class;
        Class<Fafher1> fafher1Class = Fafher1.class;
        if (son1Class.isAssignableFrom(fafher1Class)){
            System.out.println("后面的是父类");
        }
        if (fafher1Class.isAssignableFrom(son1Class)){
            System.out.println("前面的是父类");
        }
    }


    @Test
    public void testTemplate() {
        AbstractClass.templateMethod1(new RealUse1());
        System.out.println("\n");
        AbstractClass.templateMethod2(new RealUse2());
    }
}
