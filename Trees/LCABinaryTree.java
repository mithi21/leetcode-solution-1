/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// is Worked on leetcode :  YES
// time complexity : O(N)
// space complexity : O(max ddepth of tree)

/**

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q 
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Input: root = [1,2], p = 1, q = 2
Output: 1



**/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if root is null return null
        if (root  == null)  return null;
        
        // if we find any of the element return that 
        // here we allowed node to be descedent of it self
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        
        // get left Tree LCA
        
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        // get right Tree LCA
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // if left LCA and right LCA both are not null that
        // means p and q are different side so that root is LCA
        
        if(leftLCA != null && rightLCA != null) {
            return root;
        } 
        // if anyof the side return null LCA , then return not null lca of other side
        else if(leftLCA!= null && rightLCA == null) {
            return leftLCA;
        } else{
            return rightLCA;
        }
        
        
    }
}

// p = 5 q = 1  ans = 3

// p  =  2 q = 4 ans  = 2
// p = 6 q = 4 ans 5
// p = 8 q = 5 ans = 3
