public class Add_Binary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }

    //Bit manipulation
    public static String addBinary(String a, String b) {
       StringBuilder sb = new StringBuilder();
       if(a.length()>b.length()){
           while(a.length()!=b.length()){

           }
       }else{

       }
       return "";
    }

    //TLE
    public static String addBinary1(String a, String b) {
        int ans = Integer.parseInt(a,2)+Integer.parseInt(b,2);
        System.out.println(ans);
        return Integer.toBinaryString(ans);
    }
}
