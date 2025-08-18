import java.util.Stack;

public class Remove_k_digits {
    public static void main(String[] args) {
        String num = "0120200";
        int k = 2;
        System.out.println(removeKdigits(num,k));
    }

    //TC - O(N)
    //SC - O(N)
    public static String removeKdigits(String num, int k) {
        //Convert string to a char array
        char[] arr = num.toCharArray();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<arr.length; i++){
            //remove arr[st.peek()] from stack if and only if it is greater than arr[i]
            while(!st.isEmpty() && arr[st.peek()]>arr[i] && k>0){
                st.pop();
                k--;
                //decrease k on popping an element
            }
            st.push(i);
        }
        //if k>0, start popping elements from the stack until k is equal to 0
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        //transferring elements from stack to string
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(arr[st.pop()]);
        }
        //LIFO
        sb.reverse();
        //to remove leading zeros
        while(!sb.isEmpty() && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        //if the string is empty then, return 0
        if(sb.isEmpty()){
            return "0";
        }
        return sb.toString();
    }
}
