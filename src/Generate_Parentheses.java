import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Generate_Parentheses {
    public static void main(String[] args) {

    }

    //Optimal solution
    //Recursion with backtracking
    //TC - O()
    //SC - O()
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb,0,0,n,arr);
        return arr;
    }
    private void helper(StringBuilder sb, int op, int cl, int n, List<String> arr){
        //Base Condition
        if(op==n && cl==n){
            arr.add(sb.toString());
            return;
        }

        if(op<n){
            sb.append('(');//1.Choose
            helper(sb,op+1,cl,n,arr);//2.Explore
            sb.deleteCharAt(sb.length()-1);//3.Unchoose
            //"Holy Trinity" of backtracking
        }

        if(cl<op){
            sb.append(')');
            helper(sb,op,cl+1,n,arr);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    //Brute force solution
    //TC - O(n*(2n!/n!))
    //SC - O(n*(2nCn))
    //works till n = 6
    public static List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sbOpen = new StringBuilder();
        StringBuilder sbClose = new StringBuilder();
        for(int i = 0; i<n; i++){
            sbOpen.append('(');
            sbClose.append(')');
        }
        helper(sbOpen.toString(),sbClose.toString(),ans);
        return ans;
    }
    private static HashSet<String> hs = new HashSet<>();
    private static void helper(String p, String up, List<String> arr){
        if(up.isEmpty()){
            if(isValid(p) && !hs.contains(p)) arr.add(p);
            hs.add(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i = 0; i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i);
            helper(f+ch+s,up.substring(1),arr);
        }
    }
    private static boolean isValid(String s){
        int opened = 0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                opened++;
            } else{
                opened--;
            }
            if(opened<0) return false;
        }
        return (opened==0);
    }
}
