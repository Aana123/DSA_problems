import java.util.Arrays;

public class Reverse_Words_in_a_String {
    public static void main(String[] args) {
        String s = "   the sky is           blue   ";
        System.out.println(reverseWords(s));
    }

    //Optimal solution
    //TC - O(N)
    //SC - O(N)
    //lil optimization
    //instead of running the i>0 check n times, we can simply add all substrings
    // till 0th index and then, separately add the 0th one
    public static String reverseWords(String s) {
        String [] str = s.trim().split("\\s+"); //regex = " " looks only for one whitespace therefore we use, \\s+
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(str));
        for(int i = str.length-1; i>0; i--){
            sb.append(str[i]+" ");
        }
        sb.append(str[0]);
        return sb.toString();
    }

    public static String reverseWords1(String s) {
        String [] str = s.trim().split("\\s+"); //regex = " " looks only for one whitespace therefore we use, \\s+
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(str));
        for(int i = str.length-1; i>=0; i--){
            sb.append(str[i]);
            if(i>0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
