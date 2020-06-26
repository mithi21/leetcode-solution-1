/*
    Space Complexity : O(N)
    time complexity : O(N)
    worked on leetcode : YES


*/

/*

    Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

    The distance between two adjacent cells is 1.

    

    Example 1:

    Input:
    [[0,0,0],
    [0,1,0],
    [0,0,0]]

    Output:
    [[0,0,0],
    [0,1,0],
    [0,0,0]]
    Example 2:

    Input:
    [[0,0,0],
    [0,1,0],
    [1,1,1]]

    Output:
    [[0,0,0],
    [0,1,0],
    [1,2,1]]
    

    Note:

    The number of elements of the given matrix will not exceed 10,000.
    There are at least one 0 in the given matrix.
    The cells are adjacent in only four directions: up, down, left and right

*/

class Matrix_01 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null  || matrix.length == 0 ) return null;
        
        Queue<int[]> q  = new LinkedList();
        int r_c = matrix.length;
        int c_c =matrix[0].length;
        // zeros are independent so put them in queue and traverse BFS traversal level by level
        for(int i =0 ;i< r_c ;i++){
            for(int j =0 ;j< c_c; j++){
                if( matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    // set all the ones to minus ones to avoid updating already processed distance
                    matrix[i][j] = -1;
                }
            }
        }
        
        int dist=1;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
//             for level by level processing
//          then at each level increase the distance and update the location accordingly
            for(int k=0;k<size;k++){
                int [] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0] +  dir[0];
                    int c = curr[1] +  dir[1];
                    if( r >=0 && r < r_c && c >=0 && c <  c_c && matrix[r][c] == -1  ){   
                        matrix[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
            }
            
            dist++;
        }
        return matrix;
    }
}