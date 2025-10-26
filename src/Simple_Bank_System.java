public class Simple_Bank_System {
    public static void main(String[] args) {
        long[] arr = {10, 100, 20, 50, 30};
        Bank b1 = new Bank(arr);
        System.out.println(b1.withdraw(3,10));
        System.out.println(b1.transfer(5,1,30));
        System.out.println(b1.deposit(5,20));
    }
}

//Brute force approach
//repeating same conditions over and over
//will look cleaner with isValid function
//TC - O(1)
//SC - O(1)
class Bank {
    long[] bal;
    public Bank(long[] balance) {
        bal = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1>bal.length || account2>bal.length){
            return false;
        } else if(money>bal[account1-1]){
            return false;
        }
        bal[account1-1] -= money;
        bal[account2-1] += money;
        System.out.println(bal[account1-1]);
        System.out.println(bal[account2-1]);
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account>bal.length){
            return false;
        }
        bal[account-1] += money;
        System.out.println(bal[account-1]);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account>bal.length){
            return false;
        } else if(money>bal[account-1]){
            return false;
        }
        bal[account-1] -= money;
        System.out.println(bal[account-1]);
        return true;
    }
}
