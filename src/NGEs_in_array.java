import java.util.Arrays;
import java.util.Stack;

public class NGEs_in_array {
    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 7, 5, 8, 10, 6};
        int queries = 2;
        int indices[] = {0, 5};
        System.out.println(Arrays.toString(count_NGEs(arr.length,arr,queries,indices)));
    }
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]){
        int ans[] = new int[queries];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < queries; i++) {
            int count = 0;
            for (int j = indices[i]+1; j < N; j++) {
                while(!st.isEmpty() && arr[j]<st.peek()){
                    st.pop();
                    count++;
                }
                st.push(arr[j]);
            }
            ans[i] = count;
        }
        return ans;
    }

    //Brute force
    public static int[] count_NGEs1(int N, int arr[], int queries, int indices[]) {
        int ans[] = new int[queries];
        for(int i = 0; i<queries; i++){
            int count = 0;
            for (int j = indices[i]+1; j < N; j++) {
                if(arr[j]>arr[indices[i]]){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
