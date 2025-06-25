public class can_place_flowers {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(canPlaceFlowers(arr,1));
    }

    //Brute force
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //only zero in one sized array
        if(flowerbed.length==1 && n==1 && flowerbed[0]==0){
            return true;
        }
        int i = 0;
        while(n>0 && i<flowerbed.length){
            if(flowerbed[i]==0){
                //beech me zero - aage peeche chk
                if(i>0 && i< flowerbed.length-1 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    flowerbed[i] = 1;
                    n--;
                }
                //starting me zero - aage chk
                else if(i==0 && i<flowerbed.length-1 && flowerbed[i+1]==0){
                    flowerbed[i] = 1;
                    n--;
                }
                //end corner zero - peeche chk
                else if(i==flowerbed.length-1 && i>0 && flowerbed[i-1]==0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
            i++;
        }
        if(n==0) return true;
        return false;
    }
}
