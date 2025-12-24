import java.util.HashMap;

public class Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(frequencySort(s));
    }

    //Brute force
    //TC - O(N^2)
    //SC - O(N)
    public static String frequencySort(String s) {
        HashMap<Character,Integer> hs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb = new StringBuilder();
        while (!hs.isEmpty()) {
            //creating temporary vars to avoid O(N^3)
            int maxFreq = 0;
            char maxF = 0;
            for (char j : hs.keySet()) {
                if(hs.get(j)>maxFreq){
                    maxFreq = hs.get(j);
                    maxF = j;
                }
            }
            for (int j = 0; j < maxFreq; j++) {
                sb.append(maxF);
            }
            hs.remove(maxF,maxFreq);
        }
        return sb.toString();
    }
}
