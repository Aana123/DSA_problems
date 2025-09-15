import java.util.*;

public class Sort_Vowels_in_a_String {
    public static void main(String[] args) {
        String str = "leEtcOdE";
        System.out.println(sortVowels(str));
    }

    //Optimal solution
    //TC - O(n + m log m)
    //Extracting vowels → O(n)
    //Sorting vowels → O(m log m),  m - number of vowels.
    //Rebuilding string → O(n)
    //SC - O(n)
    public static String sortVowels(String s) {
        ArrayList<Character> vowels = new ArrayList<>();

        for (char i : s.toCharArray()) {
            if(isVowel(i)){
                vowels.add(i);
            }
        }
        Collections.sort(vowels);

        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append(vowels.get(j++));
            }
            else {
                sb.append(c);
            }
        }
        return new String(sb);
    }

    //Brute force
    //TC - O(N*LOG(N))
    //SC - O(N)
    public static String sortVowels1(String s) {
        //Convert string to char array
        char[] arr = s.toCharArray();
        ArrayList<Character> vowels = new ArrayList<>();

        //storing all the vowels in an arraylist
        for (int i = 0; i < arr.length; i++) {
            if(isVowel(arr[i])){
                vowels.add(arr[i]);
            }
        }
        System.out.println(vowels);

        //sorting the ascii values of vowels in array
        char[] ascii = new char[vowels.size()];
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = vowels.get(i);
        }
        Arrays.sort(ascii);
        System.out.println(Arrays.toString(ascii));

        //putting the sorted vowels in original char array
        int j = 0;
        for (int i = 0; i < arr.length; i++){
            if(isVowel(arr[i])){
                arr[i] = (char) ascii[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return new String(arr);
    }
    public static boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
            return true;
        }
        return false;
    }
}
