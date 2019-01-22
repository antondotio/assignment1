import java.util.Scanner;

public class Algorithm1{

    public static long recursiveFibonacci(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a positive integer.");
        int value = scan.nextInt();
        long fibValue = recursiveFibonacci(value);
        System.out.println("The " + value + " number in the Fibonacci Series is "+ fibValue);
        scan.close();
    }
}