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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode middle = findmiddle(head);
        ListNode lefthead=head;
        ListNode righthead = middle.next;
        middle.next = null;
        lefthead=sortList(lefthead);
        righthead=sortList(righthead);
        return merge(lefthead,righthead);
    }
    ListNode findmiddle(ListNode head){
         ListNode slow = head;
         ListNode fast = head.next;
         while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
         }
         return slow;
    }
    ListNode merge(ListNode list1,ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head;
        if(list1.val<=list2.val){
            head=list1;
            list1=list1.next;
        }
        else{
            head=list2;
            list2=list2.next;
        }
        ListNode temp = head;
        while(list1!=null && list2!=null){
             if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp=temp.next;
        }
        if(list1!=null){
            temp.next = list1;
        }
        else{
            temp.next = list2;
        }
        return head;
    }
}