import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum2(candidates,target));
    }
    //Optimal solution using recursion
    //TC - O(N*(2^N)) - Exponential
    //SC - O(N)
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); //TC - O(NlogN)
        helper(candidates,0,target,new ArrayList<>(),result);
        return result;
    }
    private static void helper(int[] arr, int idx, int remaining, List<Integer> list, List<List<Integer>> result){
        //Base Case
        if(remaining==0){
            result.add(new ArrayList<>(list));//TC -O(N)
            return;
        }
        if(idx==arr.length){
            return;
        }

        if(remaining-arr[idx]>=0){
            //PICK CURRENT ELEMENT
            list.add(arr[idx]);
            helper(arr,idx+1,remaining-arr[idx],list,result);
            list.remove(list.size()-1);
        }
        //SKIP DUPLICATES
        while(idx+1<arr.length && arr[idx]==arr[idx+1]){
            idx++;
        }
        //SKIP CURRENT ELEMENT
        helper(arr,idx+1,remaining,list,result);
    }
}
