import java.util.Arrays;
import java.util.Stack;

public class Maximal_rectangle {
    public static void main(String[] args) {
        char [][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    //Kinda brute force only as the number of iterations can easily be reduced
    //TC - O(M∗N)
    //SC - O(M∗N)
    public static int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        //Step - 1 Make a 2-D top matrix - it stores the indexes of the top smaller element xD ykr
        int[][] top = new int[r][c];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                while(!st.isEmpty() && matrix[st.peek()][i]>=matrix[j][i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    top[j][i] = -1;
                } else{
                    top[j][i] = st.peek();
                }
                st.push(j);
            }
            st.clear();
        }
        System.out.println(Arrays.deepToString(top));
        //Step - 2 Make heights array row-wise and store max area values simultaneously
        int max = 0;
        for (int i = 0; i < r; i++) {
            int[] heights = new int[c];
            for (int j = 0; j < c; j++) {
                if(matrix[i][j]=='0'){
                    heights[j] = 0;
                } else{
                    heights[j] = i-top[i][j];
                }
            }
            System.out.println(Arrays.toString(heights));
            //Step - 3 find out the max area
            max = Math.max(largestRectangleArea(heights),max);
        }

        return max;
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n]; //prev smaller
        int[] right = new int[n]; //next smaller

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            //>=
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = -1;
            } else{
                left[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for (int i = n-1; i >=0; i--) {
            //>=
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n;
            } else{
                right[i] = st.peek();
            }
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            //magic formula line xD
            ans = Math.max((right[i]-left[i]-1)*heights[i],ans);
        }
        System.out.println(ans);
        return ans;
    }
}
