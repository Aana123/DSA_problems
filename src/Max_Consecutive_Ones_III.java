public class Max_Consecutive_Ones_III {
    public static void main(String[] args) {
        int[] nums = {0,0,1,0,0,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums,k));
    }
    //Sliding window approach
    //TC - O(N)
    //SC - O(1)
    public static int longestOnes(int[] nums, int k) {
        int left = 0; int right = 0; int max = 0;
        while(right<nums.length){
            if(nums[right]==0 && k==0){
                while(nums[left]!=0) {
                    left++;
                }
                left++;
                k++;
            }else if(nums[right]==0 && k>0){
                k--;
                right++;
            }else{
                right++;
            }
            max = Math.max(max,right-left);
        }
        return max;
    }
}
