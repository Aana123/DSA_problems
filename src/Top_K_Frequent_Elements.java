import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3,1,2};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }

    //Optimized solution
    //TC - O(NlogK)
    //SC - O(K)
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i : nums){
            hs.put(i,hs.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hs.get(a)-hs.get(b));
        for(int i :hs.keySet()){
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }

        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;
    }

    //Brute force
    //TC - O(NlogN)
    //SC - O(N)
    public static int[] topKFrequent1(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i : nums){
            hs.put(i,hs.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hs.get(a)-hs.get(b));
        pq.add(nums[0]);
        for(int i = 0; i<nums.length; i++){
            if(i+1<nums.length && nums[i]!=nums[i+1]){
                pq.add(nums[i+1]);
            }
            if(pq.size()>k) pq.poll();
        }

        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
