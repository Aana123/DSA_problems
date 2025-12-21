import java.util.Arrays;
import java.util.Stack;

public class Remove_Outermost_Parentheses {
    public static void main(String[] args) {
        String s = "()((()))";
        System.out.println(removeOuterParentheses(s));
    }

    //Optimal solution
    //TC - O(N)
    //SC - O(N)
    //topmost layer start and end indexes needed, single type of brackets-use one var
    // and rather than deleting non-ans part, append only ans part
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                if(opened>0) sb.append(s.charAt(i));
                opened++;
            } else if(s.charAt(i)==')'){
                if(opened>1) sb.append(s.charAt(i));
                opened--;
            }
        }
        return sb.toString();
    }

    //Brute force
    //TC - O(N)
    //SC - O(N)
    public static String removeOuterParentheses1(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(st.isEmpty()){
                ch[i] = '0';
            }
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            } else{
                st.pop();
            }
            if(st.isEmpty()){
                ch[i] = '0';
            }
        }
        System.out.println(Arrays.toString(ch));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]!='0'){
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}
