package tsp;

import java.util.Arrays;

public class Coba {
    public static void main(String[] args) {
        String[] namaFile = 
        {
            "0.cobauntukpresentasi.txt",
            "1.burma14.tsp.txt",
            "2.ulysses16.tsp.txt",
            "3.gr17.tsp.txt",
            "4.gr21.tsp.txt",
            "5.ulysses22.tsp.txt",
            "6.gr24.tsp.txt",
            "7.fri26.tsp.txt",
            "8.bayg29.tsp.txt",
            "9.bays29.tsp.txt",
            "10.dantzig42.tsp.txt",
            "11.swiss42.tsp.txt",
            "12.att48.tsp.txt",
            "13.gr48.tsp.txt",
            "14.hk48.tsp.txt",
            "15.eil51.tsp.txt",
            "16.berlin52.tsp.txt",
            "17.brazil58.tsp.txt",
            "18.st70.tsp.txt",
            "19.eil76.tsp.txt",
            "20.pr76.tsp.txt",
            "21.gr96.tsp.txt",
            "22.rat99.tsp.txt",
            "23.kroA100.tsp.txt",
            "24.kroB100.tsp.txt",
            "25.kroC100.tsp.txt",
            "26.kroD100.tsp.txt",
            "27.kroE100.tsp.txt",
            "28.rd100.tsp.txt",
            "29.eil101.tsp.txt",
            "30.lin105.tsp.txt",
            "31.pr107.tsp.txt",
            "32.gr120.tsp.txt",
            "33.pr124.tsp.txt",
            "34.bier127.tsp.txt",
            "35.ch130.tsp.txt",
            "36.pr136.tsp.txt",
            "37.gr137.tsp.txt",
            "38.pr144.tsp.txt",
            "39.ch150.tsp.txt",
            "40.kroA150.tsp.txt",
            "41.kroB150.tsp.txt",
            "42.pr152.tsp.txt",
            "43.u159.tsp.txt",
            "44.si175.tsp.txt",
            "45.brg180.tsp.txt",
            "46.rat195.tsp.txt",
            "47.d198.tsp.txt",
            "48.kroA200.tsp.txt",
            "49.kroB200.tsp.txt",
            "50.gr202.tsp.txt",
            "51.ts225.tsp.txt",
            "52.tsp225.tsp.txt",
            "53.pr226.tsp.txt",
            "54.gr229.tsp.txt",
            "55.gil262.tsp.txt",
            "56.pr264.tsp.txt",
            "57.a280.tsp.txt",
            "58.pr299.tsp.txt",
            "59.lin318.tsp.txt",
            "61.rd400.tsp.txt",
            "62.fl417.tsp.txt",
            "63.gr431.tsp.txt",
            "64.pr439.tsp.txt",
            "65.pcb442.tsp.txt",
            "66.d493.tsp.txt",
            "67.att532.tsp.txt",
            "68.ali535.tsp.txt",
            "69.si535.tsp.txt",
            "70.pa561.tsp.txt",
            "71.u574.tsp.txt",
            "72.rat575.tsp.txt",
            "73.p654.tsp.txt",
            "74.d657.tsp.txt",
            "75.gr666.tsp.txt",
            "76.u724.tsp.txt",
            "77.rat783.tsp.txt",
            "78.dsj1000.tsp.txt",
            "79.pr1002.tsp.txt",
            "80.si1032.tsp.txt",
            "81.u1060.tsp.txt"
        };
        
        
        
        
        //for(int index = 50; index < 80; index++) {
        int index = 1;
            String path = "D:\\2. Articles or Conference Papers\\05. LIBHATSP, A Library of Heuristic Algorithms for The Traveling Salesman Problem\\2. Data\\3. Data Full Matrix\\" + namaFile[index];
            System.out.println(path);
            LibraryInt.LoadDistanceMatrix(path);

            //int K = 100;
            int K = (int)Math.sqrt(LibraryInt.GetN())+1;
            int I = 1;
            int perulanganRunningProgram = 1;
            
            
            int min = 0;
            int jumlah = 0;
            
            long startTime = System.nanoTime();
            for(int i = 0; i < perulanganRunningProgram; i++) {
                System.out.println("\n");
                SolutionInt s1 = new SolutionInt();
                
                s1.IterativeKCorrection(K,I);
                
                if(i == 0) {
                    min = s1.GetDistance();
                }
                else {
                    if(s1.GetDistance() < min) {
                        min = s1.GetDistance();
                    }
                }
                jumlah += s1.GetDistance();
                s1.PrintSolution();
            }
            
            long totalTime = System.nanoTime() - startTime;
            System.out.println((index+1) + "\t" + min + "\t" + (jumlah/100) + "\t" + (totalTime));
            
            
            
        //}
        
        
        
        
    }    
}