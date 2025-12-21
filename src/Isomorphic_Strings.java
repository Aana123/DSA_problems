import java.util.Arrays;
import java.util.HashMap;

public class Isomorphic_Strings {
    public static void main(String[] args) {
        String s = "8&", t = "aa";
        System.out.println(isIsomorphic(s,t));
    }

    //Using array[256] for all ASCII values
    //Optimal solution
    //TC - O(N)
    //SC - O(1)
    public static boolean isIsomorphic(String s, String t) {
        int[] key = new int[256];
        int[] val = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(key[sChar]==0 && val[tChar]==0){
                key[sChar] = tChar;
                val[tChar] = sChar;
            } else if(key[sChar]!=tChar){
                return false;
            }
        }
        return true;
    }

    //Using HashMap for all ASCII values
    //TC - O(N)
    //SC - O(1) - since the max this value can go is fixed (256)
    public static boolean isIsomorphic2(String s, String t) {
        HashMap<Character,Character> sChar = new HashMap<>();
        HashMap<Character,Character> tChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(sChar);
            System.out.println(tChar);
            if(!sChar.containsKey(s.charAt(i)) && !tChar.containsKey(t.charAt(i))){
                sChar.put(s.charAt(i),t.charAt(i));
                tChar.put(t.charAt(i),s.charAt(i));
            } else if(!sChar.containsKey(s.charAt(i)) || sChar.get(s.charAt(i))!=t.charAt(i)){
                return false;
            }
        }
        return true;
    }

    //works only for lowercase english alphabets
    //TC - O(N)
    //SC - O(1)
    public static boolean isIsomorphic1(String s, String t) {
        int[] key = new int[26];
        int[] val = new int[26];
        for (int i = 0; i < s.length(); i++) {
            System.out.println(Arrays.toString(key));
            System.out.println(Arrays.toString(val));
            if(key[s.charAt(i)-'a']==0 && val[t.charAt(i)-'a']==0){
                key[s.charAt(i)-'a'] = t.charAt(i);
                val[t.charAt(i)-'a'] = s.charAt(i);
            } else if(key[s.charAt(i)-'a']!=t.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
