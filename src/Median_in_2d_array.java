import java.util.Arrays;

public class Median_in_2d_array {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 3},
                {2, 6},
                {3, 6}
        };
        System.out.println(median(mat));
    }
    public static int median(int mat[][]) {
        int[] arr = new int[(mat.length)*(mat[0].length)];
        int p = 0;
        for(int[] ar : mat){
            for(int i : ar){
                arr[p] = i;
                p++;
            }
        }
        Arrays.sort(arr);
        int median  = 0;
        if(arr.length%2==0){
            median = (arr[arr.length/2]+arr[(arr.length/2)-1])/2;
        } else{
            median = arr[arr.length/2];
        }
        return median;
    }
}
