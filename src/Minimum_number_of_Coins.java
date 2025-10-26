public class Minimum_number_of_Coins {
    public static void main(String[] args) {
        System.out.println(findMin(398));
    }
    //Optimal solution
    //TC - O(1)
    //SC - O(1)
    public static int findMin(int n) {
        int count = 0;
        count+= n/10;
        n -= (n/10)*10;
        count+= n/5;
        n -= (n/5)*5;
        count+= n/2;
        n -= (n/2)*2;
        count+= n;
        return count;
    }
}
