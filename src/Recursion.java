import java.util.ArrayList;

public class Recursion {
    public static void main(String[] args) {
        //reverse the digits of a number
        //System.out.println(revD(119));

        //print all subsets of a number
        //subseq("","absc");

        //print all subsequences of a string in an arraylist by passing it as an argument
        ArrayList<String> arr = new ArrayList<>();
        System.out.println(subseq1("","abc",arr));

        //print all subsequences of a string in an arraylist by passing it as an argument
        ArrayList<String> array = new ArrayList<>();
        System.out.println(subseq1("","123",array));

        //perm("","123");

        ArrayList<String> arl = new ArrayList<>();
        System.out.println(perm1("","123",arl));
    }
    static int sum = 0;
    public static int revD(int n){
        if(n==0) return 0;
        sum = sum*10+(n%10);
        revD(n/10);
        return sum;
    }
    public static void subseq(String p, String up){
        //bc
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }

    public static ArrayList<String> subseq1(String p, String up, ArrayList<String> arr){
        //bc
        if(up.isEmpty()){
            arr.add(p);
            return arr; //ek subset ko add
        }

        char ch = up.charAt(0);
        subseq1(p+ch,up.substring(1),arr);
        subseq1(p,up.substring(1),arr);
        return arr; //take and leave actions pr subsets bane
    }

    public static ArrayList<String> subseq2(String p, String up, ArrayList<String> arr){
        //bc
        if(up.isEmpty()){
            arr.add(p);
            return arr; //take par bane then leave pr bane
        }

        char ch = up.charAt(0);
        subseq1(p+ch,up.substring(1),arr);
        subseq1(p,up.substring(1),arr);
        return arr; //take and leave actions pr subsets bane
    }

    public static void perm(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            perm(f+ch+s,up.substring(1));
        }
    }

    public static ArrayList<String> perm1(String p, String up,ArrayList<String> arr){
        if(up.isEmpty()){
            arr.add(p);
            return arr;
        }

        char ch = up.charAt(0);
        //the no. of positions on which an item can be put is determined by the size of the processed string
        //ex - p="ab", c can be put at three positions, i.e - size(p)+1
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            perm1(f+ch+s,up.substring(1),arr);
        }
        return arr;
    }
}
