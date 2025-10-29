import java.util.Arrays;

public class N_meetings_in_one_room {
    public static void main(String[] args) {
        int start[] = {1,2};
        int end[] =  {100,99};
        System.out.println(maxMeetings(start,end));
    }
    //Optimal solution
    public static int maxMeetings(int start[], int end[]) {
        int n = start.length;
        int count = 1;
        //2d array having meeting times as start - end
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        //lambda expression to sort the 2d array in ascending order according to end times
        Arrays.sort(arr,(a, b) -> Integer.compare(a[1],b[1]));
        System.out.println(Arrays.deepToString(arr));
        int max1 = arr[0][0], max2 = arr[0][1];
        //our only answer case is when start is greater than both prev start and end
        for(int i = 1; i<n; i++){
            if(arr[i][0]>max1 && arr[i][0]>max2){
                max1 = arr[i][0];
                max2 = arr[i][1];
                count++;
            }
        }
        return count;
    }
}
