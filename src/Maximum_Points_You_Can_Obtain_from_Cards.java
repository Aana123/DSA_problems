public class Maximum_Points_You_Can_Obtain_from_Cards {
    public static void main(String[] args) {
        int[] cardPoints = {4,2,1,3,3};
        int k = 5;
        System.out.println(maxScore(cardPoints,k));
    }
    //Minimising the windowSum of n-k sized window
    //TC - O(N)
    //SC - O(1)
    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0, windowSum = 0, p = 0;
        for(int i = 0; i<cardPoints.length; i++){
            sum +=  cardPoints[i];
        }
        if(cardPoints.length-k==0){
            return sum;
        }
        int l = 0, r = 0, ans = 0;
        while(r<cardPoints.length){
            windowSum += cardPoints[r];
            p++;
            if(p==cardPoints.length-k){
                System.out.println(sum-windowSum);
                ans = Math.max(ans,sum-windowSum);
                windowSum -= cardPoints[l];
                l++; p--;
            }
            r++;
        }
        return ans;
    }

    //Incomplete Brute force
    public static int maxScore1(int[] cardPoints, int k) {
        int l = 0, r = cardPoints.length-1, s = 0;
        while(l<r && k>0){
            if(cardPoints[l]>=cardPoints[r]){
                s += cardPoints[l];
                cardPoints[l] = 0;
                l++; r--;
            } else{
                s += cardPoints[r];
                cardPoints[r] = 0;
                r--; l++;
            }
            k--;
        }
        if(k>0){
            for(int i = 0; i<cardPoints.length; i++){
                if(cardPoints[i]!=0){
                    l = i;
                    break;
                }
            }
            for(int i = cardPoints.length-1; i>=0; i--){
                if(cardPoints[i]!=0){
                    r = i;
                    break;
                }
            }
        }
        while(k>0){
            while(cardPoints[l]==0){
                l++;
            }
            while(cardPoints[r]==0){
                r--;
            }
            if(cardPoints[l]>=cardPoints[r]){
                s += cardPoints[l];
                cardPoints[l] = 0;
                l++; r--;
            } else{
                s += cardPoints[r];
                cardPoints[r] = 0;
                r--; l++;
            }
            k--;
        }
        return s;
    }
}
