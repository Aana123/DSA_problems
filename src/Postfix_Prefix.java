import java.util.Stack;

public class Postfix_Prefix {
    public static void main(String[] args) {
        String post_exp = "ABC/-AK/L-*";
        System.out.println(postToPre(post_exp));
    }
    public static String postToPre(String s) {
        Stack<String> st = new Stack<>();

        for(char c : s.toCharArray()){
            //First Condition
            if(Character.isLetterOrDigit(c)){
                st.push(c+"");
            }
            //Second condition
            else{
                String operand1 = st.pop();
                String operand2 = st.pop();
                String temp = c+operand2+operand1;
                st.push(temp);
            }
        }
        //Since the final answer is in the stack
        String ans = "";
        for (String i : st)
            ans += i;
        return ans;
    }
}
