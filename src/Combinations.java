import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine1(n,k));
        System.out.println(combine(n,k));
    }
    //Slight optimizations
    //TC - 0(nCk)*k - only valid combinations
    //SC - O(N)
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1,n,k,new ArrayList<>(),result);
        return result;
    }
    private static void helper(int start, int n, int k, List<Integer> list, List<List<Integer>> result){
        if(list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i<=n; i++){
            list.add(i);
            helper(i+1,n,k,list,result);
            list.remove(list.size()-1);
        }
    }

    //Brute force
    //TC - 0(2^N) - all possible combinations - binary tree
    //SC - O(N)
    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper1(n,k,new ArrayList<>(),result);
        return result;
    }
    private static void helper1(int n, int k, List<Integer> list, List<List<Integer>> result){
        if(list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        if(n==0){
            return;
        }

        list.add(n);
        helper1(n-1,k,list,result);
        list.remove(list.size()-1);

        helper1(n-1,k,list,result);
    }
}
