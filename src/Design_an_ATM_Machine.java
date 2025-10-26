import java.util.Arrays;

public class Design_an_ATM_Machine {
    public static void main(String[] args) {
        ATM a1 = new ATM();
        int[] ans = {0,0,1,2,1};
        a1.deposit(ans);
        System.out.println(Arrays.toString(a1.withdraw(600)));
        int[] ans1 = {0,1,0,1,1};
        a1.deposit(ans1);
        System.out.println(Arrays.toString(a1.withdraw(600)));
        System.out.println(Arrays.toString(a1.withdraw(550)));
    }
}
class ATM {
    int[] atm = new int[5];
    int[] notes = {20,50,100,200,500};
    public ATM() {

    }

    public void deposit(int[] banknotesCount) {
        for(int i = 0; i<banknotesCount.length; i++){
            atm[i] += banknotesCount[i];
        }
        System.out.println(Arrays.toString(atm));
    }

    public int[] withdraw(int amount) {
        int[] safe = Arrays.copyOf(atm,5);
        int[] temp = new int[5];

        for(int i=4;i>=0;i--){
            int max = amount/notes[i];
            if(max>atm[i]) max = atm[i];

            amount -= notes[i] * max;
            atm[i] -= max;
            temp[i] += max;
        }

        if(amount==0){
            return temp;
        }else{
            atm = safe;
        }
        System.out.println(Arrays.toString(atm));
        return new int[]{-1};
    }
}
