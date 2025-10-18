public class Removing_Minimum_and_Maximum_From_Array {
    public static void main(String[] args) {
        int[] nums = {-100000,-99999};
        System.out.println(minimumDeletions(nums));
    }
    //Brute force
    //TC - O(N)
    //SC - O(1)
    public static int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, i1 = -1, i2 = -1;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(nums[i],max);
            if(nums[i]==max){
                i1 = i;
            }
            min = Math.min(nums[i],min);
            if(nums[i]==min){
                i2 = i;
            }
            //max = -99999, i1 = 1
            //min = -100000, i2 = 0
        }
        int l1 = i1+1, l2 = i2+1, r1 = nums.length-i1, r2 = nums.length-i2;
        //l1 = 2, r1  = 1
        //l2 = 1, r2 = 2
        if(l1<=r1 && l2<=r2){
            return Math.max(l1,l2);
        } else if(r1<=l1 && r2<=l2){
            return Math.max(r1,r2);
        }

        max = Math.min(l1,r1);
        min = Math.min(l2,r2);
        //max = 1 min = 1
        int ml = Math.max(l1,l2);
        int mr = Math.max(r1,r2);
        //maxLeft = 2, maxRight = 2
        if(ml<min+max){
            return ml;
        } else if(mr<min+max){
            return mr;
        }
        return min+max;
    }
}
