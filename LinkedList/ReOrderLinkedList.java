/*
    https://leetcode.com/problems/reorder-list/

    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You may not modify the values in the list's nodes, only nodes itself may be changed.

    Example 1:

    Given 1->2->3->4, reorder it to 1->4->2->3.
    Example 2:

    Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/


/*

    Time complexity : O(N)
    Space Complexity : O(N)
    is worked on leetcode :  YES
*/


public class ReOrderLinkedList {
    
    public void reorderList(ListNode head) {
        
        Stack<ListNode> st =  new Stack<ListNode>();
        
        ListNode temp = head;
        // push all the elements in stack
        while(temp != null){
            st.add(temp);
            temp = temp.next;
        }
        ListNode _next;
        ListNode node;
        //  traverse till count is less than middle of stack

        int cnt=(st.size()-1)/2;
        
        while(cnt-- > 0){
            // keep next of the head so that
            //  after one iteration we will move head to head.next

            _next = head.next;     
            // popped element will be head -> popped element
            node = st.pop();
            head.next = node;
            node.next = _next;
            // set head
            head = _next;
       }
    //    if stack is not empty then take the last element and set it's next to null
    // we are now done
        if(!st.isEmpty()){st.pop().next=null;}
        
    }
}