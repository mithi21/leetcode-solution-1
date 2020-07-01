/*
    Time complexity : O(N)
    space complexity :O(N)
    worked on leetcode : YES
*/

public class HighestValue_in_each_level {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null  ) return new ArrayList();
        
        List<Integer> result = new ArrayList();
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            int size  = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                max = Math.max(max,node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                
            }
            result.add(max);
        }
        
        return result;
    }
}