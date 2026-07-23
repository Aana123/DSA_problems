import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Job_Sequencing_Problem {
    public static void main(String[] args) {
        int deadline[] = {11, 2, 5, 8, 11, 10, 1, 6, 3, 8, 10};
        int profit[] = {321, 62, 456, 394, 424, 22, 393, 87, 118, 384, 83};
        System.out.println(jobSequencing(deadline,profit));
    }
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        ArrayList<Integer> ls = new ArrayList<>();
        int n = deadline.length, slots = 0;
        int jobs = 0, pro = 0;
        int[][] ans = new int[n][2];
        HashMap<Integer,Integer> hs = new HashMap<>();

        for(int i = 0; i<n; i++){
            ans[i][0] = profit[i];
            ans[i][1] = deadline[i];
            //the biggest deadline number gives the number of timeslots available
            slots = Math.max(slots,deadline[i]);
            hs.put(ans[i][1],0);
        }

        Arrays.sort(ans, (a,b) -> Integer.compare(b[0],a[0]));
        System.out.println(Arrays.deepToString(ans));

        for(int i = 0; i<n; i++){
            int j = ans[i][1];
            while(j>0){
                if(hs.get(j)==0){
                    hs.put(j,1);
                    jobs++;
                    pro += ans[i][0];
                    break;
                }
                j--;
            }
            System.out.println(hs);
        }
        ls.add(jobs);
        ls.add(pro);
        return ls;
    }
}
