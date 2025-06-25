import java.util.ArrayList;
import java.util.Arrays;

public class Missing_repeated {
    public static void main(String[] args) {
        int[] array = {4, 3, 6, 5, 5, 1};
        System.out.println(findTwoElement(array));
        int[][] arr = {{1,4,3},{4,2,5},{8,7,6}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(arr)));
    }

    //1-D
    public static ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> ar = new ArrayList<>();
        int[] a = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            a[arr[i]]++;
        }
        for (int i = 1; i < a.length; i++) {
            // element with 2 frequency is repeated
            if (a[i] == 2) {
                ar.add(i);
            }
            //element with 0 frequency is missing
            if (a[i] == 0) {
                ar.add(i);
            }
        }
        return ar;
    }

    //2-D
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        //+1 ka buffer rakhe taaki next value return ho paye in case all are present
        int arr[] = new int[(grid.length * grid.length) + 1];
        for (int row[] : grid) {
            for (int col : row) {
                //frequency of element 1 at index 1 and so on
                arr[col]++;
            }
        }
        int ans[] = new int[2];
        for (int i = 1; i < arr.length; i++) {
            // element with 2 frequency is repeated
            if (arr[i] == 2) {
                ans[0] = i;
            }
            //element with 0 frequency is missing
            if (arr[i] == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }
}
