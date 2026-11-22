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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp =head;
        ListNode prevNode=null;
        ListNode NextNode;
        while(temp!=null){
            ListNode KNode = findKNode(temp,k);
            if(KNode==null){
                if(prevNode!=null) prevNode.next=temp;
                
                break;
            }
            NextNode = KNode.next;
            KNode.next=null;
            reverse(temp);
            if(temp==head){
                head=KNode;
            }
            else{
                prevNode.next = KNode;
            }
            prevNode = temp;
            temp = NextNode;
        }
      return head;
    }
    ListNode findKNode(ListNode temp,int k){
        k-=1;
        while(temp!=null && k>0){
            k-=1;
            temp=temp.next;
        }
        return temp;
    }
        ListNode reverse(ListNode head){
              ListNode temp = head;
              ListNode prev = null;
             while(temp!=null){
              ListNode front = temp.next;
               temp.next = prev;
               prev = temp;
               temp = front;
        }
        return prev;
      }
   
}