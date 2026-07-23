public class Valid_Parenthesis_String {
    public static void main(String[] args) {
        String s = "((()))";
        System.out.println(isValid(s));
    }
    public static boolean checkValidString(String s) {
        //return helper(String s, int );
        return true;
    }
    //Best approach to check isValid
    public static boolean isValid(String s) {
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                open++;
            } else{
                open--;
            }
            if(open<0){
                return false;
            }
        }
        return open==0;
    }
}
