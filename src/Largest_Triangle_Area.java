public class Largest_Triangle_Area {
    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));
    }
    public static double largestTriangleArea(int[][] points) {
        return -1;
    }
    public static boolean isPossible(int i, int j, int k){
        if(i+j>k && j+k>i && i+k>j){
            return true;
        }
        return false;
    }
}
