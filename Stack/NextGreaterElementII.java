/**
Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.



**/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        
        int [] res = new int[nums.length];
        Arrays.fill(res,-1);
        
        Stack<Integer> st = new Stack();
        // we will loop Thrugh entire array twice
        // we will put element in stack until we find bigger element
        // then we popped element untill stack is empty or we have element in stack
        // which is larger than current bigger elemennt
        
        for(int i = 0; i < 2*nums.length;i++) {
//             to maintain current index position
            int index = i % nums.length;
            int currEle = nums[index];
            while(!st.isEmpty() && currEle > nums[st.peek()]) {
                int popped = st.pop();
                res[popped] = currEle;
            }
            
            st.push(index);
            
        }
        
        return res;
    }
}
