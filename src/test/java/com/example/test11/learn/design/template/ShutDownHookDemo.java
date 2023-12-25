package com.example.test11.learn.design.template;

public class ShutDownHookDemo {


    private static class ShutdownHook extends Thread{
        @Override
        public void run() {
            System.out.println("Shut down,提示结束了,钢琴");
        }

        public static void main(String[] args) {
            Runtime.getRuntime().addShutdownHook(new ShutdownHook());
        }
    }

}

