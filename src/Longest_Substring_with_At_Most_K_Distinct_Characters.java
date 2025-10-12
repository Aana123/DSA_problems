import java.util.HashMap;
import java.util.HashSet;

public class Longest_Substring_with_At_Most_K_Distinct_Characters {
    public static void main(String[] args) {
        String s = "bbb";
        int k = 2;
        System.out.println(kDistinctChars(k,s));
    }

    //Sliding window approach
    //TC - O(N)
    //SC - O(1)
    public static int kDistinctChars(int k, String str) {
        int[] ch = new int[26];
        int l = 0, r = 0, max = 0, c =0;
        while(r<str.length()) {
            ch[str.charAt(r) - 'a']++;
            if (ch[str.charAt(r) - 'a'] == 1) {
                c++;
            }
            while (c > k) {
                ch[str.charAt(l)-'a']--;
                //window minimize karne mein either of k mein se jo pehle zero ho jaye us tak ke left
                //increase karenge then uske next character se new window start - IMP
                if (ch[str.charAt(l)-'a'] == 0) {
                    k++;
                }
                l++;
            }
            if (c == k) {
                max = Math.max(max, r - l + 1);
            }
            r++;
        }
        //code360 specific
        if(max==0){
            return str.length();
        }
        return max;
    }

    //Optimal using other datatypes but removal logic feud
    public static int kDistinctChars2(int k, String str) {
        int l = 0, r = 0, max = 0;
        HashMap<Character,Integer> hs1 = new HashMap<>();
        HashSet<Character> hs2 = new HashSet<>();
        while(r<str.length()){
            hs1.put(str.charAt(r),hs1.getOrDefault(str.charAt(r),0)+1);
            //1
            if(hs2.isEmpty()){
                hs2.add(str.charAt(r));
                k--;
            }
            //2
//            else if(hs2.contains(str.charAt(r))){
//                r++;
//            }
            //3
            else if(!hs2.contains(str.charAt(r)) && k>0){
                hs2.add(str.charAt(r));
                k--;
            }
            //4
            else if(!hs2.contains(str.charAt(r)) && k==0 && hs1.get(str.charAt(l))>1){
                while(hs1.get(str.charAt(l))!=0){
                    hs1.put(str.charAt(l),hs1.getOrDefault(str.charAt(l),0)-1);
                    l++;
                }
                hs1.remove(str.charAt(l));
                hs2.remove(str.charAt(l));
                hs2.add(str.charAt(r));
            }
            System.out.println(hs1);
            r++;
            max = Math.max(max,r-l);
        }
        return max;
    }

    //Brute force
    //TC - O(N^2)
    //SC - O(1)
    public static int kDistinctChars1(int k, String str) {
        HashSet<Character> hs = new HashSet<>();
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            hs.clear();
            for (int j = i; j < str.length(); j++) {
                hs.add(str.charAt(j));
                if(hs.size()==k){
                    max = Math.max(max,j-i+1);
                } else if(hs.size()>k){
                    break;
                }
            }
        }
        return max;
    }
}
