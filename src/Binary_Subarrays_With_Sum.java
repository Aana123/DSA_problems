import java.util.HashMap;

public class Binary_Subarrays_With_Sum {
    public static void main(String[] args) {
        int[]nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums,goal));
    }
    //Sliding window approach
    //Number of sub-arrays with sum=(goal) = Number of sub-arrays with sum<=(goal)-Number of sub-arrays with sum<=(goal-1);
    //TC - O(N)
    //SC - O(1)
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal)-helper(nums,goal-1);
    }
    public static int helper(int[] nums,int goal){
        int left = 0, ans = 0, sum = 0;
        if(goal<0){
            return 0;
        }
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>goal){
                sum-=nums[left++];
            }
            ans+=right-left+1;
        }
        return ans;
    }

    //Try - 1
    public static int numSubarraysWithSum3(int[] nums, int goal) {
        int left = 0, right = 0, sum = 0, max = 0, cur = 0;
        if(goal < 0 ) return 0;
        while(right<nums.length){

            if(sum<goal){
                sum += nums[right];
                right++;
            } else if(sum==goal){
                sum += nums[right];
                right++; cur++;
                max = Math.max(max,cur);
            } else{
                 while(sum>goal){
                     sum -= nums[left];
                     left++; cur--;
                 }
            }
        }
        return max;
    }

    //Prefix sum based approach
    //TC - O(N)
    //SC - O(N)
    public static int numSubarraysWithSum2(int[] nums, int goal) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        // most important
        hs.put(0, 1);

        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hs.containsKey(sum - goal)) {
                count += hs.get(sum - goal);
            }
            // har case mein current prefix sum ki frequency
            // update karni he hai
            hs.put(sum, hs.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //Brute force
    //TC - O(N^2)
    //SC - O(1)
    public static int numSubarraysWithSum1(int[] nums, int goal) {
        int sum;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum==goal){
                    count++;
                }
            }
        }
        return count;
    }
}
