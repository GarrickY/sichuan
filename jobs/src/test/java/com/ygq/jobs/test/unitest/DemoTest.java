package com.ygq.jobs.test.unitest;

import com.ygq.jobs.unitest.Demo;
import com.ygq.jobs.unitest.StaticDemo;
import mockit.Deencapsulation;
import mockit.Mock;
import mockit.MockUp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {

    @Test
    public void testAddList() {
        new MockUp<StaticDemo>() {
            //mock static method
            @SuppressWarnings("notused")
            @Mock
            public int addStatic(int x, int y) {
                System.out.println(String.format("first number is %d, and second is %d", x, y));
                return 20;
            }
        };

        Demo d = new Demo();
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(5);
        int sum = d.addList(nums);
        System.out.println("the sum is " + sum);
        Assert.assertEquals(sum, 20);
    }


    @Test
    public void testAddList1() {
        new MockUp<StaticDemo>() {
            //mock none static method
            @SuppressWarnings("notused")
            @Mock
            public int add(int x, int y) {
                System.out.println(String.format("first number is %d, and second is %d", x, y));
                return 30;
            }
        };

        Demo d = new Demo();
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(5);
        int sum = d.addList1(nums);
        System.out.println("the sum is " + sum);
        Assert.assertEquals(sum, 30);
    }


    @Test
    public void testAddList2() {
        new MockUp<StaticDemo>() {
            //mock static private method
            @SuppressWarnings("notused")
            @Mock
            public int addFive(int x) {
                System.out.println(String.format("first number is %d", x));
                return 100;
            }
        };


        Demo d = new Demo();
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(5);
        int sum = d.addList2(nums);
        System.out.println("the sum is " + sum);
        Assert.assertEquals(sum, 100);
    }

    @Test
    public void testAddList3() {
        new MockUp<StaticDemo>() {
            //mock private method
            @SuppressWarnings("notused")
            @Mock
            public int addPrivate(int x) {
                System.out.println(String.format("first number is %d", x));
                return 200;
            }
        };


        Demo d = new Demo();
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(5);
        int sum = d.addList3(nums);
        System.out.println("the sum is " + sum);
        Assert.assertEquals(sum, 200);
    }

    @Test
    public void testAddList4() {
        StaticDemo sd = new StaticDemo();
        Deencapsulation.setField(sd, "c", 50);

        int sum = sd.add3(4, 6);
        System.out.println("the sum is " + sum);
        Assert.assertEquals(sum, 60);
    }
}
