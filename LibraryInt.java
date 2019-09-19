package tsp;

public class LibraryInt {
    public static int n; //numberOfCities
    public static int[][] d; //distance
    
    public static int GetN() {
        return n;
    }
    
    public static void LoadDistanceMatrix(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            n = input.nextInt();
            d = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    d[i][j] = input.nextInt();
                }
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void PrintDistanceMatrix() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(d[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static int CountDistance(int[] a) {
        int n = a.length;
        int result = d[a[0]][a[n-1]];
        for(int i = 1; i < n; i++) {
            result += d[a[i]][a[i-1]];
        }
        
        return result;
    }
    
    public static int[] RandomPermutation(int n) {
        int int1[] = new int[n];
        for(int i = 0; i < n; i++){
            int1[i] = i;
        }
        
        //generate random permutation
        int permutation[] = new int[n];
        for(int i = 0; i < n; i++){
            int j = (int)(Math.random()*(n-i));
            permutation[i] = int1[j];
            int1[j] = int1[n-i-1];
        }
        
        return permutation;
    }
}