import java.util.Stack;

public class Remove_k_digits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
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
        //if k>0, start popping elements from the stack until it is
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        //if the stack is empty then, return 0
        if(st.isEmpty()){
            return "0";
        }
        //transferring elements from stack to string
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(arr[st.pop()]);
        }
        //LIFO
        sb.reverse();
        //if all values of string == 0 then return just one zero
        int i = 0;
        while(i<sb.length()){
            if(sb.charAt(i)!='0'){
                break;
            }
            else{
                i++;
            }
        }
        if(i==sb.length()){
            return "0";
        }
        //to remove leading zeros
        while(sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
