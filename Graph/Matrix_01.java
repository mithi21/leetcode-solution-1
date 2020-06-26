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


/*

DP solution
    Go through the matrix first time and update value at each occurence of 1 to min(ret[i-1][j]+1 , ret[i][j-1]+1). After this step we will have nearest 0s from submatrix starting from (0,0) to (i,j)
    
    Now go through the matrix again, this time update value at each occurence of 1 to min(ret[i][j], ret[i+1][j]+1, ret[i][j+1]+1). This step will give us nearest 0s from submatrix starting from (m,n) to (i,j) and see if that value is less than what we had previously calculated.
Eventually for each grid with value 1, we have the minimum of steps taken from top-left submatrix and bottom-right submatrix.

*/


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length ==  0 ) return null;
        int[][] ret = new int[matrix.length][matrix[0].length];
//         top left
        int[][] dirs={{-1,0},{0,-1}};
        
//          first iteration
        int r_c = matrix.length;
        int c_c = matrix[0].length;
        for(int i =0; i < r_c; i++){
            for(int j = 0; j < c_c; j++){
//                 if zero do nothing
                if(matrix[i][j] == 0 ){
                    ret[i][j] = 0;
                }else{
//                     if 1 check for the top and left value and then update accordingly
                    ret[i][j] =   r_c * c_c;
                    for(int []dir : dirs){
                        int r = dir[0]+ i;
                        int c = dir[1] + j;
                        if( r >= 0   && c >=0 ){
                            ret[i][j] = Math.min(ret[i][j], ret[r][c]+1); 
                        }
                    }
                    
                }
            }
        }
        
        // second iteration
        // right bottom
        dirs =  new int[][]{{1,0},{0,1}};
        for(int i =r_c-1; i  >=0; i--){
            for(int j = c_c-1; j >=0 ; j--){
//                 if zero do nothing
                if(matrix[i][j] == 0 ){
                    ret[i][j] = 0;
                }else{
//                     if 1 check for the right and bottom value and then update accordingly
                    for(int []dir : dirs){
                        int r = dir[0]+ i;
                        int c = dir[1] + j;
                        if(  r< r_c  && c < c_c ){
                            ret[i][j] = Math.min(ret[i][j], ret[r][c]+1 ); 
                        }
                    }
                }
                
                
            }
        }
        return ret;
        
        
    }
}