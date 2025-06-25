import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lucky_numbers_in_matrix {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},
                          {9,11,13},
                          {15,16,17}
        };
        System.out.println(luckyNumbers(matrix));
    }

    //Optimum solution
    //TC - O(M∗N+M^2)
    //SC - O(N)
    public static List<Integer> luckyNumbers(int[][] matrix){
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int minCol = -1; //smartt move
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]<min){
                    min = matrix[i][j];
                    minCol = j;
                }
            }
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max,matrix[j][minCol]);

            }
            if(min == max){
                lis.add(min);
            }
        }
        return lis;
    }

    //Brute force
    //TC - O(N^2)
    //SC - O(N)
    public static List<Integer> luckyNumbers1(int[][] matrix) {
        HashMap<Integer,Integer> row = new HashMap<>();
        HashMap<Integer,Integer> col = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int j = 0; int p = j;
            while (j < matrix[0].length) {
                if(matrix[i][j]<min){
                    min = matrix[i][j];
                    p = j;
                }
                j++;
            }
            row.put(min,p);
        }
        System.out.println(row);
        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max,matrix[j][i]);
            }
            col.put(i,max);
        }
        System.out.println(col);
        List<Integer> lis = new ArrayList<>();
        for (int i : row.keySet()){
            if(i==col.get(row.get(i))){
                lis.add(i);
            }
        }
        return lis;
    }
}
