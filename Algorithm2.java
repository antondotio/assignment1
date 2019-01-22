import java.util.Scanner;

public class Algorithm2{

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
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a positive integer.");
        int value = scan.nextInt();
        long fibValue = loopFibonacci(value);
        System.out.println("The " + value + " number in the Fibonacci Series is "+ fibValue);
        scan.close();
    }
}