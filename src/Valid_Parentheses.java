import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        String s = "([)((]))";
        System.out.println(isValid(s));
    }

    //Stack based approach
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                st.push(')');
            } else if(s.charAt(i)=='{') {
                st.push('}');
            } else if(s.charAt(i)=='[') {
                st.push(']');
            }
            //Poori string ko traverse karne se pehle he empty ho jaay ya top of the stack
            // char(i) se match na kare toh false
            else if(st.isEmpty() || st.pop()!=s.charAt(i)) {
                return false;
            }
        }
        return st.isEmpty();
    }

    //Using if-else
    //TC - O(N)
    //SC - O(1)
    public static boolean isValid1(String s) {
        while(true){
            if(s.contains("()")){
                s = s.replace("()","");
            } else if(s.contains("{}")){
                s = s.replace("{}","");
            } else if(s.contains("[]")){
                s = s.replace("[]","");
            } else{
                return s.isEmpty();
            }
        }
    }
}
