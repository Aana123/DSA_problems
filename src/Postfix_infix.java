import java.util.Stack;

public class Postfix_infix {
    public static void main(String[] args) {
        String s = "ab*c+";
        System.out.println(postToInfix(s));
    }
    public static String postToInfix(String s) {
        Stack<String> st = new Stack<>();
        for(char c : s.toCharArray()){
            //First condition - operand
            if(Character.isLetterOrDigit(c)){
                st.push(c+"");
            }
            //Second condition - operator
            else{
                String operand1 = st.pop();
                String operand2 = st.pop();
                String temp = "("+operand2+c+operand1+")";
                st.push(temp);
            }
        }
        String ans = "";
        for(String i : st){
            ans += i;
        }
        return ans;
    }
}
