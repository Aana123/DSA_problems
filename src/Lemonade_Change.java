public class Lemonade_Change {
    public static void main(String[] args) {
        int[] bills = {5,10,5,5,20,10};
        System.out.println(lemonadeChange(bills));
    }
    //Optimal solution
    //TC -O(N)
    //SC -O(1)
    public static boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0, change = 0;
        for(int i = 0; i<bills.length; i++){
            change = bills[i]-5;
            if(change>0){
                while(change>=10 && count10>0){
                    change -= 10;
                    count10--;
                }
                while(change>=5 && count5>0){
                    change -= 5;
                    count5--;
                }
                if(change!=0){
                    return false;
                }
            }
            if(bills[i]==5){
                count5++;
            } else if(bills[i]==10){
                count10++;
            }
        }
        return true;
    }
}
