import java.util.HashMap;

public class Minimum_Window_Substring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANAC";
        String t = "ABAC";
        System.out.println(minWindow(s,t));
    }

    //Sliding window brute force
    //TC - O(M+N)
    //SC - O(M+N)
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> ht = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
        }

        HashMap<Character,Integer> hs = new HashMap<>();
        int l = 0, r = 0, m = Integer.MAX_VALUE;
        int leftIndex = -1, rightIndex = -1;
        while(r<s.length()){
            if(ht.containsKey(s.charAt(r))){
                hs.put(s.charAt(r),hs.getOrDefault(s.charAt(r),0)+1);
            }
            while(checker(ht,hs)){
                m = Math.min(r-l+1,m);
                if(r-l+1==m){
                    leftIndex = l;
                    rightIndex = r;
                }
                if(ht.containsKey(s.charAt(l))){
                    hs.put(s.charAt(l),hs.getOrDefault(s.charAt(l),0)-1);
                }
                l++;
            }
            System.out.println(hs);
            r++;
        }
        if(leftIndex!=-1 && rightIndex!=-1){
            return s.substring(leftIndex,rightIndex+1);
        }
        return "";
    }
    public static boolean checker(HashMap<Character,Integer> ht,HashMap<Character,Integer> hs){
        for(char c : ht.keySet()){
            if(!hs.containsKey(c) || hs.get(c)<ht.get(c)){
                return false;
            }
        }
        return true;
    }

    //expensive checker - gives tle
    public boolean checker1(String t, HashMap<Character,Integer> ht,HashMap<Character,Integer> hs){
        for(int i = 0; i<t.length(); i++){
            if(!hs.containsKey(t.charAt(i)) || hs.get(t.charAt(i))<ht.get(t.charAt(i))){
                return false;
            }
        }
        return true;
    }

    //Sliding window approach without checker - incomplete
    public static String minWindow1(String s, String t) {
        HashMap<Character,Integer> ht = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
        }
        System.out.println(ht);

        HashMap<Character,Integer> hs = new HashMap<>();
        int l = 0, r = 0, m = Integer.MAX_VALUE, u = 0;
        int leftIndex = -1, rightIndex = -1;
        while(r<s.length()){
            if(ht.containsKey(s.charAt(r))){
                hs.put(s.charAt(r),hs.getOrDefault(s.charAt(r),0)+1);
                if(hs.get(s.charAt(r))==ht.get(s.charAt(r))){
                    u++;
                }
            }
            while(u==ht.size()){
                m = Math.min(r-l+1,m);
                if(r-l+1==m){
                    leftIndex = l;
                    rightIndex = r;
                }
                if(ht.containsKey(s.charAt(l))){
                    hs.put(s.charAt(l),hs.getOrDefault(s.charAt(l),0)-1);
                    if(hs.get(s.charAt(r))<ht.get(s.charAt(r))){
                        u--;
                    }
                    l++;
                    //problem point
                    while(!hs.containsKey(hs.get(s.charAt(l)))){
                        l++;
                    }
                }
            }
            System.out.println(hs);
            System.out.println(u);
            r++;
        }
        if(leftIndex!=-1 && rightIndex!=-1){
            return s.substring(leftIndex,rightIndex+1);
        }
        return "";
    }
}
