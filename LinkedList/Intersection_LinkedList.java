/*


## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:



begin to intersect at node c1.

Example 1:



Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
Example 2:



Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
Example 3:



Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

// withour hashmap
    Space Complexity : O(1)
    time complexity :O(N+M) M = length of linkedlist 1 and N = size of linkedlist 2
    worked on leetcode : YES
// with hashmap

    space compleity : O(N)
    time complexity : O(M+N)
    worked on leetcode : YES
*/

public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode>  set  =  new HashSet<ListNode>();
        
        while(headA !=  null){
            set.add(headA);
            headA =  headA.next;
        }
        
        while(headB != null){
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
        
    }
    public ListNode getIntersectionNode_using_length(ListNode headA, ListNode headB) {
        ListNode curr  =  headA;
        int countA=0;
        //  find the length of Linkedlist A
        while(curr != null){
            curr = curr.next;
            countA++;
            
        }
        
        curr =  headB;
        int countB=0;
        //  find the length of Linkedlist B
        while(curr != null){
            curr =  curr.next;
            countB++;
          
        }
        // if linkedlist A is bigger than Linkedlist B, 
        // traverse Linkedlist A till it become equals linkedlist B
        while(countA > countB){
            headA =  headA.next;
            countA--;
        }
        // if linkedlist B is bigger than Linkedlist A, 
        // traverse Linkedlist B till it become equals linkedlist A
        while(countB > countA){
            headB =  headB.next;
            countB--;
        }
        // traverse linkedlist A and Linkedlist B until they are equal
        while (headA != headB){
            headA =  headA.next; 
            headB =  headB.next;
            
        }
        
        return headA;
    }


/*
    Maintain two pointers pApA and pBpB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
    When pApA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pBpB reaches the end of a list, redirect it the head of A.
    If at any point pApA meets pBpB, then pApA/pBpB is the intersection node.
    To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'. Since B.length (=4) < A.length (=6), pBpB would reach the end of the merged list first, because pBpB traverses exactly 2 nodes less than pApA does. By redirecting pBpB to head A, and pApA to head B, we now ask pBpB to travel exactly 2 more nodes than pApA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
    If two lists have intersection, then their last nodes must be the same one. So when pApA/pBpB reaches the end of a list, record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no intersections.

*/
    public ListNode getIntersectionNode_TwoPass_Solution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null ) return null;   
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        int swapA = 0;
        int swapB = 0;
        
        while(true){
        
            if (temp1 ==  temp2 ){
                return temp2;
            }
        
            if(temp1 != null){
                temp1 =  temp1.next;
            }else{
                temp1 = headB;
                swapA++;
            }
        
            if(temp2 != null){
                temp2 =  temp2.next;
            }else{
                temp2 = headA;
                swapB++;
            }
        
            if (swapA  == 2 && swapB == 2 ){
                return null;
            }
            
        }
    }
}
