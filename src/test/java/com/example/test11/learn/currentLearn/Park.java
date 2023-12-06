package com.example.test11.learn.currentLearn;


import java.util.concurrent.Semaphore;

/**
 *  练习  并发场景，
 */
public class Park {


    private Semaphore semaphore;


    public Park(int positions) {
        this.semaphore = new Semaphore(positions);
    }



    public void  park(String  carNumber){
        try {
            semaphore.acquire();
            System.out.println(carNumber+"停车成功");
        } catch ( Exception e) {
            throw new RuntimeException(e);
        }
    }

//    INSERT oilwell_owWell_rp.oilwell_owWell_event ,app_dev_id=1 ,event_id=32002,rcytime=1697600926,status=0,str_data=example_data 1697600926000000000
//
//    INSERT  oilwell_owWell_event,app_dev_id=1,event_id=32002,status=0 str_data="example_data",rcytime=1697600926 1697600926000000000
//
//    INSERT  oilwell_owWell_event,app_dev_id=1,event_id=32002,status=0 str_data="example_data2",rcytime=1697600926 1697513639000000000



    public void  leave(String  carNumber){
        try {
            semaphore.release();

        } catch ( Exception e) {
            throw new RuntimeException(e);
        }
    }
}
