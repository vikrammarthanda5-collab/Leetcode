/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode tail = head;
        int len=1;
        while(tail.next!=null){
            len+=1;
            tail=tail.next;
        }
        if(k%len==0) return head;
        k=k%len;
        tail.next=head;
        ListNode nnode = findNode(head,len-k);
        head = nnode.next;
        nnode.next=null;
        return head;
    }
    public ListNode findNode(ListNode temp,int k){
        int count=1;
        while(temp!=null){
            if(count==k) return temp;
            count+=1;
            temp=temp.next;
        }
        return temp;
    }
}