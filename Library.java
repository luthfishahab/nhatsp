package tsp;

import java.util.Arrays;

public class Library {
    private static int[][] coordinate;
    private static int[] result;
    
    public static int FarthestCoordinate() {
        double[] distance = new double[coordinate.length];
        for(int i = 0; i < coordinate.length; i++) {
            distance[i] = 0;
            for(int j = 0; j < coordinate.length; j++) {
                distance[i] += Distance(i,j);
            }
        }
        double max = distance[0];
        int index = 0;
        for(int i = 1; i < coordinate.length; i++) {
            if(max < distance[i]) {
                max = distance[i];
                index = i;
            }
        }
        return index;
    }
    
    public static int FarthestCoordinate(int a, int[] b) {
        double[] distance = new double[b.length];
        for(int i = 0; i < b.length; i++) {
            distance[i] = Distance(b[i],a);
        }
        double max = distance[0];
        int index = 0;
        for(int i = 1; i < distance.length; i++) {
            if(max < distance[i]) {
                max = distance[i];
                index = i;
            }
        }
        return b[index];
    }
    
    public static int FarthestCoordinate(int[] a) {
        double[] distance = new double[a.length];
        for(int i = 0; i < a.length; i++) {
            distance[i] = 0;
            for(int j = 0; j < a.length; j++) {
                distance[i] += Distance(a[i],a[j]);
            }
        }
        double max = distance[0];
        int index = 0;
        for(int i = 1; i < distance.length; i++) {
            if(max < distance[i]) {
                max = distance[i];
                index = i;
            }
        }
        return a[index];
    }
    
    public static int FarthestCoordinate(int[] a, int[] b, int k) {
        double[] distance = new double[b.length];
        for(int i = 0; i < b.length; i++) {
            distance[i] = 0;
            for(int j = 0; j < k; j++) {
                distance[i] += Distance(b[i],a[j]);
            }
        }
        double max = distance[0];
        int index = 0;
        for(int i = 1; i < distance.length; i++) {
            if(max < distance[i]) {
                max = distance[i];
                index = i;
            }
        }
        return b[index];
    }
    
    public static int[][] GetCoordinate() {
        return coordinate;
    }
    
    public static double GetKemiringan(int x2, int y2, int x1, int y1) {
        double pi = 57.2957795131;
        double b = Math.atan((double)(y2 - y1) / (double)(x2 - x1)) * pi;
        if(y2 >= y1 && x2 >= x1) {
            
        }
        else if(y2 >= y1 && x2 < x1) {
            b += 180;
        }
        else if(y2 < y1 && x2 < x1) {
            b += 180;
        }
        else {
            b += 360;
        }
        return b;
    }
    
    public static int[] GetResult() {
        return result;
    }
    
    public static double HeldKarpAlgorithm(int a0, int a, int[] b, String hasil) {
        if(b.length == 0) {
            int c = a0;
            int d = a;
            double result = Math.sqrt(Math.pow(coordinate[d][0] - coordinate[c][0], 2) + Math.pow(coordinate[d][1] - coordinate[c][1], 2));
            //System.out.println(a);
            return result;
        }
        else {
            double[] c = new double[b.length];
            int d = a;
            for(int i = 0; i < b.length; i++) {
                int e = b[i];
                c[i] = Math.sqrt(Math.pow(coordinate[d][0] - coordinate[e][0], 2) + Math.pow(coordinate[d][1] - coordinate[e][1], 2));
                int f = b[i];
                int[] g = new int[b.length - 1];
                int index = 0;
                for(int j = 0; j < b.length; j++) {
                    if(j != i) {
                        g[index] = b[j];
                        index++;
                    }
                }
                c[i] += HeldKarpAlgorithm(a0, f, g, hasil + e);
            }
            
            System.out.println(b[IndexOfMin(c)]);
            return Min(c);
        }
    }
    
