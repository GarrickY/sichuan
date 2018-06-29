package com.ygq.jobs.algorithm;

import java.util.*;

public class Program {
    public static void main(String[] para){
        getLinkedList();
        getCamelStringCount();
        System.out.println("End");
    }

    static void getLinkedList(){
        VariousLists ll=new VariousLists();
        Iterator<Integer> it = ll.testLinkedList().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
    static void getCamelStringCount(){
        BigCamelChars camel = new BigCamelChars();
        System.out.println(camel.countCamelChars("asfeerj5jgfrekjj5jx4r5dfaababacdedefelgsfe"));
        Enumeration<String> enumx=camel.resultTable.keys();
        while (enumx.hasMoreElements()){
            String key = enumx.nextElement();
            System.out.println(key +" = " + camel.resultTable.get(key));
        }

//        camel.resultTable.forEach((key, value) -> System.out.println(key + " = " + value));
    }
    static void sortAList(){
        ListOperator operator = new ListOperator();

        //Create a new list1
        ListNode nd4=new ListNode(8,null);
        ListNode nd3=new ListNode(2,nd4);
        ListNode nd2=new ListNode(7,nd3);
        ListNode nd1=new ListNode(6,nd2);
        ListNode nd0=new ListNode(18,nd1);

        ListNode md4=new ListNode(88,null);
        ListNode md3=new ListNode(23,md4);
        ListNode md2=new ListNode(57,md3);
        ListNode md1=new ListNode(63,md2);
        ListNode md0=new ListNode(138,md1);

        System.out.println("Begin to merge two lists!");
        ListNode mergedList=operator.merge(nd0,md0);
        printListItems(mergedList);

        System.out.println("Begin to sort in ascend two lists!");
        printListItems(operator.sortAscend(mergedList));

        System.out.println("Begin to sort in descend two lists!");
        printListItems(operator.sortDescend(mergedList));

    }
    static void printListItems(ListNode head){
        System.out.println("The list items:");
        while (head!=null){
            System.out.println(head.data);
            head=head.Next;
        }
    }
}
