import java.util.Stack;

public class Largest_rectangle_in_histogram {
    public static void main(String[] args) {
        int[] heights = {1,1,2};
        System.out.println(largestRectangleArea(heights));
    }
    //Optimal solution - Stack
    //TC - O(N)
    //SC - O(N)
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
        return ans;
    }

    //Brute force - TLE
    //TC - O(N^2)
    //SC - O(1)
    public static int largestRectangleArea1(int[] heights) {
        //Set a maximum value
        int max = -1;
        //A loop to traverse the entire array
        for (int i = 0; i < heights.length; i++) {
            //Set a minimum value
            int min = Integer.MAX_VALUE;
            //Loop to make all possible combinations
            for (int j = i; j < heights.length; j++) {
                //Update minimum value
                min = Math.min(heights[j],min);
                //Update maximum value
                max = Math.max((j-i+1)*min,max);
            }
        }
        //Return the maximum value
        return max;
    }
}
