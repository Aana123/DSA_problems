import java.util.HashSet;

public class Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        String s = "AABB";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }
    //Sliding window approach
    //TC - O(N)
    //SC - O(1)
    public static int characterReplacement(String s, int k){
        int max = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int left = 0, right = 0, p = 0;
            while (right < s.length() && max!=s.length()) {
                //AA
                if (s.charAt(right) == c) {
                    right++;
                }
                //AB, k>0
                else if (p < k) {
                    right++;
                    p++;
                }
                //AAB, k=0, l = 0 or 1 (i.e, removing same character so no p--;)
                else if (s.charAt(left) == c) {
                    left++;
                }
                //AAB, k=0, l = 2 (hence p--;)
                else {
                    left++;
                    p--;
                }
                max = Math.max(max, right - left);
            }
        }
        return max;
    }


    //TLE
    public static int characterReplacement2(String s, int k){
        HashSet<Character> hs = new HashSet<>();
        int left = 0; int right = 0; int max = 0; int p = k;
        while(right<s.length()){
            if(hs.isEmpty()){
                hs.add(s.charAt(right));
                right++;
            }
            if(!hs.contains(s.charAt(right)) && k==0){
                while(hs.contains(s.charAt(left))) {
                    left++;
                }
                hs.remove(s.charAt(left-1));
                hs.add(s.charAt(left));
                right = left+1;
                k = p;
            }else if(!hs.contains(s.charAt(right)) && k>0){
                k--;
                right++;
            }else{
                right++;
            }
            max = Math.max(max,right-left);
        }
        while(k>0 && max<s.length()){
            left--; k--;
            max = Math.max(max,right-left);
        }
        hs.clear();
        k = p;
        left = s.length()-1;
        right = s.length()-1;
        while(left>=0){
            if(hs.isEmpty()){
                hs.add(s.charAt(left));
                left--;
            }
            if(!hs.contains(s.charAt(left)) && k==0){
                while(hs.contains(s.charAt(right))) {
                    right--;
                }
                hs.remove(s.charAt(right+1));
                hs.add(s.charAt(right));
                left = right-1;
                k = p;
            }else if(!hs.contains(s.charAt(left)) && k>0){
                k--;
                left--;
            }else{
                left--;
            }
            max = Math.max(max,right-left);
        }
        return max;
    }


    //Problem in case, s = "ABCDDD"; k = 3;
    public static int characterReplacement1(String s, int k) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0; int right = 0; int max = 0; int p = k;
        while(right<s.length()){
            if(hs.isEmpty()){
                hs.add(s.charAt(right));
                right++;
            }
            if(!hs.contains(s.charAt(right)) && k==0){
                while(hs.contains(s.charAt(left))) {
                    left++;
                }
                hs.remove(s.charAt(left-1));
                hs.add(s.charAt(left));
                right = left+1;
                k = p;
            }else if(!hs.contains(s.charAt(right)) && k>0){
                k--;
                right++;
            }else{
                right++;
            }
            max = Math.max(max,right-left);
        }
        while(k>0 && max<s.length()){
            left--; k--;
            max = Math.max(max,right-left);
        }
        return max;
    }
}
