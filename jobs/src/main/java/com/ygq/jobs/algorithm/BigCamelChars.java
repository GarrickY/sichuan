package com.ygq.jobs.algorithm;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

public class BigCamelChars {
    Hashtable resultTable=new Hashtable();

    public String countCamelChars(String testStr){
        String original = testStr;
        char[] tests = testStr.toCharArray();
        String camelStr=null;
        for(int i=0;i<tests.length-2;i++){
            if(tests[i] == tests[i+2] && tests[i] != tests[i+1]){
                if(Character.isLowerCase(tests[i]) && !Character.isLowerCase(tests[i+1])){
                    camelStr = String.copyValueOf(tests, i, 3);
                    addStringToResultTable(camelStr);
                    testStr = testStr.replaceFirst(camelStr,"");
                    countCamelChars(testStr);
                }
            }
        }
        return testStr;
    }

    private void addStringToResultTable(String camelStr) {
        if(!resultTable.containsKey(camelStr)){
            resultTable.put(camelStr,1);
        }
        else {
            resultTable.put(camelStr, (int)resultTable.get(camelStr).hashCode()+1); //add .hashCode() to fix compile error, logic may be wrong
        }
    }

}
