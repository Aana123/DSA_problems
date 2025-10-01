import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "pwwfewsdfkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    //Sliding window approach
    //TC - O(N)
    //SC - O(N)
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while(right<s.length()){
            if(!hs.contains(s.charAt(right))){
                hs.add(s.charAt(right));
                max = Math.max(max,right-left+1);
            } else{
                while(s.charAt(left)!=s.charAt(right)){
                    hs.remove(s.charAt(left));
                    left++;
                }
                hs.remove(s.charAt(left));
                left++;
                hs.add(s.charAt(right));
            }
            right++;
        }
        return max;
    }

    //Brute force
    //TC - O(N)
    //SC - O(N)
    public static int lengthOfLongestSubstring1(String s){
        char[] ch = s.toCharArray();
        int max = 0;
        HashMap<Character,Integer> hs = new HashMap<>();
        if(ch.length>1){
            hs.put(ch[0],0);
        }
        if(ch.length==1){
            return ch.length;
        }
        for (int i = 1; i <= ch.length-1; i++) {
            if(hs.containsKey(ch[i])){
                i = hs.get(ch[i]);
                hs.clear();
            }
            else{
                hs.put(ch[i],i);
            }
            max = Math.max(hs.size(),max);
        }
        return max;
    }



//    public static int lengthOfLongestSubstring(String s) {
//        HashSet<Character> hs = new HashSet<>();
//        char[] ch = s.toCharArray();
//        int max = 0;
//        for (int i = 0; i<ch.length; i++) {
//            if(hs.isEmpty() || !hs.contains(ch[i])){
//                hs.add(ch[i]);
//                max = Math.max(max,hs.size());
//            }else{
//                int j = 0;
//                while(j<i){
//                    hs.remove(ch[j]);
//                    j++;
//                }
//                hs.add(ch[i]);
//            }
//            System.out.println(hs);
//        }
//        return max;
//    }
}
