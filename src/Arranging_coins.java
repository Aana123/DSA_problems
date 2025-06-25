public class Arranging_coins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(9));
    }
    //Long type
    //TC - O(logN)
    //SC - O(1)
    public static int arrangeCoins(int n) {
        long start = 1;
        long end = n;
        while(start<=end){
            long m = (start+end)/2;
            long chk = (m*(m+1))/2;
            if(chk>n) {
                end = m - 1;
            }
            else if(chk<n){
                start = m+1;
            }
            if(chk==n){
                return (int)m;
                //to convert long to int
            }
        }
        return (int)end;
    }
    //Binary Search
    //Runtime error - TLE
    public static int arrangeCoins2(int n){
        int start = 1;
        int end = n;
        while(start<=end){
            int m = (start+end)/2;
            int chk = (m*(m+1))/2;
            //chk long type
            if(chk>n) {
                end = m - 1;
            }
            else if(chk<n){
                start = m+1;
            }
            if(chk==n){
                return m;
            }
        }
        return end;
    }
    //Brute force
    //TC - O(N)
    //SC - O(1)
    public static int arrangeCoins1(int n) {
        int count = 0;
        for(int i = 1; i<=n; i++){
            if(n-i>=0){
                count++;
                n -= i;
            }
        }
        return count;
    }
}
