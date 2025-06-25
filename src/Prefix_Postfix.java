import java.util.Stack;

public class Prefix_Postfix {
    public static void main(String[] args) {
        String pre_exp = "*-A/BC-/AKL";
        System.out.println(preToPost(pre_exp));
    }
    public static String preToPost(String s) {
        Stack<String> st = new Stack();
        char[] arr = s.toCharArray();
        for(int i = s.length()-1; i>=0; i--){
            //First condition
            if(Character.isLetterOrDigit(arr[i])){
                st.push(arr[i]+"");
            }
            //Second condition
            else{
                //String op1 = st.pop();
                //String op2 = st.pop();
                //not needed :)
                String temp = st.pop()+st.pop()+arr[i];
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
