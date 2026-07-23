public class Minimum_Window_Subsequence {
    public static void main(String[] args) {
        String s = "abcdede";
        String t = "bde";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String S, String T) {
        int l = 0, r = 0, m = 0;
        while(r<S.length()){
            int i = 0;
            while(r<S.length()&&i<T.length()){
                if(S.charAt(r)==T.charAt(i)){

                }
            }
        }
        return "";
    }
}
