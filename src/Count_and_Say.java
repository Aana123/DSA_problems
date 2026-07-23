public class Count_and_Say {
    public static void main(String[] args) {
        int n = 9;
        //System.out.println(rle("19"));
        System.out.println(countAndSay(n));
    }
    //Correct interpretation of the question
    //TC -O(N)
    //SC -O(N)
    public static String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String temp = countAndSay(n-1);
        return rle(temp);
    }

    //The name “Count and Say” is misleading:
    //It sounds like you’re counting numbers
    //But you’re actually describing strings

    //THIS SOLUTION DOES EXACTLY THAT!
    //IT COUNTS THE NUMBERS
    private static String ans = new String();
    public static String countAndSay1(int n) {
        if(n==1){
            return rle("1");
        }
        String temp = countAndSay1(n-1);
        ans = rle(String.valueOf(n-1))+temp;
        return ans;
    }

    //Perfect RLE Code
    //TC -O(N)
    //SC -O(N)
    public static String rle(String s){
        StringBuilder sb = new StringBuilder();
        int l = 0, r = 1;
        while(r<s.length()){
            if(s.charAt(l)!=s.charAt(r)){
                sb.append(r-l);
                sb.append(s.charAt(l));
                l = r;
            }
            r++;
        }
        sb.append(r-l);
        sb.append(s.charAt(l));
        return sb.toString();
    }
}
