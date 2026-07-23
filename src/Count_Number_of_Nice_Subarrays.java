public class Count_Number_of_Nice_Subarrays {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 2;
        System.out.println(numberOfSubarrays(nums,k));
    }
    //Sliding window approach
    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, count = 0;
        while(right<nums.length){
            if(nums[right]%2==1){
                k--;
                right++;
            } else{
                right++;
            }
            if(right!=nums.length && nums[right]%2==0 && k==0){
                left++; count++; k++;
            }
        }
        return count;
    }
    //TC - O(N)
    //SC - O(1)
    public static int numberOfSubarrays2(int[] nums, int k) {
        int l = 0, count = 0, odd = 0;
        for(int r = 0; r<nums.length; r++){
            if(nums[r]%2==1){
                k--;
                odd = 0;
            }
            while(k==0){
                if(nums[l]%2==1){
                    k++;
                }
                odd++;
                l++;
            }
            count += odd;
        }
        return count;
    }

    //TLE
    //TC - O(N^2)
    //SC - O(1)
    public static int numberOfSubarrays1(int[] nums, int k) {
        int i = 0, count = 0, odd = 0;
        while (i < nums.length) {
            int p = i;
            while (p < nums.length) {
                if (nums[p] % 2 != 0) {
                    odd++;
                }
                p++;
                if (odd == k) {
                    count++;
                }
            }
            odd = 0;
            i++;
        }
        return count;
    }
}
