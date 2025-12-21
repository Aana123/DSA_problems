public class Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow"};
        System.out.println(longestCommonPrefix(strs));
    }

    //Brute force -> optimized
    //TC - O(S) Where S is sum of all chars (N*M)
    //SC - O(1)
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length<2){
            return strs[0];
        }
        //Horizontal scanning
        String ans = isCommon(strs[0],strs[1]);
        for (int i = 2; i < strs.length; i++) {
            ans = isCommon(ans,strs[i]);
        }
        return ans;
    }

    //Most optimal isCommon method
    //TC - O(M)
    //SC - O(1)
    public static String isCommon(String s1, String s2){
        //using Substring and one index - the one after which no more chars are common
        int i = 0;
        while(i<s1.length() && i<s2.length()){ //dono strings mein at once same index ke char ko compare kar rhe hain
            if(s1.charAt(i)!=s2.charAt(i)) break;
            i++;
        }
        return s1.substring(0,i);
    }
    //TC - O(M)
    public static String isCommon2(String s1, String s2){
        //using StringBuilder
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                break;
            }
            sb.append(s1.charAt(i));
            i++; j++;
        }
        return sb.toString();
    }
    //TC - O(M^2)
    public static String isCommon1(String s1, String s2){
        int i = 0, j = 0;
        String st = "";
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                break;
            }
            st += s1.charAt(i); //using string makes this process m^2
            i++; j++;
        }
        return st;
    }
}
