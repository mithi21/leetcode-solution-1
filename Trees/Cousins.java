
/*
    n a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

    Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

    We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

    Return true if and only if the nodes corresponding to the values x and y are cousins.

    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false
*/

/*
    Using DFS

    Time complexity : O(N)
    space complexity :  recursive stack space O(H)
    is worked on leetcode : YES

*/

public class Cousins {
    


    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        dfs(root,0,null,x,y);
        
        return  (x_parent != y_parent) && (x_depth == y_depth); 
        
        
    }
    
    private void dfs( TreeNode root, int depth,TreeNode parent,int x, int y){
        // base
        if (root == null) return;
        //logic
        
        if(root.val == x ){
            x_depth =  depth;
            x_parent = parent;
        }
        
            if(root.val == y){
            y_depth =  depth;
            y_parent = parent;
        }
        
        
        dfs(root.left, depth + 1, root, x,y);
        
        dfs(root.right, depth + 1, root, x,y);
    }
}