import java.util.Arrays;

public class Subset_Sum_I {
    public static void main(String[] args) {
        int[] candidates = {1,2,3};
        int sum = 6;
        System.out.println(isSubsetSum(candidates,sum));
    }
    public static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        Arrays.sort(arr);
        return helper(arr,0,sum);
    }
    public static Boolean helper(int[] arr, int idx, int rem){
        if(rem==0){
            return true;
        }
        if(idx==arr.length || rem<0){
            return false;
        }

        boolean include = helper(arr,idx+1,rem-arr[idx]);
        boolean exclude = helper(arr,idx+1,rem);
        return include||exclude;
    }
}
