import java.util.HashMap;
import java.util.HashSet;

public class Subarray_With_K_Distinct_Integers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums,k));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    //number of elements in sub-array with k distinct elements - number of elements in sub-array with k-1 distinct elements
    public static int helper(int[] nums,int k){
        int left = 0, right = 0, cnt = 0;
        if(k==0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        while(right<nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            cnt += right - left + 1;
            right++;
        }
        return cnt;
    }

    public static int subarraysWithKDistinct2(int[] nums, int k) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        int l = 0, r = 0, count = 0, unique = 0;
        while(r<nums.length){
            hs.put(nums[r],hs.getOrDefault(nums[r],0)+1);
            if(hs.get(nums[r])==1){
                unique++;
            }
            while(unique>k){
                hs.put(nums[l],hs.getOrDefault(nums[l],0)-1);
                if(hs.get(nums[l])==0){
                    unique--;
                }
                l++;
                count += r-l-1;
            }
            if(unique==k){
                count++;
            }
            r++;
        }
        return count;
    }
    public static int subarraysWithKDistinct1(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int l = 0, r = 0, c = 0;
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            //if no distinct values
            if(set.isEmpty()){
                set.add(nums[r]);
            }
            //a,b k=2
            else if(!set.contains(nums[r]) && set.size()<k){
                set.add(nums[r]);
            }
            //a,b,a,b k=2
//            else if(){
//
//            }
            r++;
        }
        return c;
    }
}
