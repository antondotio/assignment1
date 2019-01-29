import java.util.Scanner;

public class Algorithm3{
    static long[][] FM = new long[2][2];

    public static long matrixFibonacci(int n){
        if(n == 0){
            return 0;
        }
        FM[0][0] = 1;
        FM[0][1] = 1;
        FM[1][0] = 1;
        FM[1][1] = 0;
        MatrixPower(n-1);

        return FM[0][0];
    }

    public static void MatrixPower(int n){
        if(n > 1){
            MatrixPower(n/2);
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
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a positive integer.");
        int value = scan.nextInt();
        long fibValue = matrixFibonacci(value);
        System.out.println("The " + value + " number in the Fibonacci Series is "+ fibValue);
        scan.close();
    }
}