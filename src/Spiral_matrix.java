import java.util.ArrayList;
import java.util.List;

public class Spiral_matrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4}
        };
        System.out.println(spiralOrder(mat));
    }

    //Best
    //TC - O(M*N)
    //SC - O(1)
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0;
        //traverses the top row of the matrix from left to right
        //0 represents row index

        int right = col-1;
        //traverses the right col of the matrix from top to bottom
        //col-1 represents col index

        int bottom = row-1;
        //traverses the bottom row of the matrix from right to left
        //row-1 represents row index

        int left = 0;
        //traverses the left col of the matrix from bottom to up
        //0 represents col index

        while(top<=bottom && left<=right){
            for(int i = left; i<=right; i++){
               ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i = right; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
