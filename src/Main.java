import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static int sEvenCounter;
    public static int sOddCounter;
    public static String sFibonacci;

    public static void main(String[] args) {
        int choose;
        do {
            Scanner scannerForChoose = new Scanner(System.in);
            System.out.println("1-Fibonacci " + "\n" + "2-Exit");
            choose = Integer.parseInt(scannerForChoose.nextLine());
            if (choose == 1) {
                try {
                    System.out.println("Print your number:");
                    Scanner scannerForFibonacci = new Scanner(System.in);
                    int maxNum = scannerForFibonacci.nextInt();
                    int counter = 0;
                    BigInteger a = new BigInteger("1");
                    BigInteger b = new BigInteger("0");
                    calculateFibonacci(b, a, maxNum, counter);
                    double percOfEvenNumbers = sEvenCounter / (double) maxNum * 100;
                    double percOfOddNumbers = sOddCounter / (double) maxNum * 100;
                    System.out.println("% of even numbers: " + percOfEvenNumbers + "%");
                    System.out.println("% of odd numbers: " + percOfOddNumbers + "%");
                    if(sFibonacci != null){
                        System.out.println(sFibonacci);
                    }else {
                        System.out.println("Max number is less then 567");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("you write incorrect number! " +
                            "Please write a positive integer number.");

                }
            }
        } while (choose != 2);
    }


    public static void calculateFibonacci(BigInteger a, BigInteger b, int maxNum, int counter) {
        BigInteger resultNumber = new BigInteger("0");
        resultNumber = resultNumber.add(b).add(a);
        String result = String.format("%d - %s", counter, resultNumber.toString());
        System.out.println(result);
        parityCheck(resultNumber);
        if (counter == 567 ) {
            sFibonacci = result;
        }
        if (counter < maxNum) {
            counter++;
            calculateFibonacci(resultNumber, a, maxNum, counter);
        }
    }

    public static void parityCheck(BigInteger resultNumber) {
        long temp = resultNumber.longValue();
        boolean isEven = temp % 2 == 0;
        if (isEven) {
            sEvenCounter++;
        } else {
            sOddCounter++;
        }

    }


}
