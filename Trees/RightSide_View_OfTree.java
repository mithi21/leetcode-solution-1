

/*
    BFS solution

    time complexity : O(N)
    space complexity : at most n/2 node at last level in the queue that's wht O(N)
    worked on leetcode : YES

*/

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
public class RightSide_View_OfTree {
    List<Integer> res ;
    public List<Integer> rightSideView(TreeNode root) {
        
        res = new ArrayList();
        if (root == null ) return res;
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(root);
        
        while( !q.isEmpty()){
            int size = q.size();
            
            while(size-- > 1){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            // take it out most rightnode which is the last node present at current level in tree
            TreeNode _node = q.poll();
            res.add(_node.val);
            
             if(_node.left != null) q.add(_node.left);
             if(_node.right != null) q.add(_node.right);
        }
        return res;
    }

   
    List<List<Integer>> result =  new ArrayList();
    public List<Integer> rightSideView_using_DFS(TreeNode root) {
        
        dfs(root, 0);
        for(List<Integer> l : result){
            res.add(l.get(l.size()-1));
        } 
        return res;
        
    }
    
    private void dfs(TreeNode root, int level){
        
        // base
        
        if (root == null) return;
        // logic 
        //  if size== level then add list 
        if( result.size() ==  level){
            result.add(new ArrayList<>());
        }
        
        result.get(level).add(root.val);
        
        dfs(root.left,level +1);
        dfs(root.right, level + 1);
    }
}

/*
    // another method for DFS traversal

    List<Integer> res  =  new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        
        dfs(root, 0);
        return res;
        
    }
    
    private void dfs(TreeNode root, int level){
        
        // base
        
        if (root == null) return;
        // logic 
        
        if( res.size() ==  level){
            res.add(root.val);
        }
       
        dfs(root.right, level + 1);
        dfs(root.left,level +1);
        
    }
*/