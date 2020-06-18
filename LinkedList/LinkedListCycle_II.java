/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.

 

    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.

    Example 2:

    Input: head = [1,2], pos = 0
    Output: tail connects to node index 0
    Explanation: There is a cycle in the linked list, where tail connects to the first node.

    Example 3:

    Input: head = [1], pos = -1
    Output: no cycle
    Explanation: There is no cycle in the linked 

*/


/*
    HashMap Solution

    Time complexity : O(N)
    Space Complexity : O(N)
    is worked on leetcode : YES

*/
import java.util.HashSet;

public class LinkedListCycle_II {
    public ListNode has_cycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        boolean found = false;
        // iniitlize slow and fast pointer for  floyd's algorithm maintain found boolean variable
        // for handling cycle 
        while(fast!= null && fast.next != null){
            // move slow by one poiner and 
            // fast by two pointer until fast and slow meets 
            //  that means we find cycle
            
            slow =  slow.next;
            fast =  fast.next.next;
            if(fast == slow){
//                 cycle found
                found = true;
                break;
            } 
        }
        
        if(! found) return null; // no cycle
        // set slow pointer to head and now move fast and slow pointer by 1 
        // and if both reaches it is starting
        // point of cycle
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast= fast.next;
        }
        return slow;
    }
    public boolean hasCycle_using_hashMap(ListNode head) {
        
        HashSet<ListNode> set  =  new HashSet<ListNode>();
        
        while(head != null){
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}