import java.util.Stack;

public class Infix_Postfix {
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            //First condition
            //If c is operand (letter or digit), then add it into the answer string
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
            //Second condition
            //If c is ( add it to the stack
            else if(c == '('){
                st.push(c);
            }
            //Third condition
            //If c is ) pop all the elements from the stack into the answer string till ( is encountered
            else if(c == ')'){
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();
            }
            //Fourth condition
            //If c is an operator then if the precedence of c is lower than or equal to the precedence of the element
            // at the top of the stack then pop stack elements into the string till an element of lower precedence than
            // c is obtained or stack is emptied
            else{
                while(!st.isEmpty() && prec(c) <= prec(st.peek())){
                    sb.append(st.pop());
                }
                //if the stack is emptied in above operation, element of precedence lower than c is encountered or
                // c had higher precedence already then add c to the stack
                st.push(c);
            }
        }
        //Fifth condition
        //Pop all the remaining elements of the stack into the string
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
    public static int prec(char c){
        if(c == '^') return 3;
        else if(c == '/' || c == '*') return 2;
        else if(c == '+' || c == '-') return 1;
        else return -1;
    }
}
