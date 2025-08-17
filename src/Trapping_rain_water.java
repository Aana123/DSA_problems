import java.util.Stack;

public class Trapping_rain_water {
    public static void main(String[] args) {
        //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    //Stack approach
    //TC - O(N)
    //SC - O(N)
    public static int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int right = 0; right <n; right++){
            //when top of the stack is smaller than the current element then,
            //allot left, mid, right
            //calculate dist, minHeight and ans
            while(!st.isEmpty() && height[st.peek()]<height[right]){
                int mid = st.pop(); //smaller element
                if(st.isEmpty()){
                    break;
                }
                int left = st.peek(); //prev greater and height[right] = next greater
                int minHeight = Math.min(height[right]-height[mid],height[left]-height[mid]);
                int dist = right-left-1;
                ans += minHeight*dist;
            }
            st.push(right);
        }
        return ans;
    }

    //so many traps xD - rattrap or wot?
    //finally solution - without stack
    //Optimum solution using array
    //TC - O(n)
    //SC - O(1)
    public static int trap3(int[] height) {
        int n = height.length;

        // Compute left max array
        // lmax - max number to the left including the current element
        int[] lmax = new int[n];
        lmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }

        // Compute right max array
        // r max - max number to the right including the current element
        int[] rmax = new int[n];
        rmax[n-1] = height[n-1];
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i+1], height[i]);
        }

        // Compute trapped water
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return ans;
    }

    //Try - 2
    //no sense at all sed :(
    public static int trap2(int[] height) {
        int a = 0; int b = height.length-1;
        while(b>0){
            if(height[b]>height[b-1]){
                break;
            }
            b--;
        }
        while(a<b){
            if(height[a]>height[a+1]){
                break;
            }
            a++;
        }
        int sum = 0;
        int pro = (b-a-1)*Math.min(height[a],height[b]);
        for(int i = a+1; i<b; i++){
            pro -= height[i];
            sum = Math.abs(pro);
        }
        return sum;
    }

    //Try - 1
    //:( meme brute force but cant get it right
    public static int trap1(int[] height) {
        int a = 0; int b = height.length-1;
        while(b>0){
            if(height[b]!=0){
                break;
            }
            b--;
        }
        while(a<=b){
            if(height[a]!=0){
                break;
            }
            a++;
        }
        int[] arr = new int[b-a+1];
        int m = 0;
        for (int i = a; i <= b; i++) {
            arr[m] = height[i];
            m++;
        }
        int i = 0; int sum = 0;
        if(arr.length==1){
            return 0;
        }
        while(i<arr.length){
            int j = i+1;
            int dist = 0; int pro = 1;
            if(arr[i]>0){
                while(j<arr.length){
                    if(arr[i]<=arr[j]){
                        dist = j-i-1;
                        pro = dist*(arr[i]);
                        i++;
                        while(i<j){
                            pro -= arr[i];
                            i++;
                        }
                    }
                    j++;
                }
                sum += pro;
            }
            i++;
        }
        return sum;
    }
}
