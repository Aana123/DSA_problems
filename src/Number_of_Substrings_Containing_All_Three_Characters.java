import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Number_of_Substrings_Containing_All_Three_Characters {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
    //using array
    //TC - O(N)
    //SC - O(1)
    public static int numberOfSubstrings(String s) {
        int l = 0, c = 0;
        int[] ch = new int[3];
        for(int r = 0; r<s.length(); r++){
            ch[s.charAt(r)-'a']++;
            while(ch[0]>0 && ch[1]>0 && ch[2]>0){
                c += s.length()-r;
                ch[s.charAt(l)-'a']--;
                l++;
            }
        }
        return c;
    }

    //using hashmap
    //TC - O(N)
    //SC - O(1)
    public static int numberOfSubstrings2(String s) {
        int l = 0, r = 0, c = 0;
        HashMap<Character,Integer> hs = new HashMap<>();
        while(r<s.length()){
            hs.put(s.charAt(r),hs.getOrDefault(s.charAt(r),0)+1);
            if(hs.size()==3) {
                while(hs.get('a')>0 && hs.get('b')>0 && hs.get('c')>0){
                    c += s.length()-r;
                    hs.put(s.charAt(l),hs.get(s.charAt(l))-1);
                    l++;
                }
            }
            r++;
        }
        return c;
    }

    //TLE
    public static int numberOfSubstrings1(String s) {
        int l = 0, r = 0, c = 0;
        char[] ch = s.toCharArray();
        Set<Character> hs = new HashSet<>();
        while(r<ch.length){
            hs.add(ch[r]);
            if(hs.contains('a')&&hs.contains('b')&&hs.contains('c')){
                c++;
            }
            r++;
            if(r==ch.length && l<ch.length-2){
                hs.clear();
                l++; r = l;
            }
        }
        return c;
    }
}