    public static int IndexOfMin(double[] a) {
        int index = 0;
        double min = a[0];
        for(int i = 1; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
                index = i;
            }
        }
        return index;
    }
    
    public static int IndexOfMax(double[] a) {
        int index = 0;
        double max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(max < a[i]) {
                max = a[i];
                index = i;
            }
        }
        return index;
    }
    
    public static void InnerCoordinate(int[] outer) {
        int n = coordinate.length;
        
        //Iterasi Pertama
        //Titik-titik yang tidak termasuk dalam outer
        int[] inner = new int[n - outer.length];
        int[] sortedOuter = outer;
        for(int uji = 0; uji < 1; uji++) {
            Arrays.sort(sortedOuter);
            Print(sortedOuter);
        }
        
        
        
    }
    
    public static double Min(double[] a) {
        double min = a[0];
        for(int i = 1; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }
    
    public static int[] OrderedPermutation() {
        int n = coordinate.length;
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = i;
        }
        
        return a;
    }
    
    public static int[] OtherCoordinate(int[] permutation, int[] other, int k) {
        int[] other2 = new int[other.length - 1];
        int index = 0;
        for(int i = 0; i < other.length; i++) {
            if(other[i] != permutation[k-1]) {
                other2[index] = other[i];
                index++;
            }
        }
        return other2;
    }
    
    public static int[] OutsideCoordinate() {
        //dimulai dengan mencari koordinat yang total jaraknya dengan kordinat yang lain adalah terbesar
        int a = FarthestCoordinate();
        //mencari kemiringan dari titik a dengan titik2 yang lain
        int n = coordinate.length;
        int index = 0;
        //variabel m menyimpan kemiringan antara a dengan titik yang lain
        double[] m = new double[n-1];
        int[] indexOfM = new int[n-1];
        
        //titik yang belum digabungkan
        int[] titikTersisa = new int[n];
        for(int i = 0; i < n; i++) {
            titikTersisa[i] = i;
        }
        titikTersisa = Remove(titikTersisa, a);
        
        //mencari kemiringan
        for(int i : titikTersisa) {
                m[index] = GetKemiringan(coordinate[i][0],coordinate[i][1],coordinate[a][0],coordinate[a][1]);
                indexOfM[index++] = i;
        }
        //PrintWithIndex(indexOfM,m);
        //mengurutkan kemiringan dari yang terkecil
        SortWithIndex(indexOfM,m);
        //PrintWithIndex(indexOfM,m);
        
        //menghitung selisih kemiringan
        double[] selisihKemiringan = new double[n-1];
        for(int i = 0; i < n-2; i++) {
            selisihKemiringan[i] = m[i+1] - m[i];
        }
        selisihKemiringan[n-2] = m[0] - m[n-2] + 360;
        
        //PrintKeBawah(selisihKemiringan);
        
        //mencari index dari M yang selisih kemiringan dengan sebelumnya adalah terbesar
        int end = IndexOfMax(selisihKemiringan)%(n-1);
        end = indexOfM[end];
        //System.out.println("end : " +end);
        
        int b = (IndexOfMax(selisihKemiringan) + 1)%(n-1);
        //System.out.println(indexOfM[b]);
        
        int[] result = {a,indexOfM[b]};
        //Print(result);
        
        
        
        for(int ii = 2; ii < n; ii++) {
            a = indexOfM[b];
            titikTersisa = RemoveBInArrayA(titikTersisa, indexOfM[b]);
            m = new double[n-ii];
            index = 0;
            for(int i : titikTersisa) {
                    m[index] = GetKemiringan(coordinate[i][0],coordinate[i][1],coordinate[a][0],coordinate[a][1]);
                    indexOfM[index++] = i;
            }
            SortWithIndex(indexOfM,m);
            selisihKemiringan = new double[n-ii];
            for(int i = 0; i < n-ii-1; i++) {
                selisihKemiringan[i] = m[i+1] - m[i];
            }
            selisihKemiringan[n-ii-1] = m[0] - m[n-ii-1] + 360;
            b = (IndexOfMax(selisihKemiringan) + 1)%(n-ii);
            //System.out.println(indexOfM[b]);
            result = Add(result, indexOfM[b]);
            if(indexOfM[b] == end) {
                break;
            }
        }
        
        //Print(result);
        /*
        System.out.println("\n\n\n\n\n\nProses Kedua");
        int ii = 2;
        a = index2[b];
        titikTersisa = RemoveBInArrayA(titikTersisa, index2[b]);
        //Print(titikTersisa);
        m = new double[n-ii];
        index = 0;
        for(int i : titikTersisa) {
                m[index] = GetKemiringan(coordinate[i][0],coordinate[i][1],coordinate[a][0],coordinate[a][1]);
                index2[index++] = i;
        }
        //PrintWithIndex(index2,m);
        SortWithIndex(index2,m);
        //PrintWithIndex(index2,m);
        selisihKemiringan = new double[n-ii];
        for(int i = 0; i < n-3; i++) {
            selisihKemiringan[i] = m[i+1] - m[i];
        }
        selisihKemiringan[n-ii-1] = m[0] - m[n-ii-1] + 360;
        //PrintKeBawah(selisihKemiringan);
        b = (IndexOfMax(selisihKemiringan) + 1)%(n-ii);
        System.out.println(index2[b]);
        
        System.out.println("Proses Ketiga");
        ii++;
        a = index2[b];
        titikTersisa = RemoveBInArrayA(titikTersisa, index2[b]);
        m = new double[n-ii];
        index = 0;
        for(int i : titikTersisa) {
                m[index] = GetKemiringan(coordinate[i][0],coordinate[i][1],coordinate[a][0],coordinate[a][1]);
                index2[index++] = i;
        }
        SortWithIndex(index2,m);
        selisihKemiringan = new double[n-ii];
        for(int i = 0; i < n-ii-1; i++) {
            selisihKemiringan[i] = m[i+1] - m[i];
        }
        selisihKemiringan[n-ii-1] = m[0] - m[n-ii-1] + 360;
        b = (IndexOfMax(selisihKemiringan) + 1)%(n-ii);
        System.out.println(index2[b]);
        
        System.out.println("Proses Ketiga");
        ii++;
        a = index2[b];
        titikTersisa = RemoveBInArrayA(titikTersisa, index2[b]);
        m = new double[n-ii];
        index = 0;
        for(int i : titikTersisa) {
                m[index] = GetKemiringan(coordinate[i][0],coordinate[i][1],coordinate[a][0],coordinate[a][1]);
                index2[index++] = i;
        }
        SortWithIndex(index2,m);
        selisihKemiringan = new double[n-ii];
        for(int i = 0; i < n-ii-1; i++) {
            selisihKemiringan[i] = m[i+1] - m[i];
        }
        selisihKemiringan[n-ii-1] = m[0] - m[n-ii-1] + 360;
        b = (IndexOfMax(selisihKemiringan) + 1)%(n-ii);
        System.out.println(index2[b]);
        */
        return result;
    }
    
    public static int[] RandomPermutation(int n) {
        int numberOfCoordinate = n;
        
        int int1[] = OrderedPermutation();
        
        //generate random permutation
        int permutation[] = new int[numberOfCoordinate];
        for(int i = 0; i < numberOfCoordinate; i++){
            int j = (int)(Math.random()*(numberOfCoordinate-i));
            permutation[i] = int1[j];
            int1[j] = int1[numberOfCoordinate-i-1];
        }
        
        return permutation;
    }
    
    public static int[] RandomPermutation() {
        int numberOfCoordinate = coordinate.length;
        
        int int1[] = OrderedPermutation();
        
        //generate random permutation
        int permutation[] = new int[numberOfCoordinate];
        for(int i = 0; i < numberOfCoordinate; i++){
            int j = (int)(Math.random()*(numberOfCoordinate-i));
            permutation[i] = int1[j];
            int1[j] = int1[numberOfCoordinate-i-1];
        }
        
        return permutation;
    }
    
    public static double[] MeanOfCoordinate() {
        double sumX = 0;
        double sumY = 0;
        for(int i = 0; i < coordinate.length; i++) {
            sumX += coordinate[i][0];
            sumY += coordinate[i][1];
        }
        double[] mean = {sumX/coordinate.length, sumY/coordinate.length};
        return mean;
    }
    
    public static double Distance(int i, double[] mean) {
        double result = Math.sqrt(Math.pow((double)coordinate[i][0] - mean[0], 2) + Math.pow((double)coordinate[i][1] - mean[1], 2));
        return result;
    }
    
    public static int[] Swap(int[] a, int i, int j) {
        int dummy = a[i];
        a[i] = a[j];
        a[j] = dummy;
        
        return a;
    }
    
    public static double[] Swap(double[] a, int i, int j) {
        double dummy = a[i];
        a[i] = a[j];
        a[j] = dummy;
        
        return a;
    }
    
    public static int[] SortByFarthestFromMean(double[] mean) {
        double[] distance = new double[coordinate.length];
        for(int i = 0; i < coordinate.length; i++) {
            distance[i] = Distance(i, mean);
        }
        Print(distance);
        int[] permutation = new int[coordinate.length];
        for(int i = 0; i < coordinate.length; i++) {
            permutation[i] = i;
        }
        
        for(int i = 1; i < coordinate.length; i++) {
            for(int j = i; j > 0; j--) {
                if(distance[j] > distance[j-1]) {
                    distance = Swap(distance, j-1, j);
                    permutation = Swap(permutation, j-1, j);
                }
            }
        }
        
        return permutation;
    }
    
    public static void SortWithIndex(int[] index, double[] m) {
        for(int i = 1; i < m.length; i++) {
            for(int j = i; j > 0; j--) {
                if(m[j] < m[j-1]) {
                    Swap(m, j-1, j);
                    Swap(index, j-1, j);
                }
            }
        }
    }
    
    public static void IterativeAlgorithm4() {
        int[] permutation = new int[coordinate.length];
        int[] other = new int[coordinate.length];
        for(int i = 0; i < coordinate.length; i++) {
            other[i] = i;
        }
        
        double[] mean = MeanOfCoordinate();
        
        permutation = SortByFarthestFromMean(mean);
        
        int result1[] = new int[3];
        for(int i = 0; i < 3; i++){
            result1[i] = permutation[i];
        }
        
        for(int i = 3; i < coordinate.length; i++) {
            int best = 1;
            int a[] = Add(result1, permutation[i], 1);
            double min = Score(a);
            for(int j = 2; j <= i; j++) {
                a = Add(result1, permutation[i], j);
                double score = Score(a);
                if(min > score) {
                    min = score;
                    best = j;
                }
            }
            result1 = Add(result1, permutation[i], best);
        }
        // index 0 diletakkan di depan
        result1 = Sort(result1);
        result = new int[result1.length];
        result = result1;
        
    }
    
    public static void IterativeAlgorithm3() {
        int[] permutation = new int[coordinate.length];
        int[] other = new int[coordinate.length];
        for(int i = 0; i < coordinate.length; i++) {
            other[i] = i;
        }
        
        //Proses ke-1
        permutation[0] = FarthestCoordinate();
        System.out.println(permutation[0]);
        
        /*
        int i = 1;
            other = OtherCoordinate(permutation, other, i);
            Print(other);
            permutation[i] = FarthestCoordinate(other);
            System.out.println(permutation[i]);
        
            i++;
            other = OtherCoordinate(permutation, other, i);
            Print(other);
            permutation[i] = FarthestCoordinate(other);
            System.out.println(permutation[i]);
        */
        
        //Proses ke-2
        for(int i = 1; i < coordinate.length; i++) {
            other = OtherCoordinate(permutation, other, i);
            Print(other);
            permutation[i] = FarthestCoordinate(other);
            System.out.println(permutation[i]);
        }
        
        int result1[] = new int[3];
        for(int i = 0; i < 3; i++){
            result1[i] = permutation[i];
        }
        
        for(int i = 3; i < coordinate.length; i++) {
            int best = 1;
            int a[] = Add(result1, permutation[i], 1);
            double min = Score(a);
            for(int j = 2; j <= i; j++) {
                a = Add(result1, permutation[i], j);
                double score = Score(a);
                if(min > score) {
                    min = score;
                    best = j;
                }
            }
            result1 = Add(result1, permutation[i], best);
        }
        result1 = Sort(result1);
        result = new int[result1.length];
        result = result1;
        
    }
    
    public static void IterativeAlgorithm2() {
        int[] permutation = new int[coordinate.length];
        int[] other = new int[coordinate.length];
        for(int i = 0; i < coordinate.length; i++) {
            other[i] = i;
        }
        
        //Proses ke-1
        permutation[0] = FarthestCoordinate();
        System.out.println(permutation[0]);
        
        //Proses ke-2
        for(int i = 1; i < coordinate.length; i++) {
            other = OtherCoordinate(permutation, other, i);
            Print(other);
            permutation[i] = FarthestCoordinate(permutation,other,i);
            System.out.println(permutation[i]);
        }
        
        int result1[] = new int[3];
        for(int i = 0; i < 3; i++){
            result1[i] = permutation[i];
        }
        
        for(int i = 3; i < coordinate.length; i++) {
            int best = 1;
            int a[] = Add(result1, permutation[i], 1);
            double min = Score(a);
            for(int j = 2; j <= i; j++) {
                a = Add(result1, permutation[i], j);
                double score = Score(a);
                if(min > score) {
                    min = score;
                    best = j;
                }
            }
            result1 = Add(result1, permutation[i], best);
        }
        result1 = Sort(result1);
        result = new int[result1.length];
        result = result1;
    }
    
    public static double Distance(int x, int y) {
        double result = Math.sqrt(Math.pow(coordinate[x][0] - coordinate[y][0], 2) + Math.pow(coordinate[x][1] - coordinate[y][1], 2));
        return result;
    }
    
    public static void DistanceBetweenPointToLine(int x1, int y1, int x2, int y2, int x0, int y0) {
        double a = (double)((y2-y1)*x0 - (x2-x1)*y0 + x2*y1 - y2*x1);
        double d = Math.abs(a)/Math.sqrt((double)(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2)));
        System.out.println(d);
    }
    
    
    public static void IterativeKCorrection(int[] A, int K, int I) {
        int[] allMinKPoint = {};
            
        for(int iterasi = 0; iterasi < I; iterasi++) {
            for(int i = 0; i < A.length; i++) {
                int[] kPoint = new int[K];
                for(int j = 0; j < K; j++) {
                    kPoint[j] = A[(i+j)%A.length];
                }
                //Print(kPoint);
                allMinKPoint = new int[A.length - K];
                for(int j = K; j < A.length; j++) {
                    allMinKPoint[j-K] = A[(i+j)%A.length];
                }
                //Print(allMinKPoint);

                int[] permutation = RandomPermutation(K);
                //Print(permutation);

                int[] dummyForKPoint = new int[K];
                for(int j = 0; j < K; j++) {
                    dummyForKPoint[j] = kPoint[j];
                }
                for(int j = 0; j < K; j++) {
                    kPoint[j] = dummyForKPoint[permutation[j]];
                }
                //Print(kPoint);

                for(int ii = 0; ii < K; ii++) {
                    int best = 1;
                    int a[] = Add(allMinKPoint, kPoint[ii], 1);
                    //Core.Print(a);
                    double min = Score(a);
                    //System.out.println(min);
                    for(int j = 2; j <= allMinKPoint.length; j++) {
                        a = Add(allMinKPoint, kPoint[ii], j);
                        //Core.Print(a);
                        double score = Score(a);
                        //System.out.println(score);
                        if(min > score) {
                            min = score;
                            best = j;
                        }
                    }
                    allMinKPoint = Add(allMinKPoint, kPoint[ii], best);
                    //System.out.println("masuk");
                    //Print(allMinKPoint);
                }
                //System.out.println("keluar");
                A = Sort(allMinKPoint);
                //Print(A);
            }
        }
        result = allMinKPoint;
    }
    
    public static int[] RemoveBInArrayA(int[] a, int b) {
        int[] c = new int[a.length - 1];
        int index = 0;
        for(int i : a) {
            if(i != b) {
                c[index] = i;
                index++;
            }
        }
            
        return c;
    }
    
    public static int[] Remove(int[] a, int j) {
        int[] b = new int[a.length - 1];
        int index = 0;
        for(int i = 0; i < a.length; i++) {
            if(i != j) {
                b[index] = a[i];
                index++;
            }
        }
            
        return b;
    }
    
    public static void MoreIteration(int n) {
        int[] result1 = new int[result.length];
        for(int i = 0; i < coordinate.length; i++) {
            int[] b = Remove(result,i);
            System.out.println(i);
            Print(result);
            Print(b);
            int best = 1;
            int[] a = Add(b, result[i], 1);
            //Core.Print(a);
            double min = Score(a);
            //System.out.println(min);
            for(int j = 2; j <= b.length; j++) {
                a = Add(b, result[i], j);
                //Core.Print(a);
                double score = Library.Score(a);
                //System.out.println(score);
                if(min > score) {
                    min = score;
                    best = j;
                }
            }
            result1 = Add(b, result[i], best);
        }
        result1 = Sort(result1);
        //Core.Print(result);
        //System.out.println(Core.Score(result));
        
        result = new int[result1.length];
        result = result1;
    }
    
    public static void IterativeAlgorithm() {
        int numberOfCoordinate = coordinate.length;
        
        int[] permutation = RandomPermutation();
        
        
        
        int result1[] = new int[3];
        for(int i = 0; i < 3; i++){
            result1[i] = permutation[i];
        }
        //Core.Print(result);
        
        //System.out.println();
        for(int i = 3; i < numberOfCoordinate; i++) {
            int best = 1;
            int a[] = Add(result1, permutation[i], 1);
            //Core.Print(a);
            double min = Score(a);
            //System.out.println(min);
            for(int j = 2; j <= i; j++) {
                a = Add(result1, permutation[i], j);
                //Core.Print(a);
                double score = Library.Score(a);
                //System.out.println(score);
                if(min > score) {
                    min = score;
                    best = j;
                }
            }
            result1 = Add(result1, permutation[i], best);
        }
        //System.out.println();
        
        //Core.Print(result);
        //System.out.println(Core.Score(result));
        
        result1 = Sort(result1);
        //Core.Print(result);
        //System.out.println(Core.Score(result));
        
        result = new int[result1.length];
        result = result1;
    }
    
    public static void LoadResult(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int n = input.nextInt();
            result = new int[n];
            for(int i = 0; i < n; i++) {
                result[i] = input.nextInt();
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void LoadCoordinateTSP(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            input.nextInt();
            int n = input.nextInt();
            coordinate = new int[n][2];
            for(int i = 0; i < n; i++) {
                input.nextInt();
                coordinate[i][0] = (int)input.nextDouble();
                coordinate[i][1] = (int)input.nextDouble();
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    //mengambil koordinate double
    public static void EUC2D(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int n = input.nextInt();
            double[][] a = new double[n][2];
            for(int i = 0; i < n; i++) {
                input.nextInt();
                a[i][0] = input.nextDouble();
                a[i][1] = input.nextDouble();
            }
            Print(a);
            java.io.File file1 = new java.io.File("matriks.txt");
            
            java.io.PrintWriter output = new java.io.PrintWriter(file1);
            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < a.length; j++) {
                    if(i != j) {
                        double xd = a[i][0] - a[j][0];
                        double yd = a[i][1] - a[j][1];
                        double distance = Math.sqrt(xd*xd + yd*yd) + 0.5;
                        int dij = (int)distance;
                        output.print(dij + "\t");
                    }
                    else {
                        output.print("0\t");
                    }
                }
                output.println("");
            }
            output.close();
            
            
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void CreateMatrix(String path, String hasil) {
        java.io.File file = new java.io.File(path);

        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int typeInput = input.nextInt();

            // EUC_2D
            if(typeInput == 6) {
                int n = input.nextInt();
                double[][] a = new double[n][2];
                for(int i = 0; i < n; i++) {
                    input.nextInt();
                    a[i][0] = input.nextDouble();
                    a[i][1] = input.nextDouble();
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        if(i != j) {
                            double xd = a[i][0] - a[j][0];
                            double yd = a[i][1] - a[j][1];
                            double distance = Math.sqrt(xd*xd + yd*yd) + 0.5;
                            int dij = (int)distance;
                            output.print(dij + "\t");
                        }
                        else {
                            output.print("0\t");
                        }
                    }
                    output.println("");
                }
                output.close();
            }

            // GEO
            else if(typeInput == 1) {
                int n = input.nextInt();
                double[][] a = new double[n][2];
                for(int i = 0; i < n; i++) {
                    input.nextInt();
                    a[i][0] = input.nextDouble();
                    a[i][1] = input.nextDouble();
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        if(i != j) {
                            double xi = a[i][0];
                            double yi = a[i][1];
                            double xj = a[j][0];
                            double yj = a[j][1];
                            double pi = 3.141592;
                            double deg, min;

                            deg = (int)xi;
                            min = xi - deg;
                            double latitudei = pi*(deg+5.0*min/3.0)/180.0;
                            deg = (int)yi;
                            min = yi - deg;
                            double longitudei = pi*(deg+5.0*min/3.0)/180.0;

                            deg = (int)xj;
                            min = xj - deg;
                            double latitudej = pi*(deg+5.0*min/3.0)/180.0;
                            deg = (int)yj;
                            min = yj - deg;
                            double longitudej = pi*(deg+5.0*min/3.0)/180.0;

                            double RRR = 6378.388;
                            double q1 = Math.cos(longitudei - longitudej);
                            double q2 = Math.cos(latitudei - latitudej);
                            double q3 = Math.cos(latitudei + latitudej);

                            double Dij = RRR*Math.acos(0.5*((1.0+q1)*q2 - (1.0-q1)*q3))+1.0;

                            int dij = (int)Dij;

                            output.print(dij + "\t");
                        }
                        else {
                            output.print("0\t");
                        }
                    }
                    output.println("");
                }
                output.close();
            }

            // LOWER_DIAG_ROW
            else if(typeInput == 2) {
                int n = input.nextInt();
                int[][] a = new int[n][n];
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j <= i; j++) {
                        a[i][j] = input.nextInt();
                        a[j][i] = a[i][j];
                    }
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        int distance = a[i][j];
                        output.print(distance + "\t");
                    }
                    output.println("");
                }
                output.close();
            }

            // UPPER_ROW
            else if(typeInput == 3) {
                int n = input.nextInt();
                int[][] a = new int[n][n];
                for(int i = 0; i < n-1; i++) {
                    for(int j = i+1; j < n; j++) {
                        a[i][j] = input.nextInt();
                        a[j][i] = a[i][j];
                    }
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        int distance = a[i][j];
                        output.print(distance + "\t");
                    }
                    output.println("");
                }
                output.close();
            }

            // FULL_MATRIX
            else if(typeInput == 4) {
                int n = input.nextInt();
                int[][] a = new int[n][n];
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        a[i][j] = input.nextInt();
                    }
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        int distance = a[i][j];
                        output.print(distance + "\t");
                    }
                    output.println("");
                }
                output.close();
            }

            // ATT
            else if(typeInput == 5) {
                int n = input.nextInt();
                double[][] a = new double[n][2];
                for(int i = 0; i < n; i++) {
                    input.nextInt();
                    a[i][0] = input.nextDouble();
                    a[i][1] = input.nextDouble();
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        if(i != j) {
                            double xd = a[i][0] - a[j][0];
                            double yd = a[i][1] - a[j][1];
                            double rij = Math.sqrt((xd*xd + yd*yd)/10.0);
                            int tij = (int)rij;
                            int dij;
                            if((double)tij < rij) {
                                dij = tij+1;
                            }
                            else {
                                dij = tij;
                            }
                            output.print(dij + "\t");
                        }
                        else {
                            output.print("0\t");
                        }
                    }
                    output.println("");
                }
                output.close();
            }

            // UPPER_DIAG_ROW
            else if(typeInput == 7) {
                int n = input.nextInt();
                int[][] a = new int[n][n];
                for(int i = 0; i < n; i++) {
                    for(int j = i; j < n; j++) {
                        a[i][j] = input.nextInt();
                        a[j][i] = a[i][j];
                    }
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        int distance = a[i][j];
                        output.print(distance + "\t");
                    }
                    output.println("");
                }
                output.close();
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void GEO(String path, String hasil) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int n = input.nextInt();
            double[][] a = new double[n][2];
            for(int i = 0; i < n; i++) {
                input.nextInt();
                a[i][0] = input.nextDouble();
                a[i][1] = input.nextDouble();
            }
            Print(a);
            java.io.File file1 = new java.io.File(hasil);
            
            java.io.PrintWriter output = new java.io.PrintWriter(file1);
            output.println(a.length);
            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < a.length; j++) {
                    if(i != j) {
                        double xi = a[i][0];
                        double yi = a[i][1];
                        double xj = a[j][0];
                        double yj = a[j][1];
                        double pi = 3.141592;
                        double deg, min;
                        
                        deg = (int)xi;
                        min = xi - deg;
                        double latitudei = pi*(deg+5.0*min/3.0)/180.0;
                        deg = (int)yi;
                        min = yi - deg;
                        double longitudei = pi*(deg+5.0*min/3.0)/180.0;
                        
                        deg = (int)xj;
                        min = xj - deg;
                        double latitudej = pi*(deg+5.0*min/3.0)/180.0;
                        deg = (int)yj;
                        min = yj - deg;
                        double longitudej = pi*(deg+5.0*min/3.0)/180.0;
                        
                        double RRR = 6378.388;
                        double q1 = Math.cos(longitudei - longitudej);
                        double q2 = Math.cos(latitudei - latitudej);
                        double q3 = Math.cos(latitudei + latitudej);
                        
                        double Dij = (RRR*Math.acos(0.5*((1.0+q1)*q2 - (1.0-q1)*q3))+1.0);
                        
                        int dij = (int)Dij;
                        /*
                        if(distance - (int)distance < 0.5) {
                            dij = (int)distance;
                        }
                        else {
                            dij = (int)distance + 1;
                        }
                        */
                        output.print(dij + "\t");
                    }
                    else {
                        output.print("0\t");
                    }
                }
                output.println("");
            }
            output.close();
            
            
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void LoadMatrixDouble(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int n = input.nextInt();
            double[][] a = new double[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = input.nextDouble();
                }
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + "\t");
                }
                System.out.println("");
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void LOWER_DIAG_ROW(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int n = input.nextInt();
            int[][] a = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j <= i; j++) {
                    a[i][j] = input.nextInt();
                    a[j][i] = a[i][j];
                }
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + "\t");
                }
                System.out.println("");
            }
            
            java.io.File file1 = new java.io.File("matriks.txt");
            
            java.io.PrintWriter output = new java.io.PrintWriter(file1);
            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < a.length; j++) {
                    int distance = a[i][j];
                    output.print(distance + " ");
                }
                output.println("");
            }
            output.close();
            
            }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void UPPER_ROW(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int n = input.nextInt();
            int[][] a = new int[n][n];
            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j < n; j++) {
                    a[i][j] = input.nextInt();
                    a[j][i] = a[i][j];
                }
            }
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + "\t");
                }
                System.out.println("");
            }
            
            java.io.File file1 = new java.io.File("matriks.txt");
            
            java.io.PrintWriter output = new java.io.PrintWriter(file1);
            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < a.length; j++) {
                    int distance = a[i][j];
                    output.print(distance + " ");
                }
                output.println("");
            }
            output.close();
            
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void SetCoordinate(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int n = input.nextInt();
            coordinate = new int[n][2];
            for(int i = 0; i < n; i++) {
                coordinate[i][0] = input.nextInt();
                coordinate[i][1] = input.nextInt();
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static double[] Sort(double[] a) {
        double[] b = new double[a.length];
        
        int position = 0;
        if(a[0] != 0) {
            for(int i = 1; i < a.length; i++) {
                if(a[i] == 0) {
                    position = i;
                    break;
                }
            }
        }
        for(int i = position; i < a.length; i++) {
            b[i-position] = a[i];
        }
        for(int i = 0; i < position; i++) {
            b[i+a.length-position] = a[i];
        }
        
        if(b[1] < b[a.length-1]) {
            return b;
        }
        else {
            double[] c = new double[a.length];
            c[0] = b[0];
            for(int i = 1; i < a.length; i++) {
                c[i] = b[a.length-i];
            }
            return c;
        }
    }
    
    // index 0 diletakkan di depan
    public static int[] Sort(int[] a) {
        int[] b = new int[a.length];
        
        int position = 0;
        if(a[0] != 0) {
            for(int i = 1; i < a.length; i++) {
                if(a[i] == 0) {
                    position = i;
                    break;
                }
            }
        }
        for(int i = position; i < a.length; i++) {
            b[i-position] = a[i];
        }
        for(int i = 0; i < position; i++) {
            b[i+a.length-position] = a[i];
        }
        
        if(b[1] < b[a.length-1]) {
            return b;
        }
        else {
            int[] c = new int[a.length];
            c[0] = b[0];
            for(int i = 1; i < a.length; i++) {
                c[i] = b[a.length-i];
            }
            return c;
        }
    }
    
    public static int[] Add(int[] a, int b) {
        int[] c = new int[a.length+1];
        for(int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        c[a.length] = b;
        return c;
    }
    
    public static int[] Add(int[] a, int b, int position) {
        int[] c = new int[a.length+1];
        for(int i = 0; i < position; i++) {
            c[i] = a[i];
        }
        c[position] = b;
        for(int i = position+1; i < a.length+1; i++) {
            c[i] = a[i-1];
        }
        return c;
    }
    
    public static void Print(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    
    public static void PrintPlusOne(int[] a) {
        /*
        for(int i = 0; i < a.length; i++) {
            System.out.print((a[i]+1) + " ");
        }
        System.out.println();
        */
        String[] s = {
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z",
            "A1",
            "B1"
        };
        for(int i = 0; i < a.length; i++) {
            
            System.out.print(s[a[i]] + " ");
        }
        System.out.println();
    }
    
    public static void Print(double[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void Print(double[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println();
    }
    
    public static void PrintCoordinate() {
        for(int i = 0; i < coordinate.length; i++) {
            System.out.println(i + "\t" + coordinate[i][0] + "\t" + coordinate[i][1]);
        }
        System.out.println();
    }
    
    public static void PrintDistance(double[][] a) throws Exception{
        java.io.File file = new java.io.File("matriks.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                double distance = Math.sqrt(Math.pow(a[i][0] - a[j][0], 2) + Math.pow(a[i][1] - a[j][1], 2));
                System.out.print(distance + " ");
            }
            System.out.println("");
        }
        System.out.println();
    }
    
    public static void PrintKeBawah(double[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();
    }
    
    public static void PrintResult() {
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i]+1 + " ");
        }
        System.out.println();
    }
    
    public static void PrintResultScore(){
        System.out.println(Score(result));
    }
    
    public static void PrintScore(int[] a){
        System.out.println(Score(a));
    }
    
    public static void PrintWithIndex(int[] index, double[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.println(index[i] + " " + a[i]);
        }
        System.out.println();
    }
    
    public static double Score(int[] a) {
        int n = a.length;
        double score = Math.sqrt(Math.pow(coordinate[a[0]][0] - coordinate[a[n-1]][0], 2) + Math.pow(coordinate[a[0]][1] - coordinate[a[n-1]][1], 2));
        for(int i = 1; i < n; i++) {
            score = score + Math.sqrt(Math.pow(coordinate[a[i]][0] - coordinate[a[i-1]][0], 2) + Math.pow(coordinate[a[i]][1] - coordinate[a[i-1]][1], 2));
        }
        //System.out.println(score);
        return score;
    }
    
}
