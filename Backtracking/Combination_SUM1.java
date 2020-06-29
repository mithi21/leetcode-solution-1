// PRoblem 39 leetcode
//https://leetcode.com/problems/combination-sum/ 

/*

        Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

    The same repeated number may be chosen from candidates unlimited number of times.

    Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
            
Example 1:

    Input: candidates = [2,3,6,7], target = 7,
    A solution set is:
    [
    [7],
    [2,2,3]
    ]
    Example 2:

    Input: candidates = [2,3,5], target = 8,
    A solution set is:
        [
        [2,2,2,2],
        [2,3,3],
        [3,5]
        ]
*/

/*

    Time complexity : 2^n

    space complexity: O(N)

    is worked on leetcode : YES

*/

public class Combination_SUM1 {
    int targ;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        targ = target;
        result =  new ArrayList();
        
        backtrack( candidates, new ArrayList(),0,0);
        return result;
    }
    
    private void backtrack(int[] candidates, List<Integer> temp, int sum, int index){
        
        // base
        if( sum ==  targ) {
            result.add(new ArrayList(temp));
            return;   
        }
        
        if( sum > targ) return;
        
        for( int i = index;i < candidates.length; i++){
            // action
            temp.add(candidates[i]);
            
            // recurse
            backtrack(candidates, temp, sum+ candidates[i],i);
            
            // backtrack
            temp.remove(temp.size() -1 );
        }
    }


}


/*
    You choose it or not and then maintain new list at each recursion

    Using recursion

    class Solution {
    int targ;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        targ = target;
        result =  new ArrayList();
        
        helper( candidates, new ArrayList(),0,0);
        return result;
    }
    
    private void helper(int[] candidates, List<Integer> temp, int sum, int index){
        
        // base case
        
        if( sum ==  targ){
            // System.out.println("index : "+index +"temp "+temp.toString());
            result.add(temp);
            return;
        }
        
        if( sum > targ || index ==  candidates.length) {
            // System.out.println("hey"+sum);
            return;}
        
        // logic
        
        //  if you don't choose move to the next element
        helper( candidates, new ArrayList(temp), sum, index + 1);
        
        // System.out.println("index : "+index + " element "+ candidates[index]); 
        // if you choose
        temp.add(candidates[index]);
        
        helper(candidates, new ArrayList(temp), sum + candidates[index], index);
    }
}


*/