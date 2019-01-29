public class Fibonacci{

    static long[][] FM = new long[2][2];

    public static long matrixFibonacci(int n){
        if(n == 0){
            return 0;
        }
        FM[0][0] = 1;
        FM[0][1] = 1;
        FM[1][0] = 1;
        FM[1][1] = 0;
        matrixPower(n-1);

        return FM[0][0];
    }

    public static void matrixPower(int n){
        if(n > 1){
            matrixPower(n/2);
            FM = matrixMultiply(FM, FM);
            long[][] m2 = new long [2][2];
            m2[0][0] = 1;
            m2[0][1] = 1;
            m2[1][0] = 1;
            m2[1][1] = 0;
            if(n % 2 != 0)
                FM = matrixMultiply(FM, m2);
        }
    }

    public static long[][] matrixMultiply(long[][] m1, long[][] m2){
        int i, j, k;
        long res;
        long resMatrix[][] = new long [2][2];
        for(i = 0; i < 2; i++){
            for(j = 0; j < 2; j++){
                res = 0;
                resMatrix[i][j] = 0;

                for(k = 0; k < 2; k++){
                    res = m1[i][k] * m2[k][j];
                    resMatrix[i][j] = resMatrix[i][j] + res;
                }
            }
        }
        return resMatrix;
    }
    
    public static long recursiveFibonacci(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
        }
    }
    
    public static long loopFibonacci(int n){
        long firstVal = 0;
        long secondVal = 1;
        long thirdVal = firstVal + secondVal;
        for(int i = 2; i < n; i++){
            firstVal = secondVal;
            secondVal = thirdVal;
            thirdVal = firstVal + secondVal;
        }
        if(n == 0){
            return firstVal;
        }else if(n == 1){
            return secondVal;
        }else{
            return thirdVal;
        }
    }

    public static void main(String[] args){ 

        long timei, timef, sum = 0;
        // for(int i = 0; i <= 45; i++){
        //     timei = System.nanoTime();
        //     recursiveFibonacci(i);
        //     timef = System.nanoTime() - timei;
        //     System.out.println(timef);
        // }

        // for(int i = 1000000; i <= 100000000; i += 1000000){
        //     timei = System.nanoTime();
        //     loopFibonacci(i);
        //     timef = System.nanoTime() - timei;
        //     System.out.println(timef);
        // }

        for(int i = 1000000; i <= 2000000000; i += 1000000){
            for(int j = 0; j < 1000 ; j++){
                timei = System.nanoTime();
                matrixFibonacci(i);
                timef = System.nanoTime() - timei;
                sum += timef;
                
            }
            System.out.println(sum / 1000);
        }
    }
}