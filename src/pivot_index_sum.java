import java.util.Arrays;
import java.util.HashMap;

public class pivot_index_sum {
    public static void main(String[] args) {
        int[] arr = {-1,-1,0,-1,-1,0};
        System.out.println(pivotIndex(arr));
    }

    //Brute force
    public static int pivotIndex(int[] nums){
        int[] a = new int[nums.length+1];
        int[] b = new int[nums.length+1];

        a[0] = 0;
        b[nums.length] = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            a[i+1] = sum;
        }
        sum = 0;
        for (int i = nums.length-1; i >0 ; i--) {
            sum += nums[i];
            b[i-1] = sum;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(a[i]==b[i]){
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }

    //HashMap ki dikkat overwrites the key value if same value reappears T-T
    public static int pivotIndex1(int[] nums) {
        HashMap<Integer,Integer> a = new HashMap<>();
        HashMap<Integer,Integer> b = new HashMap<>();
        a.put(0,0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            a.put(sum,i+1);
        }
        b.put(0,nums.length-1);
        sum = 0;
        for (int i = nums.length-1; i >=0 ; i--) {
            sum += nums[i];
            b.put(sum,i-1);
        }
        System.out.println(a);
        System.out.println(b);
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(a.containsKey(sum) && b.containsKey(sum)){
                if(a.get(sum)==b.get(sum)){
                    return a.get(sum);
                }
            }
            sum += nums[i];
        }
        return -1;
    }
}
