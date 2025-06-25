import java.util.Stack;

public class Postfix_evaluation {
    public static void main(String[] args) {
        String[] arr = {"1","3","-","4","*"};
        System.out.println(eva(arr));
    }
    public static int eva(String[] s){
        Stack<Integer> st = new Stack<>();
        for(String c : s){
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
