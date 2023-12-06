package com.example.test11;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONArray;
import com.example.test11.learn.design.Bridge.AVIFormat;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


@SpringBootTest
class Test11ApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void test1() throws InterruptedException {
//        CopyOnWriteArraySet<WaterOil> waterOils = new CopyOnWriteArraySet<>();
//        WaterOil waterOil = new WaterOil(1, 2, 3);
//        WaterOil waterOil2 = new WaterOil(1, 2, 3);
//
//        waterOils.add(waterOil2)
//                ;
//        waterOils.add(waterOil);
//
//        for (WaterOil oil : waterOils) {
//
//        }


        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(2000);
        stopwatch.stop(); // optional

        long seconds = stopwatch.elapsed(TimeUnit.SECONDS);
        System.out.println("值为："+ seconds);

    }
    
    


    public int numDecodings(String s) {
//        int n = s.length();

//        f[0] =1;
//        for (int i = 1; i <= n; i++) {
//            if (s.charAt(i-1)!=0){
//                f[i] += f[i-1];
//            }
//            if (i>1&&s.charAt(i-2)!=0&&((s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0'<=26)){
//                f[i] += f[i-2];
//            }
//
//        }
//        return f[n];

       //  f[i-2]  f[i-1],f[i]
        int n = s.length();
        int a= 0, b = 1, c=0;
        for (int i = 1; i <= n; i++) {
            c = 0;
            if (s.charAt(i-1)!=0){
                c += b;
            }
            if (i>1&&s.charAt(i-2)!=0&&((s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0'<=26)){
                c += a;
            }
            a = b;
            b = c;

        }
        return c;

    }


//    public int numDecodings(String s) {
//        int n = s.length();
//        // a = f[i-2], b = f[i-1], c=f[i]
//        int a = 0, b = 1, c = 0;
//        for (int i = 1; i <= n; ++i) {
//            c = 0;
//            if (s.charAt(i - 1) != '0') {
//                c += b;
//            }
//            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
//                c += a;
//            }
//            a = b;
//            b = c;
//        }
//        return c;




    @Test
    public void test2(){

    }


    //反转两个位置之间的 元素
    public ListNode reverseBetween(ListNode head, int left, int right) {

        //先找到 头部
        ListNode beforeHead = new ListNode();
        beforeHead.next = head;

        //尾部自己有，null,
        ListNode node1 = beforeHead;
        ListNode leftNode=null,rightNode=null,beforeLeftNode=null,afterRightNode =null;
        int count = 0;
        while (true){
            if (count == left-1){
                beforeLeftNode = node1;
                leftNode = node1.next;
            }
            node1 = node1.next;
            count++;

            if (count == right){
                rightNode  = node1;
                afterRightNode = rightNode.next;
                break;
            }
        }

        ListNode cur = leftNode;
        ListNode next = cur.next;
        while (next!=null&&next!=afterRightNode) {
             ListNode nextNext = next.next;
             next.next = cur;
             cur = next;
             next = nextNext;
        }

        beforeLeftNode.next = rightNode;
        leftNode.next = afterRightNode;

        return beforeHead.next;
    }



    int SEG_COUNT = 4;
    ArrayList<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    //复原ip地址
    public List<String> restoreIpAddresses(String s) {

        dfs(s,0,0);
        return ans;
    }

    private void dfs(String s, int segId, int segStart) {
        //是4个，且 都用到了，加入
        if (segId == SEG_COUNT){
            if (segStart == s.length()){
                //可以添加
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; i++) {
                    stringBuffer.append(segments[i]);
                    if (i!=SEG_COUNT-1){
                        stringBuffer.append('.');
                    }
                    ans.add(stringBuffer.toString());
                }
            }
            return;
        }
        //没达到4个，却已经遍历完了，
        if (segStart == s.length()){
            return;
        }
        //当前是0的话，不能前置0，直接开启下一段
        if (s.charAt(segStart) == '0'){
            segments[segId] = 0;
            dfs(s,segId+1,segStart+1);
        }

        //一般情况
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr*10+(s.charAt(segEnd)-'0');
            if (addr>0 &&addr<=0xff){
                segments[segId] = addr;
                dfs(s,segId+1,segEnd+1);
            }else {
                break;
            }
        }





    }


    //编写一段代码，输入 int[] 数组 内容为{1，3，5，45，-1，-4，8，10}，对其冒泡排序，将排序后的结果返回。
    @Test
    public void test3() {
        int[] nums = {1, 3, 5, 45, -1, -4, 8, 10};
        bubbleSort(nums);
    }

    //对nums数组进行排序，
    private void bubbleSort(int[] nums) {
    }




}
