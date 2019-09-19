package tsp;

public class TSP {
    
    public static void main(String[] args) throws Exception{
    
        int indexOfFile = 0;
        String path = "D:\\10. Penelitian TSP\\2c. Data urut dari yang terkecil\\Data yang sudah disederhanakan\\12.att48.tsp.txt";
        Library.LoadCoordinateTSP(path);
        Library.PrintCoordinate();
        
        //int[] result = {0, 1, 2, 24, 23, 22, 25, 3, 4, 5, 19, 18, 17, 16, 15, 14, 20, 13, 12, 21, 11, 10, 9, 8, 7, 6};
        /*
        int[] result = Library.RandomPermutation();
        int k = 5;
        int iterasi = 5;
        Library.Print(result);
        Library.IterativeKCorrection(result, k, iterasi);
        Library.PrintResultScore();
        */
        
        path = "D:\\10. Penelitian TSP\\3. Hasil Running\\att48.txt";
        Library.LoadResult(path);
        Library.PrintResult();
        
        Pelanggan simulation = new Pelanggan();
        
        //int[] result = Library.OutsideCoordinate();
        //Library.Print(result);
        //Library.InnerCoordinate(result);
        
        //Library.DistanceBetweenPointToLine(0,0,1,1,5,4);
        //Library.AngleBetweenThreePoints(int i, int j, int k);
        
        /*
        // BELUM SELESAI, HELD KARP ALGORITHM
        int n = 3;
        int A = 0;
        int[] B = new int[n-1];
        for(int i = 1; i < n; i++) {
            B[i-1] = i;
        }
        String hasil = "" + A;
        double score = Library.HeldKarpAlgorithm(A,A,B,hasil);
        System.out.println(score);
        */
        
        /*
        Library.IterativeAlgorithm();
        Library.PrintResult();
        Library.PrintResultScore();
        Pelanggan simulation = new Pelanggan();
        
        Library.MoreIteration(2);
        Library.PrintResult();
        Library.PrintResultScore();
        */
        //Pelanggan simulation = new Pelanggan();
        //simulation.setVisible(true);
        
        /*
        Library.IterativeAlgorithm();
        Library.PrintResult();
        Library.PrintResultScore();
        Pelanggan simulation = new Pelanggan();
        */
    }
}
