public class Koko_Eating_Bananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        System.out.println(minEatingSpeed(piles,5));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = max(piles);
        while(start<=end){
            int mid = (start+end)/2;
            if(helper(piles,mid,h)>=0){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    public static int max(int[] arr){
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            ans = Math.max(ans,arr[i]);
        }
        return ans;
    }
    public static int helper(int[] piles, int p, int h){
        for (int i = 0; i < piles.length; i++) {
            if(piles[i]>p){
                if(piles[i]%p==0){
                    h -= piles[i]/p;
                }else{
                    h -= (piles[i]/p)+1;
                }
            }else if(piles[i]<=p){
                h--;
            }
        }
        return h;
    }


    //approach -1 wrogn T-T
    public static int helper1(int[] piles, int p, int h){
        int[] arr = new int[piles.length];
        for(int i = 0; i<arr.length; i++){
            arr[i] = piles[i];
        }
        for (int i = 0; i < piles.length-1; i++) {
            if(piles[i]>p){
                piles[i+1] += piles[i]-p;
            }
            h--;
        }
        if(piles[piles.length-1]>p){
            while(piles[piles.length-1]>p){
                piles[piles.length-1] -= p;
                h--;
            }
            if(piles[piles.length-1]<=p){
                h--;
            }
        }
        for(int i = 0; i<arr.length; i++){
            piles[i] = arr[i];
        }
        return h;
    }
}
