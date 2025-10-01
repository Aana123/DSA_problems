import java.util.Arrays;
import java.util.HashMap;

public class sort_array_by_frequency {
    public static void main(String[] args) {
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }
    //Try-1
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i : nums) {
            hs.put(i,hs.getOrDefault(i,0)+1);
        }
        int i = 0; int p = 1; int limit = 0;
        while(i<nums.length-1){
            for(int q : hs.keySet()){
                if(p==hs.get(q)){
                    while(i<hs.get(q)+limit){
                        nums[i] = q;
                        i++;
                    }
                    limit = hs.get(q);
                    i--;
                    break;
                }
            }
            p++;
            i++;
        }
        if(nums.length>1){
            nums[nums.length-1] = nums[nums.length-2];
        }
        return nums;
    }
}
