public class Calculate_Money_in_Leetcode_Bank {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(totalMoney(n));
    }
    //Optimal solution
    //TC - O(N)
    //SC - O(1)
    public static int totalMoney(int n) {
        int week = n/7, value = n, ans = 0;
        for(int i = 0; i<=week; i++){
            if(value>7){
                value = 7;
            }
            ans += ((value*(value+1))/2)+(i*value);
            value = n-((i+1)*7);
        }
        return ans;
    }
}
