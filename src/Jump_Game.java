public class Jump_Game {
    public static void main(String[] args) {
        int[] nums = {2,1,3,1,5,3};
        System.out.println(canJump(nums));
    }
    //Optimal solution
    //TC - O(N)
    //SC - O(1)
    public static boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i<nums.length-1; i++){
            if(max>=i){
                max = Math.max(nums[i]+i,max);
            }
        }
        if(max>=nums.length-1) return true;
        return false;
    }
}
