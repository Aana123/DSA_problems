public class Largest_odd_Number_in_String {
    public static void main(String[] args) {
        String s = "461";
        System.out.println(largestOddNumber(s));
    }

    //most efficient
    //TC - O(N)
    //SC - O(1)
    public static String largestOddNumber(String num) {
        for (int i = num.length()-1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0,i+1);
            }
        }
        return "";
    }

    //Least efficient
    public static String largestOddNumber2(String num) {
        int index = -1;
        for(int i = num.length()-1; i>=0; i--){
            if(num.charAt(i)%2!=0){
                index = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            sb.append(num.charAt(i));
        }
        return sb.toString();
    }

    public static String largestOddNumber1(String num) {
        StringBuilder sb = new StringBuilder(num);
        for(int i = num.length()-1; i>=0; i--){
            if(num.charAt(i)%2==0){
                sb.deleteCharAt(i);
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
