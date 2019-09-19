package tsp;

import java.util.Arrays;

public class SolutionInt {
    private int[] solution;
    private int distance;
    
    // membuat solusi acak
    public SolutionInt() {
        int n = LibraryInt.GetN();
        
        int int1[] = new int[n];
        for(int i = 0; i < n; i++){
            int1[i] = i;
        }
        
        //generate random permutation
        solution = new int[n];
        for(int i = 0; i < n; i++){
            int j = (int)(Math.random()*(n-i));
            solution[i] = int1[j];
            int1[j] = int1[n-i-1];
        }
        
        distance = LibraryInt.CountDistance(solution);
    }
    
    public SolutionInt(int[] a) {
        solution = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            solution[i] = a[i];
        }
        distance = LibraryInt.CountDistance(solution);
    }
    
    public SolutionInt(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            solution = new int[LibraryInt.GetN()];
            for(int i = 0; i < solution.length; i++) {
                solution[i] = input.nextInt() - 1;
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
        
        distance = LibraryInt.CountDistance(solution);
    }
    
    public void PrintSolution() {
        for(int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
        System.out.println("");
    }
    
    public void PrintDistance() {
        System.out.println(distance);
    }
    
    public int GetDistance() {
        return distance;
    }
    
    public void IterativeKCorrection(int K, int I) {
        int n = solution.length;
        
        int[] A = Library.Sort(solution);
        
                //Library.Print(A);
                //System.out.println("");
        int scoreA = distance;
        
        // menyimpan n-K titik
        int[] allMinKPoint = {};
        
        Library.PrintPlusOne(A);
        System.out.println(scoreA);
        
        for(int iterasi = 0; iterasi < I; iterasi++) {
            
            
            
            // membentuk A baru dengan Shahab algorithm
            for(int i = 0; i < n; i++) {
                int[] kPoint = new int[K];
                for(int j = 0; j < K; j++) {
                    kPoint[j] = A[(i+j)%n];
                }
                
                Library.PrintPlusOne(kPoint);//
                
                allMinKPoint = new int[n - K];
                for(int j = K; j < n; j++) {
                    allMinKPoint[j-K] = A[(i+j)%n];
                }
                
                int[] permutation = LibraryInt.RandomPermutation(K);
                
                int[] dummyForKPoint = new int[K];
                for(int j = 0; j < K; j++) {
                    dummyForKPoint[j] = kPoint[j];
                }
                for(int j = 0; j < K; j++) {
                    kPoint[j] = dummyForKPoint[permutation[j]];
                }
                
                Library.PrintPlusOne(kPoint);//
                
                Library.PrintPlusOne(allMinKPoint);//
                
                int scoreOfAllMinKPoint = LibraryInt.CountDistance(allMinKPoint);
                for(int ii = 0; ii < K; ii++) {
                    int best = 1;
                    int j = 1;
                    int min = scoreOfAllMinKPoint 
                            - LibraryInt.d[allMinKPoint[j-1]][allMinKPoint[j]]
                            + LibraryInt.d[allMinKPoint[j-1]][kPoint[ii]]
                            + LibraryInt.d[kPoint[ii]][allMinKPoint[j]];
                    
                    for(j = 2; j < allMinKPoint.length; j++) {
                        int score = 0;
                        
                        score = scoreOfAllMinKPoint 
                            - LibraryInt.d[allMinKPoint[j-1]][allMinKPoint[j]]
                            + LibraryInt.d[allMinKPoint[j-1]][kPoint[ii]]
                            + LibraryInt.d[kPoint[ii]][allMinKPoint[j]];
                        
                        if(min > score) {
                            min = score;
                            best = j;
                        }
                    }
                    
                    j = allMinKPoint.length;
                    int score = scoreOfAllMinKPoint 
                            - LibraryInt.d[allMinKPoint[j-1]][allMinKPoint[0]]
                            + LibraryInt.d[allMinKPoint[j-1]][kPoint[ii]]
                            + LibraryInt.d[kPoint[ii]][allMinKPoint[0]];
                    if(min > score) {
                        min = score;
                        best = j;
                    }
                    
                    allMinKPoint = Library.Add(allMinKPoint, kPoint[ii], best);
                    scoreOfAllMinKPoint = min;
                }
                int scoreAkhir = scoreOfAllMinKPoint;
                //Library.Print(allMinKPoint);
                if(scoreAkhir < scoreA) {
                    A = Library.Sort(allMinKPoint);
                    //A = allMinKPoint;
                    scoreA = scoreOfAllMinKPoint;
                }
                Library.PrintPlusOne(A);
                System.out.println(scoreA);
            }
            
            System.out.println(scoreA);
            
        }
        
        for(int i = 0; i < n; i++) {
            solution[i] = A[i];
        }
        distance = scoreA;
    }
}