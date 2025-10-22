import java.util.*;
public class Assign_Cookies {
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g,s));
    }
    //Optimal solution
    //TC - O(M log(m) + Nlog(n))
    //SC - O(1)
    public static int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0, ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                ans++;
                i++; j++;
            }else{
                j++;
            }
        }
        return ans;
    }
}
