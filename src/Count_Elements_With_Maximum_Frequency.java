import java.util.HashMap;

public class Count_Elements_With_Maximum_Frequency {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,1,4};
        System.out.println(maxFrequencyElements(arr));
    }

    //Brute force
    //TC - O(N)
    //SC - O(N)
    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }
        int max = 0; int ans = 0;
        for(int i : hs.keySet()){
            max = Math.max(hs.get(i),max);
        }
        for(int i : nums){
            if(hs.get(i)==max){
                ans++;
            }
        }
        return ans;
    }
}
