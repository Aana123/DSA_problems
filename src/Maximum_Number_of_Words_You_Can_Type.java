import java.util.HashSet;
import java.util.Set;

public class Maximum_Number_of_Words_You_Can_Type {
    public static void main(String[] args) {
        String text = "hello world hoi";
        String brokenLetters = "ad";
        System.out.println(canBeTypedWords(text,brokenLetters));
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> st = new HashSet<>();
        for(char c : brokenLetters.toCharArray()){
            st.add(c);
        }

        int count = 0;
        String[] str = text.split(" ");
        for(String c : str){
            boolean check = true;
            for(char ch : c.toCharArray()){
                if(st.contains(ch)){
                    check = false;
                }
            }
            if(check){
                count++;
            }
        }
        return count;
    }

    //Brute force
    //TC - O(N+M)
    //SC - O(1)
    public static int canBeTypedWords1(String text, String brokenLetters) {
        char[] ch = text.toCharArray();

        Set<Character> st = new HashSet<>();
        for(char c : brokenLetters.toCharArray()){
            st.add(c);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int c = 0; c < ch.length-1; c++){
            sb.append(ch[c]);
            if(ch[c+1]==' ' || c+1==ch.length-1){
                sb.append(ch[c+1]);
                if(checker(sb.toString(),st)){
                    count++;
                }
                sb = new StringBuilder();
            }
        }
        return count;
    }
    public static boolean checker(String s, Set st){
        for(char c : s.toCharArray()){
            if(st.contains(c)){
                return false;
            }
        }
        return true;
    }
}
