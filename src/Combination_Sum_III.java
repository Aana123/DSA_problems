import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k,n));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1,k,n,new ArrayList<>(),result);
        return result;
    }
    private static void helper(int start, int size, int rem, List<Integer> list, List<List<Integer>> res){
        if(list.size()==size && rem==0){
            res.add(new ArrayList<>(list));
            return;
        }
        //Pruning - Stopping a recursive path early when
        //you already know it can’t lead to a valid answer.
        if(list.size()>size || rem<0) return;

        for(int i = start; i<=9; i++){
            list.add(i);
            helper(i+1,size,rem-i,list,res);
            list.remove(list.size()-1);
        }
    }
}
