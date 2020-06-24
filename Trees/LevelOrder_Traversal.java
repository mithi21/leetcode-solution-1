/*
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],

    [
        [3],
        [9,20],
        [15,7]
    ]


*/
/*
    Using Queue BFS traversel
        Time Complexity :

        Space Complexity :

        is worked on leetcode : 

    // DFS Traversal

        time complexity : O(N)

        space complexity : Recursive space O(H)


        is worked on leetcode : YES



*/
import java.util.*;
/*
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
*/
public class Level_Order_Traversal {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        dfs(root, 0);
        return result;    
    }
    
    private void  dfs(TreeNode root, int level){
        
        // base
        if (root == null ) return ;
        
        if(result.size() == level){
            result.add(new ArrayList<Integer>());
        } 
        result.get(level).add(root.val);
        dfs(root.left,level + 1);
        dfs(root.right, level + 1);
    }
 
 
    public List<List<Integer>> levelOrder_BFS(TreeNode root) {
         List<List<Integer>> res =  new ArrayList();
         Queue<TreeNode> queue = new LinkedList<TreeNode> ();
         if(root == null) return new ArrayList<>();
         HashSet<TreeNode> set = new HashSet<>();
         queue.add(root);
         
         
         while(!queue.isEmpty() ){
             int curr_size = queue.size();
             ArrayList li = new ArrayList();
             
             while(curr_size-- > 0){
                 TreeNode node = queue.poll();
                 if(node.left != null) queue.add(node.left);
                 if(node.right != null) queue.add(node.right);
                 li.add(node.val);
             }
             res.add(li);
         }
         
         return res;
     
     }
 }
 
 