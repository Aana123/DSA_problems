import java.util.Arrays;
import java.util.HashSet;

public class Matrix_zeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {7,1,2,0},
                {9,4,5,2},
                {1,3,0,5}
        };
        setZeroes3(matrix);
        for (int[] i : matrix) {
            for (int p : i){
                System.out.print(p);
            }
            System.out.println();
        };
    }
    //In-place
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==0){
                    //update the first col with row data
                    matrix[i][0] = 0;
                    //update the first row with col data
                    if(j==0){
                        col0 = 0;
                    } else{
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for (int[] i : matrix) {
            for (int p : i){
                System.out.print(p);
            }
            System.out.println();
        };
        System.out.println(col0);
        if(col0==0){
            for (int j = 0; j < n; j++) {
                matrix[j][0] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if(matrix[0][i]==0){
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    //In-place - rows + array for col
    public static void setZeroes3(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [] col= new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==0){
                    //update the first col with row data
                    matrix[i][0] = 0;
                    //update the first row with col data
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < col.length; i++) {
            if(col[i]==1){
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    //Using array
    public static void setZeroes2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if(row[i]==1){
                for (int j = 0; j < m; j++) {
                       matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < col.length; i++) {
            if(col[i]==1){
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }


    //Brute force
    //TC - O(N*M)
    //SC - O(N)
    public static void setZeroes1(int[][] matrix) {
        HashSet<Integer> r = new HashSet<>();
        HashSet<Integer> c = new HashSet<>();
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(matrix[row][col]==0){
                    r.add(row);
                    c.add(col);
                }
            }
        }
        for(int i : r){
            int col = 0;
            while(col<matrix[0].length){
                matrix[i][col] = 0;
                col++;
            }
        }
        for(int i : c){
            int row = 0;
            while(row <matrix.length){
                matrix[row][i] = 0;
                row++;
            }
        }
    }
}
