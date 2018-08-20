package com.ygq.jobs.algorithm;

import java.util.HashMap;

public class TranslationInEnglish {

    public String translate(long number) {
        String result = "";
        int length = String.valueOf(number).length();
        if (number == 0) {
            result = "zero";
        } else {
            for (int i = 0; i < length && number > 0; i += 3) {
                String result1 = "";
                if (number % (int) Math.pow(10, 3) > 0) {
                    result1 = transSubString(number % Math.pow(10, 3));
                    if (i > 0) {
                        result1 += getTrans((int) Math.pow(10, i - 9 * (i / 12)));
                    }
                }
                number = number / (int) Math.pow(10, 3);
                result = result1 + result;
            }
        }
        System.out.println(result);
        return result;
    }

    private String transSubString(double y) {
        String result = "";

        int i = (int) y;
        //<1000
        while (i > 0) {
            if (i > 99) {
                result += getTrans(i / 100) + getTrans(100) + "and ";
                i %= 100;
            } else if (i > 19) {
                result += getTrans(i / 10 * 10);
                i %= 10;
            } else {
                result += getTrans(i);
                break;
            }
        }
        return result;
    }

    public String getTrans(int i) {
        HashMap<Integer, String> numbers = new HashMap<Integer, String>();
        numbers.put(0, "");
        numbers.put(1, "one ");
        numbers.put(2, "two ");
        numbers.put(3, "three ");
        numbers.put(4, "four ");
        numbers.put(5, "five ");
        numbers.put(6, "six ");
        numbers.put(7, "seven ");
        numbers.put(8, "eight ");
        numbers.put(9, "nine ");
        numbers.put(10, "ten ");
        numbers.put(11, "eleven ");
        numbers.put(12, "twelve ");
        numbers.put(13, "thirteen ");
        numbers.put(14, "fourteen ");
        numbers.put(15, "fifteen ");
        numbers.put(16, "sixteen ");
        numbers.put(17, "seventeen ");
        numbers.put(18, "eighteen ");
        numbers.put(19, "nineteen ");
        numbers.put(20, "twenty ");
        numbers.put(30, "thirty ");
        numbers.put(40, "forty ");
        numbers.put(50, "fifty ");
        numbers.put(60, "sixty ");
        numbers.put(70, "seventy ");
        numbers.put(80, "eighty ");
        numbers.put(90, "ninety ");
        numbers.put(100, "hundred ");
        numbers.put(1000, "thousand ");
        numbers.put(1000000, "million ");
        numbers.put(1000000000, "billion ");
        return numbers.get(i);
    }

}
