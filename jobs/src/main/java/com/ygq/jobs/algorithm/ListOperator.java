package com.ygq.jobs.algorithm;

public class ListOperator {

    public ListNode sortAscend(ListNode head) {
        ListNode head0=head;
        int cnt=0;
        while (head0!=null){
            cnt++;
            head0=head0.Next;
        }
        head0=head;
        for(int i=0;i<cnt-1;i++) {
            while (head != null && head.Next != null) {
                if (head.Next.data < head.data) {
                    head.Next.data = head.data + head.Next.data;
                    head.data = head.Next.data - head.data;
                    head.Next.data = head.Next.data - head.data;
                }
                head = head.Next;
            }
            head=head0;
        }
        return head0;
    }

    public ListNode sortDescend(ListNode head) {
        ListNode head0=head;
        int cnt=0;
        while (head0!=null){
            cnt++;
            head0=head0.Next;
        }
        head0=head;
        for(int i=0;i<cnt-1;i++) {
            while (head != null && head.Next != null) {
                if (head.Next.data > head.data) {
                    head.Next.data = head.data + head.Next.data;
                    head.data = head.Next.data - head.data;
                    head.Next.data = head.Next.data - head.data;
                }
                head = head.Next;
            }
            head=head0;
        }
        return head0;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode head0 = head1;
        while (head1 != null && head1.Next != null) {
            head1 = head1.Next;
        }
        head1.Next = head2;
        return head0;
    }
}
