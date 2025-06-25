import java.util.HashMap;

public class Row_with_max_1s {
    public static void main(String[] args) {
        int arr[][] = {
                {0,0,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,1,1,1,1},
                {0,0,0,0,1,1,1,1,1},
                {0,0,0,0,0,0,1,1,1},
                {1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,1,1,1,1},
                {1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1}
        };
        System.out.println(rowWithMax1s(arr));
    }
    //Best :)
    public static int rowWithMax1s(int arr[][]) {
        int[] array = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int p = 0; p < arr[0].length; p++) {
                if(arr[i][p]==1){
                    count++;
                    max = Math.max(max,count);
                }
            }
            array[i] = count;
        }
        int ans = -1;
        for (int i = 0; i<array.length; i++) {
            if(max==array[i]){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
