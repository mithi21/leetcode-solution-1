//https://leetcode.com/problems/path-sum-ii/submissions/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList();
        target = targetSum;
        if(root == null){
            return res;
        }
        
        preOrder(root,0, new ArrayList());
        return res;
        
    }
    
    private  void preOrder(TreeNode root, int sum, List<Integer> temp) {
        System.out.println(temp);
        
        if(root == null ){    
          return;  
        } 
        
        if( root.left == null && root.right == null){
            if(sum + root.val == target) {
                List<Integer> t = new ArrayList(temp);
                t.add(root.val);
                res.add(t);    
            }
        }
        
        
        List<Integer> li = new ArrayList(temp);
        li.add(root.val);
        if(root.left != null) {
            preOrder(root.left,  sum + root.val ,li );
        }
        if(root.right != null) {
            preOrder(root.right, sum +  root.val , li);
        }
        
        
    }
}
