import java.util.HashMap;

public class Subarray_sum_0 {
    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(maxLen(arr));
    }

    //0ms :))
    public static int maxLen(int arr[]) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        hs.put(0,0);
        int sum = 0;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(hs.containsKey(sum)){
                length = Math.max(length,i+1-hs.get(sum));
            } else {
                hs.put(sum,i+1);
            }
            System.out.println(hs);
        }
        return length;
    }

    //TLE
    public static int maxLen1(int arr[]) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int p = i; p < arr.length; p++) {
                sum += arr[p];
                if(sum == 0){
                    length = Math.max(length,p-i+1);
                }
            }
        }
        return length;
    }
}
