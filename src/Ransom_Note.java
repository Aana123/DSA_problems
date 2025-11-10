public class Ransom_Note {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote,magazine));
    }
    //Optimal solution
    //TC -O(N)
    //SC -O(1)
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] ans = new int[26];
        for(int i = 0; i<magazine.length(); i++){
            ans[magazine.charAt(i)-'a']++;
        }

        for(int i = 0; i<ransomNote.length(); i++){
            if(ans[ransomNote.charAt(i)-'a']==0){
                return false;
            }
            ans[ransomNote.charAt(i)-'a']--;
        }

        return true;
    }
}
