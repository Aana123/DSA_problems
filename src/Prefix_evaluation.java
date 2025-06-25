import java.util.Stack;

public class Prefix_evaluation {
    public static void main(String[] args) {
        String[] arr = {"+","9","*","2","6"};
        System.out.println(eva(arr));
    }
    public static int eva(String[] s){
        Stack<Integer> st = new Stack<>();
        for(int i = s.length-1; i>=0; i--){
            String c =s[i];
            if(isOperator(c)){
                int op1 = st.pop();
                int op2 = st.pop();
                if(c=="+"){
                    st.push(op2+op1);
                } else if(c=="-"){
                    st.push(op2-op1);
                } else if(c=="*"){
                    st.push(op2*op1);
                } else{
                    st.push(op2/op1);
                }
            }
            else{
                st.push(Integer.parseInt(c));
            }
        }
        return st.pop();
    }
    public static boolean isOperator(String c){
        if(c=="*" || c=="-" || c=="+" || c=="/"){
            return true;
        }
        return false;
    }
}
