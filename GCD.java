/**
 * The GCD program implements an application that
 * calculate the greatest  common divisor of two integers
 *
 * @author  Han Wang
 * @version 1.0
 * @Date   2022-09-14
 */

import java.lang.Math;

public class GCD {
    // Check if there are exactly two arguments
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("Usage: java GCD <integer m> <integer n>");
            System.exit(1);
        }
        int first = 0;
        int second = 0;

        try{
            //Check if the first argument is an integer
            first = Integer.parseInt(args[0]);
        } catch(NumberFormatException e){
            System.out.println("Error: The first argument is not a valid integer." );
            System.exit(1);
        }

        try{
            //Check if the second argument is an integer
            second = Integer.parseInt(args[1]);
        } catch(NumberFormatException e){
            System.out.println("Error: The second argument is not a valid integer.");
            System.exit(1);
        }

        if(first == 0 && second == 0) {
            //Special case: when both argument are 0, return undefined
            System.out.println("gcd(0, 0) = undefined");
            System.exit(1);
        }
//print out results
        System.out.println("Iterative: gcd("+args[0]+", " +args[1] + ") = "  + iterativeGcd(Math.abs(first), Math.abs(second)));
        System.out.println("Recursive: gcd("+args[0]+", " +args[1] + ") = "  + recursiveGcd(Math.abs(first), Math.abs(second)));

    }

    public static int iterativeGcd(int a, int b) {
        int r;
        while (b != 0){
            // remainder
            r = a % b;
            //let a equals b, b equals remainder, do it again until remainder equals 0
            a = b;
            b = r;
        }
        return a;
    }

    public static int recursiveGcd(int a, int b){
        // any number divides 0, return the other number
        if (b == 0)
            return a;
        else
            return recursiveGcd(b, a % b);
    }
}
