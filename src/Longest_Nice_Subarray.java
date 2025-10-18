import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Longest_Nice_Subarray {
    public static void main(String[] args) {
        int[] nums = {844110858,19325904,806734874};
        System.out.println(longestNiceSubarray(nums));
    }

    //Sliding window
    //TC - O(N^2)
    //SC - O(N)
    public static int longestNiceSubarray(int[] nums) {
        int left = 0, right = 0, max = 0;
        ArrayList<Integer> hs = new ArrayList<>();
        while(right<nums.length){
            if(hs.isEmpty()){
                hs.add(nums[right]);
                right++;
            } else{
                for(int i = 0; i<hs.size();i++){
                    if((hs.get(i)&nums[right])!=0){
                        while(hs.get(i)!=nums[left]){
                            hs.remove(0);
                            left++; i = 0;
                        }
                        hs.remove(i);
                        left++; i = - 1; //Very IMP
                    }
                }
                hs.add(nums[right]);
                right++;
            }
            max = Math.max(max,right-left);
        }
        return max;
    }

    //TRY - 1
    public static int longestNiceSubarray1(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int max = 0; int left = 0; int right = 0;
        while(right<nums.length){
            for(int i: hs){
                if((i&nums[right])!=0){
                    break;
                }
                System.out.println(hs);
            }
//            if((i&nums[right])==0){
//                hs.add(nums[right]);
//                max = Math.max(max,right-left+1);
//            } else{
//                while(nums[left]!=nums[right]){
//                    hs.remove(nums[left]);
//                    left++;
//                }
//                hs.remove(nums[left]);
//                left++;
//                hs.add(nums[right]);
//            }
            if(hs.isEmpty()){
                hs.add(nums[right]);
            }
            right++;
        }
        return max;
    }
}
