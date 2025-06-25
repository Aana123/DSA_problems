public class Highest_altitude {
    public static void main(String[] args) {
        //int[] gain = {28,0,-8,-99,11,62,-35,68,2,12,-71,13,66,-28};
        //int[] gain = {-4,-3,-2,-1,4,3,2};
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }
    public static int largestAltitude(int[] gain) {
        int ans = 0;
        int chk = gain[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < gain.length-1; i++) {
            int in = Math.max(ans,chk);
            max = Math.max(max,in);
            ans = chk;
            chk = gain[i+1]-Math.abs(ans);
        }
        return max;
    }
}
