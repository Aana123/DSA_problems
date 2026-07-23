import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, 0, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    private static void helper(int[] arr, int idx, int sum, int target, List<Integer> list, List<List<Integer>> ans){
        //Base Case
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx==arr.length){
            return;
        }
        //Pick
        if (sum + arr[idx] <= target) {
            list.add(arr[idx]);//1.Choose
            helper(arr,idx,sum+arr[idx],target,list,ans);//2.Explore here, reuse element
            list.remove(list.size()-1);//3.UnChoose -> Backtrack
        }
        //Skip
        helper(arr,idx+1,sum,target,list,ans);//no repetation
    }
}
