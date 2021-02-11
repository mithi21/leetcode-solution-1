/*

    Given a linked list, remove the n-th node from the end of list and return its head.

    Example:

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:

    Given n will always be valid.

    Follow up:

    Could you do this in one pass?



*/


/*

    Time Complexity :  O(N)
    Space Complexity : O(1)
    is worked on leetcode : YES


*/

public class RemoveLastNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy =  new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
//         dummy node points to head, created for handling head removal
        
        dummy.next = head;
        
        int count = 0;
//         maintain size n window  and move fast pointer till counter reach nth 

        while(count <= n){
            fast = fast.next;
            count++;
        }
        //  and then move slow pointer by one and fast by one till fast reaches end
        //  now slow pointer will be at the node  before the node you want to delete

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        // delete the node
        slow.next = slow.next.next;
        // return ddummy.next which is pointing to correct head all the time
        return dummy.next;
    }


    public ListNode removeNthFromEnd_UsingLength(ListNode head, int n) {
        
        
        if(head == null ) return null;
        // if (head.val == n )  return null;
        ListNode temp = head;
        int count = 0;
        int len = length (temp);
//          when you are deleting head
        if(n ==  len) return head.next;
        
        int diff = len - n;
        // get the difference
        while (count <diff - 1 ){
            temp = temp.next;
            count=count+1;
        }
       
        
        temp.next = temp.next.next;
        
        
        return head;
        
    }
    private int length(ListNode head){
        int len = 0;
        while (head != null){
            len +=1;
            head = head.next;
        }
        return len;
    }
    
    /**
    /**

Approach is to find the leangth of linkedlist by travering the list
then traverse the list before the elemenet to be removed and then change the pointer 
check if prev is null which is happened when trying to remove head
[1,2] remove 2nd from end which means remove 1


**/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null) return null;
        if (head.next  == null  && n == 1) return null;
        ListNode temp = head;
        ListNode headNext = head;
        int length = getLength(temp);
        int limit =length - n;
        ListNode prev=null;
        while(limit-->0){
            prev = temp;
            temp = temp.next;
        }
        
//         special case for head Removal
        if(prev == null) {
            headNext = headNext.next;
            return headNext;
        }
        if(temp.next == null) {
            prev.next = null;
        }
        
        prev.next = temp.next;
        return headNext;
    }
    
    private int getLength(ListNode node) {
        int i = 0;
        
        while(node != null) {
            node = node.next;
            i++;
        }
        return i;
    }
}

    
    **/
    
}
