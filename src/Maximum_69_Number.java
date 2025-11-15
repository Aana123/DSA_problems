public class Maximum_69_Number {
    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num));
    }
    //Optimal solution
    //TC - O(N)
    //SC - O(N)
    public static int maximum69Number (int num) {
        //The only imp parts - DECRYPTING
        char[] ch = String.valueOf(num).toCharArray();

        for(int i = 0; i<ch.length; i++){
            if(ch[i] == '6'){
                ch[i] = '9';
                break;
            }
        }
        //ENCRYPTING
        return Integer.parseInt(new String(ch));
    }
}
