import java.util.Arrays;

public class Freq_of_most_frequent_ele {
    public static void main(String[] args) {
        int[] nums = {3,9,6};
        System.out.println(maxFrequency(nums,2));
    }

    //Brute force
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int p = nums.length-1;
        int max = 0;
        while(p>0){
            int chk = nums[p];
            int count = 0;
            for (int i = 0; i<=p; i++) {
                if(nums[i]+k>=chk){
                    count++;
                    k = k-chk+nums[i];
                }
            }
            max = Math.max(max,count);
            p--;
        }
        return max;
    }
}
