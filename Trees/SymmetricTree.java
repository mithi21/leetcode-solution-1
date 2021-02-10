// https://leetcode.com/problems/symmetric-tree/
// BFS version


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
    List<List<Integer>> output ;
    public boolean isSymmetric(TreeNode root) {
        output = new ArrayList();
        // level order traversal
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        
        while(!que.isEmpty()) {
            int size = que.size();
             ArrayList li = new ArrayList();
            while(size-->0) {
                TreeNode node = que.poll();
                
                if(node == null) {
                    li.add(null);
                    
                }else{
                    que.add(node.left);
                    que.add(node.right);
                    li.add(node.val);
                }
            }
            output.add(li);
    
            
        }
        System.out.println(output);
        
        return validateLevel(output);
        
        
    }
    
    private boolean validateLevel(List<List<Integer>> res) {
        int size = res.size();
        for(int i = 1; i< size-1; i++) {
            List<Integer> li = res.get(i);
            if (li.size() % 2 == 1){
                return false;
            }
            
            int left  = 0;
            int right = li.size()-1;
            
            while(left < right) {
                if(li.get(left) != li.get(right))  {
                    return false;
                }
                left++;
                right--;
            }
            
        }
        return true;
        
    }
}
