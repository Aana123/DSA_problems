import java.util.Arrays;

public class Right_interval {
    public static void main(String[] args) {
        int[][] intervals = {{3,3},{2,3},{1,2}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }

    //Brute force
    public static int[] findRightInterval(int[][] intervals) {
        //Final answer array
        int[] ans = new int[intervals.length];
        //Step array to store the start of each interval
        int[] step = new int[intervals.length];
        //Pointer to fill the elements in step array
        for (int i =  0; i < intervals.length; i++){
            step[i] = intervals[i][0];
            ans[i] = -1;
        }
        //To find the right interval and insert it in answer array
        int l = 0;
        for (int i = 0; i < intervals.length; i++) {
            int chk = intervals[i][1];
            int current = Integer.MAX_VALUE;
            for (int p = 0; p < step.length; p++) {
                if (step[p] >= chk) {
                    current = Math.min(step[p], current);
                }
            }

            for (int k = 0; k < step.length; k++) {
                if(step[k]==current){
                    ans[l] = k;
                    l++;
                    break;
                } else if(current==Integer.MAX_VALUE){
                    l++;
                    break;
                }
            }
            System.out.println(Arrays.toString(ans));
        }
        return ans;
    }
}
