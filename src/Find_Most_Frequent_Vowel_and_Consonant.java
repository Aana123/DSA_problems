import java.util.HashMap;

public class Find_Most_Frequent_Vowel_and_Consonant {
    public static void main(String[] args) {
        String s = "successes";
        System.out.println(maxFreqSum(s));
    }

    //Brute force
    //TC - O(N)
    //SC - O(1)
    public static int maxFreqSum(String s) {
        HashMap<Character,Integer> v = new HashMap<>();
        HashMap<Character,Integer> c = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(ch =='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u'){
                v.put(ch, v.getOrDefault(ch,0)+1);
            } else{
                c.put(ch, c.getOrDefault(ch,0)+1);
            }
        }

        int maxc = 0; int maxv = 0;
        for(char ch : s.toCharArray()){
            if(ch =='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u'){
                maxv = Math.max(v.get(ch),maxv);
            } else{
                maxc = Math.max(c.get(ch),maxc);
            }
        }

        return maxc+maxv;
    }
}
