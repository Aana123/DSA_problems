public class Number_of_ZeroFilled_Subarrays {
    public static void main(String[] args) {
        int[] nums = {1,3,0,0,7,5};
        System.out.println(zeroFilledSubarray(nums));
    }
    //Optimal solution
    //TC - O(N)
    //SC - O(1)
    public static long zeroFilledSubarray(int[] nums) {
        int i = 0;
        long count = 0;
        long ans = 0;
        while(i<nums.length){
            if(nums[i]==0){
                count++;
            }
            else{
                count = 0;
            }
            ans+=count;
            i++;
        }
        return ans;
    }
    //TLE
    public static long zeroFilledSubarray1(int[] nums) {
        int i = 0;
        long count = 0;
        while(i<nums.length){
            int j = i;
            while(j<nums.length){
                if(nums[j]==0){
                    j++;
                    count++;
                }
                else{
                    break;
                }
            }
            i++;
        }
        return count;
    }
}
