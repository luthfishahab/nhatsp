// 1 untuk matrix integer, 2 untuk matrix double

package tsp;
public class MencariSkorDariSolusiTerbaikYangDiketahui {
    public static void main(String[] args) {
        int indexOfFile = 20;
        String path = "D:\\10. Penelitian TSP\\1. Program\\TSP\\" + indexOfFile + "matriks.txt";
        LibraryInt.LoadDistanceMatrix(path);
        LibraryInt.PrintDistanceMatrix();
        
        path = "D:\\10. Penelitian TSP\\2c. Data urut dari yang terkecil\\BestSolution\\" + indexOfFile + ".txt";
        SolutionInt s1 = new SolutionInt(path);
        s1.PrintSolution();
        s1.PrintDistance();
    }    
}