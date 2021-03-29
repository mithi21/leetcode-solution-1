
/**
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
Time coplexity : O(N)
Space Complexity: O(N)
Worked on leetcode : YES
**/


class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return T;
        
        
        int[] res  = new int[T.length];
        Stack<Integer> st = new Stack();
        for(int  i = 0;i< T.length; i++) {
            int curr = T[i];
            while(!st.isEmpty() && curr >  T[st.peek()] ) {
                int popIndex = st.pop();
                T[popIndex] = i - popIndex;
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()) {
            T[st.pop()] = 0;
        }
        return T;
    }
}
