/*

    An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

    Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

    To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

    At the end, return the modified image.

    Example 1:
        Input: 
        image = [[1,1,1],[1,1,0],[1,0,1]]
        sr = 1, sc = 1, newColor = 2
        Output: [[2,2,2],[2,2,0],[2,0,1]]
    Explanation: 
        From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
        by a path of the same color as the starting pixel are colored with the new color.
        Note the bottom corner is not colored 2, because it is not 4-directionally connected
        to the starting pixel.
    Note:

        The length of image and image[0] will be in the range [1, 50].
        The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
        The value of each color in image[i][j] and newColor will be an integer in [0, 65535].

*/

/*
    BFS approach

    we will maintain the queue for BFS traversal we will add row and col of the current element in queue
    we will put all the neighbour nodes of starting node intothe queue for subsequenet processing
    but before putting into the queue we will change it with new color. we will change the color to the new color for
    every neighbour having color equals to starting location

    Time Complexity :  O(N)


    Space Complexity : O(N)

    is worked on leetcode : YES

    
*/



public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if( image == null || image.length == 0 || image[sr][sc] ==  newColor) return image;
        int color = image[sr][sc];
        Queue<int[]> queue = new LinkedList();
        int r_count = image.length;
        int c_count = image[0].length;
        image[sr][sc] = newColor;
        queue.add(new int[]{sr,sc});
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    
        while(!queue.isEmpty()){
            int size = queue.size();
           
                int[]m = queue.poll();
                for(int[] dir : dirs){
                    int r = m[0] +  dir[0];
                    int c = m[1] +  dir[1];
                    if( r >= 0 && r < r_count && c >= 0  && c < c_count && image[r][c] == color ){
                        image[r][c] = newColor;  
                        queue.add(new int[]{r,c});
                    }     
                }  
            
        }
        
        return image;
    }
}