// 40. Combination Sum II

//https://leetcode.com/problems/combination-sum-ii/

/*

    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

    Each number in candidates may only be used once in the combination.

        Note:

        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.
        
    Example 1:

    Input: candidates = [10,1,2,7,6,1,5], target = 8,
    A solution set is:
    [
    [1, 7],
    [1, 2, 5],
    [2, 6],
    [1, 1, 6]
    ]
    Example 2:

    Input: candidates = [2,5,2,1,2], target = 5,
        A solution set is:
        [
        [1,2,2],
        [5]
        ]

*/

public class Combination_SUM2 {
    
    nt targ;
    Set<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        targ = target;
        result =  new HashSet();
        Arrays.sort(candidates);
        backtrack( candidates, new ArrayList(),0,0);
        return new ArrayList(result);
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
            backtrack(candidates, temp, sum+ candidates[i],i+1);
            
            // backtrack
            temp.remove(temp.size() -1 );
        }
    }
}