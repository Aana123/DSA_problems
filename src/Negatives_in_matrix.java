public class Negatives_in_matrix {
    public static void main(String[] args) {
        int[][] grid = {{3,2},{-3,-3},{-3,-3},{-3,-3}};
        System.out.println(countNegatives(grid));
    }
    public static int countNegatives(int[][] grid){
        int row = 0;
        int col = grid[0].length-1;
        int count = 0;
        while(row<grid.length && col>=0){
            if(grid[row][col]<0){
                col--;
            }
            else if(grid[row][col]>=0){
                //mistake 1
                count += grid[0].length-1-col;
                row++;
            }
            if(col==-1){
                //mistake 2
                count += (grid.length-row)*(grid[0].length-1-col);
            }
        }
        return count;
    }
    //Brute force
    //TC - O(N^2)
    //SC - O(1)
    public static int countNegatives1(int[][] grid) {
        int count = 0;
        for (int[] i : grid) {
            for (int p : i){
                if(p<0){
                    count++;
                }
            }
        }
        return count;
    }
}
