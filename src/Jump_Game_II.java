public class Jump_Game_II {
    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(jump(nums));
    }
    //Optimal solution
    //TC - O(N)
    //SC - O(1)
    public static int jump(int[] nums) {
        int max = 0, i = 0, count = 0;
        while(max<nums.length-1 && i<nums.length-1){
            int j = i;
            i = max;
            while(j<=i && max<nums.length-1){
                max = Math.max(max,nums[j]+j);
                j++;
            }
            count++;
        }
        return count;
    }
}
