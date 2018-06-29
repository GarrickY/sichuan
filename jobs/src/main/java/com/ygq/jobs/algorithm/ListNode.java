package com.ygq.jobs.algorithm;

public class ListNode {
    int data;
    ListNode Next;
    ListNode Previous;
    int Length;

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.Next = next;
        Length++;
    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode previous, ListNode next) {
        this.data = data;
        this.Previous = previous;
        this.Next = next;
    }
}
