package com.ygq.jobs.unitest;

import java.util.List;

public class Demo {

    public int addList(List<Integer> numbers) {
        int result = 0;
        for (int x : numbers) {
            result = StaticDemo.addStatic(result, x);
        }
        System.out.println("The result is " + result);
        return result;
    }

    public int addList1(List<Integer> numbers) {
        int result = 0;
        StaticDemo st = new StaticDemo();
        for (int x : numbers) {
            result = st.add(result, x);
        }
        System.out.println("The result is " + result);
        return result;
    }

    public int addList2(List<Integer> numbers) {
        int result = 0;
        for (int x : numbers) {
            result = StaticDemo.addStatic2(result, x);
        }
        System.out.println("The result is " + result);
        return result;
    }

    public int addList3(List<Integer> numbers) {
        int result = 0;
        StaticDemo demo = new StaticDemo();
        for (int x : numbers) {
            result = demo.add2(result, x);
        }
        System.out.println("The result is " + result);
        return result;
    }

    public int addList4(List<Integer> numbers) {
        int result = 0;
        StaticDemo demo = new StaticDemo();
        for (int x : numbers) {
            result = demo.add3(result, x);
        }
        System.out.println("The result is " + result);
        return result;
    }
}
