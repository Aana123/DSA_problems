import java.util.HashMap;
import java.util.HashSet;

public class Contains_Duplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }
    //Using hashmap
    //TC -O(N)
    //SC -O(N)
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }

        for(int i : hs.keySet()){
            if(hs.get(i)>1){
                return true;
            }
        }
        return false;
    }
    //Using hashset
    //TC -O(N)
    //SC -O(N)
    public static boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<nums.length-1;i++){
            hs.add(nums[i]);
            if(hs.contains(nums[i+1])){
                return true;
            }
        }
        return false;
    }
}
