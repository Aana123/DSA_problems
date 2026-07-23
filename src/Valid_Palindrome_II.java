public class Valid_Palindrome_II {
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }
    public static boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1, k = 1;
        StringBuilder sb = new StringBuilder(s);
        while(l<r){
            if(sb.charAt(l)==sb.charAt(r)){
                l++; r--;
            } else if(sb.charAt(l)!=sb.charAt(r) && k!=0){
                sb.deleteCharAt(r);
                r--; k--;
            } else{
                return false;
            }
        }
        return true;
    }
}
