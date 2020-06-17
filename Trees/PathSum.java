/*

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1


return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


*/


class Pair{
    TreeNode key;
    int val;
    
    public Pair(TreeNode key, int val){
        this.key = key;
        this.val = val;
    }
    
    public int getValue(){
        return this.val;
    }
    public TreeNode getKey(){
        return this.key;
    }
}
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root,0,sum);
    }
    
     private boolean helper(TreeNode root, int currSum,int sum){
         
        if (root ==  null) return false;
        if( root.left == null && root.right == null && currSum + root.val == sum ) return true;
        
        return helper(root.left, currSum+ root.val, sum ) || helper(root.right, currSum+ root.val, sum );

    }
    public boolean hasPathSumIterative(TreeNode root, int sum) {
        
        if (root == null ) return false;
        Stack<Pair> st = new Stack();
        int resSum = 0;
        while (  root != null || !st.isEmpty()){
            
            while (root != null){
                resSum+= root.val;
                st.push(new Pair(root,resSum));
                root = root.left;
            }
            
            Pair p = st.pop();
            root = p.getKey();
            resSum = p.getValue();
            
//             if leaf node and resSum ==  sum return True
//             else traverse right sub tree
            if( root.left == null && root.right == null && resSum == sum) return true;
//             traverse right subtree
            root = root.right;
        }
        
        return false;
        
    }
}