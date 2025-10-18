import java.util.HashMap;

public class Count_Vowel_Substrings {
    public static void main(String[] args) {
        String word = "cuaieuouac";
        String word1 = "aeiouubaaiiuauooea";
        System.out.println(countVowelSubstrings(word));
    }

    //Brute force
    //TC - O(N)
    //SC - O(1)
    //Time taken: 1 d 5 hrs 14 m 56 s xD
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

    //thought to make a string aeiou and then check for its occurrences, but this logic does not support
    //aaieou - i.e, repetition of vowels and random sequencing
    public static int countVowelSubstrings2(String word) {
        StringBuilder sb = new StringBuilder("aeiou");
        int l = 0, r = 0, c = 0;
        if(word.length()<5){
            return c;
        } else{
            while(r<word.length()){

            }
        }
        return c;
    }

    //longest repeating character logic - abc one
    public static int countVowelSubstrings1(String word) {
        int[] ch = new int[26];
        int l = 0, r = 0, c = 0;
        while(r<word.length()){
            ch[word.charAt(r)-'a']++;
            if(ch[0]>0 && ch[4]>0 && ch[8]>0 && ch[14]>0 && ch[20]>0){
                c++;
            }
        }
        return c;
    }
}
