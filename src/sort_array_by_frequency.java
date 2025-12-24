import java.util.Arrays;
import java.util.HashMap;

public class sort_array_by_frequency {
    public static void main(String[] args) {
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    //Brute force
    //TC - O(N^2)
    //SC - O(N)
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        int[] ans = new int[nums.length];
        for(int i : nums) {
            hs.put(i,hs.getOrDefault(i,0)+1);
        }
        int idx = 0;
        while(!hs.isEmpty()){
            int minF = Integer.MAX_VALUE, val = 0;
            for(int i : hs.keySet()){
                if(hs.get(i)<minF){
                    minF = hs.get(i);
                    val = i;
                } else if(hs.get(i)==minF && i>val){ //the extra condition
                    minF = hs.get(i);
                    val = i;
                }
            }
            for(int i = 0; i<minF; i++){
                ans[idx] = val;
                idx++;
            }
            hs.remove(val,minF);
        }

        return ans;
    }

    //Incomplete
    // but will not work for the condition that -
    // when two elements have same freq then the larger number comes first
    public static int[] frequencySort2(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }
        int[][] mat = new int[hs.size()][2];
        for (int i = 0; i < mat.length; i++) {
            mat[i][0] = hs.get(nums[i]);
            mat[i][1] = nums[i];
        }
        Arrays.sort(mat,(a, b) -> Integer.compare(b[0],a[0]));
        System.out.println(Arrays.deepToString(mat));
        return new int[1];
    }

    //Try-1
    public static int[] frequencySort1(int[] nums) {
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
