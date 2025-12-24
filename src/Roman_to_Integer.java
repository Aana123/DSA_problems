import java.util.HashMap;

public class Roman_to_Integer {
    public static void main(String[] args) {
        String s = "CMXCIX";
        System.out.println(romanToInt(s));
    }

    //Good practice
    private static int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    //Forward pass
    //TC - O(N)
    //SC - O(N)
    //more efficient to access elements through an array - speed factor
    public static int romanToInt(String s) {
        int n = s.length();
        int ans = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if(i+1<n && getValue(ch[i])<getValue(ch[i+1])){
                ans -= getValue(ch[i]);
            } else{
                ans += getValue(ch[i]);
            }
        }
        return ans;
    }

    //Backward pass
    //TC - O(N)
    //SC - O(1)
    public static int romanToInt2(String s) {
        int n = s.length();
        int ans = getValue(s.charAt(n-1));
        for (int i = n-1; i > 0; i--) {
            if(getValue(s.charAt(i))<=getValue(s.charAt(i-1))){
                ans += getValue(s.charAt(i-1));
            } else{
                ans -= getValue(s.charAt(i-1));
            }
        }
        return ans;
    }

    //Standard solution
    //TC - O(N)
    //SC - O(1)
    public static int romanToInt1(String s) {
        HashMap<Character,Integer> val = new HashMap<>(7);
        val.put('I',1);
        val.put('X',10);
        val.put('V',5);
        val.put('L',50);
        val.put('C',100);
        val.put('D',500);
        val.put('M',1000);

        int cur = val.get(s.charAt(s.length()-1));
        for (int i = s.length()-1; i > 0; i--) {
            if(val.get(s.charAt(i))<=val.get(s.charAt(i-1))){
                cur += val.get(s.charAt(i-1));
            }else{
                cur -= val.get(s.charAt(i-1));
            }
        }

        return cur;
    }
}
