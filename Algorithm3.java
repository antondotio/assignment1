import java.util.Scanner;

public class Algorithm3{
    static long[][] FM;

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
            long sum = 0;
            MatrixPower(n/2);
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    for(int k = 0; k < 2; k++){
                        sum = sum + FM[i][k] * FM[k][j];
                    }
                    FM[i][j] = sum;
                    sum = 0;
                }
            }
            if(n % 2 != 0){

            }
            // result[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
            // result[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
            // result[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
            // result[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        }
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