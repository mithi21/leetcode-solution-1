import java.util.Stack;

/*


## Problem 1

    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    Example 1:

    2

    / \

    1   3

    Input: [2,1,3]
    Output: true
    Example 2:

    5

    / \

    1   4

        / \

        3   6

    Input: [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.

    Time Complexity : O(N)
    Space Complexity :  No Extra Space Recursive space O(H) H is the height of the tree
    Is worked on leetcode : YES

*/

class TreeNode {
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


class TreeNode {
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

public class ValidateBST {
//     TreeNode prev_node;
//     public boolean isValidBST(TreeNode root) {
//         return helper(root,null,null);
//     }

//    private boolean helper(TreeNode root, Integer min, Integer max){
// //         base
//        if(root ==null) return true;
//        // breaching condition
//        if( (max != null && root.val >= max) || ( min != null && root.val <= min )) return false;
//        //  logic
//        return helper(root.left,min, root.val) && helper(root.right,root.val, max);
//    }

    TreeNode prev_node;
    public boolean isValidBST_Recursive(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root){
        if (root == null )return true;
        
//         left subtree
//         if left subtree is not valid BST retunr false
        if( inorder(root.left) == false) return false;
//         check if root is less than or not if it is less than return false
        if(prev_node != null && root.val <= prev_node.val ) return false;
        
        prev_node = root;
//         right subtree
        return inorder(root.right);
        
    }
    public boolean isValidBST_Iterative_InorderSolution(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode prev_node=null;
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev_node != null  && root.val <= prev_node.val) return false;
            prev_node = root;
            root = root.right;
        }
        return true;
        
    }
}