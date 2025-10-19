import java.util.HashSet;

public class Longest_Substring_Of_All_Vowels_in_Order {
    public static void main(String[] args) {
        String word = "aeiouuuuaeu"; // case that catches the mistake in r++ in max count condition
        System.out.println(longestBeautifulSubstring(word));
    }

    //Brute force - sliding window
    //TC - O(N)
    //SC - O(1)
    public static int longestBeautifulSubstring(String word) {
        char[] ch = word.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        int l = 0, r = 0, m = 0;
        char lastChar = ' ';
        while(r<word.length()){
            //r++ condition
            if(hs.isEmpty() && ch[r]=='a'){
                hs.add(ch[r]);
                lastChar = ch[r];
                r++;
            } else if(lastChar=='a' && ch[r]=='e'){
                hs.add(ch[r]);
                lastChar = ch[r];
                r++;
            } else if(lastChar=='e' && ch[r]=='i'){
                hs.add(ch[r]);
                lastChar = ch[r];
                r++;
            } else if(lastChar=='i' && ch[r]=='o'){
                hs.add(ch[r]);
                lastChar = ch[r];
                r++;
            } else if(lastChar=='o' && ch[r]=='u'){
                hs.add(ch[r]);
                lastChar = ch[r];
                r++;
            } else if(lastChar==ch[r]){
                r++;
            } else if(hs.isEmpty() && ch[r]!='a'){
                r++; l++;
            }
            //l ko move karne ki condition
            else{
                hs.clear();
                lastChar = ' ';
                l = r;
            }
            //max size calculate when all vowels are found in order
            if(hs.size()==5){
                m = Math.max(r-l,m);
            }
        }
        return m;
    }
}
