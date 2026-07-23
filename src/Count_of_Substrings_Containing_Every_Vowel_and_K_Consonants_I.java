import java.util.HashMap;

public class Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_I {
    public static void main(String[] args) {

    }
    public int countOfSubstrings(String word, int k) {
        if(word.length()>=5){
            int l = 0, r = 0, c = 0;
            while(r<word.length()-1){
                r++;
            }
            return c;
        }
        return 0;
    }
    public static int countVowelSubstrings(String word) {
        HashMap<Character,Integer> hs = new HashMap<>();
        int l = 0, r = 0, u = 0,c = 0;
        while(r<word.length()){
            if(isVowel(word.charAt(r))){
                hs.put(word.charAt(r),hs.getOrDefault(word.charAt(r),0)+1);
                if(hs.get(word.charAt(r))==1){
                    u++;
                }
                while((r<word.length()-1 && !isVowel(word.charAt(r+1)) && u == 5) || (r==word.length()-1 && u == 5)){
                    hs.put(word.charAt(l),hs.getOrDefault(word.charAt(l),0)-1);
                    c++;
                    if(hs.get(word.charAt(l))==0){
                        hs.remove(word.charAt(l));
                        u--;
                    }
                    l++;
                }
                if(u==5){
                    HashMap<Character,Integer> temp = new HashMap<>();
                    temp.putAll(hs);
                    int k = l, m = u;
                    while(u == 5 && temp.get(word.charAt(l))>=1){
                        c++;
                        temp.put(word.charAt(l),temp.getOrDefault(word.charAt(l),0)-1);
                        if(temp.get(word.charAt(l))==0){
                            temp.remove(word.charAt(l));
                            u--;
                        }
                        l++;
                    }
                    l = k; u = m;
                }
                r++;
            } else{
                r++;
                l = r;
                u = 0;
                hs.clear();
            }
        }
        return c;
    }
    public static boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }
}
