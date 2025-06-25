import java.util.Stack;

public class Prefix_infix {
    public static void main(String[] args) {
        String s = "*-A/BC-/AKL";
        System.out.println(preToInfix(s));
    }
    public static String preToInfix(String s) {
        Stack<String> st = new Stack();
        char[] arr = s.toCharArray();
        for(int i = s.length()-1; i>=0; i--){
            //First condition
            if(Character.isLetterOrDigit(arr[i])){
                st.push(arr[i]+"");
            }
            //Second condition
            else{
                String temp = "("+st.pop()+arr[i]+st.pop()+")";
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
