public class Subarray_sum_min {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,11};
        System.out.println(minSubArrayLen(11,arr));
    }

    //Best
    public static int minSubArrayLen(int target, int[] nums){
        int length = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum>=target){
                length = Math.min(length,right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        if(length==Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }

    //TLE
    public static int minSubArrayLen2(int target, int[] nums){
        int length = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            int p = i;
            while(p<nums.length){
                sum += nums[p];
                if(sum>=target){
                    length = Math.min(length,p-i+1);
                }
                p++;
            }
        }
        if(length==Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }

    //TLE
    public static int minSubArrayLen1(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int p = i; p < nums.length; p++) {
                sum += nums[p];
                System.out.println(sum);
                if(sum >= target){
                    length = Math.min(length,p-i+1);
                }
                System.out.println(length);
            }
        }
        if(length==Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }
}
