public class Maximum_Nesting_Depth_of_the_Parentheses {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
    //Optimal solution
    //TC - O(N)
    //SC - O(1)
    public static int maxDepth(String s) {
        int opened = 0, max = -1;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                opened++;
            } else if(s.charAt(i)==')'){
                opened--;
            }
            max = Math.max(opened,max);
        }
        return max;
    }
}
