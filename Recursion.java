/**
 * @author Han Wang
 * @UNI hw2900
 * Programming Assignment 2 - Recursion exercises
 * COMS W3134

 * Note: All methods must be written recursively. No credit will be given for
 * methods written without recursion, even if they produce the correct output.
 */

public class Recursion {

    /**
     * Returns the value of x * y, computed via recursive addition.
     * x is added y times.
     *
     * @param x integer multiplicand 1
     * @param y integer multiplicand 2
     * @return x * y
     */
    public static int recursiveMultiplication(int x, int y) {
        // if x > 0, =x*[(x-1)*y]
        if (x > 0) {
            return y + recursiveMultiplication(x - 1, y);
        }
        // if x < 0, =x*[(x+1)*y]
        if (x < 0){
            return y+ recursiveMultiplication(x + 1 , y);
        }
        return 0;
    }



    /******************************************************************************/
    private static int maxHelper(int[] array, int index, int max) {
        if (index == array.length) {
            return max;
        }
        // if max is smaller than one of integers in the array. Use that integer to compare with another one integer.
        if (array[index] > max){
            return maxHelper(array, index + 1, array[index]);
        }
        // if max larger, then use max to compare with the next integer
        return maxHelper(array, index+1, max);
    }

        /**
         * Returns the maximum value in the array
         * Uses a helper method to do the recursion.
         * @param array  the array of integers to traverse
         * @return the maximum value in the array
         */
        public static int max (int[] array){
            return maxHelper(array, 0, Integer.MIN_VALUE);
        }

    /******************************************************************************/

        /**
         * Returns whether or not a string is a palindrome, a string that is
         * the same both forward and backward.
         * @param s  the string to process
         * @return a boolean indicating if the string is a palindrome
         */
        public static boolean isPalindrome (String s){
            //variable length equals to the length of the string
            int length = s.length();
            if (length <= 1){
                return true;
            }
            if (s.charAt(0) != s.charAt(length - 1)){
                return false;
            }
            //drop the first character and return remaining str to the recursion
            return isPalindrome(s.substring(1, length-1));
        }

    /******************************************************************************/
        private static boolean memberHelper ( int key, int[] array, int index){
            //if the key is not in the array, return false
            if (index == array.length) {
                return false;
            }
            if (key == array[index]){
                return true;
            }
            //start finding key from index 0, if not found, move to the next index.
            return memberHelper(key, array, index+1);
        }

        /**
         * Returns whether or not the integer key is in the array of integers.
         * Uses a helper method to do the recursion.
         * @param key    the value to seek
         * @param array  the array to traverse
         * @return a boolean indicating if the key is found in the array
         */
        public static boolean isMember ( int key, int[] array){
            return memberHelper(key, array, 0);
        }

    /******************************************************************************/
        /**
         * Returns a new string where identical chars that are adjacent
         * in the original string are separated from each other by a tilde '~'.
         * @param s  the string to process
         * @return a new string where identical adjacent characters are separated
         *           by a tilde
         */
        public static String separateIdentical (String s){
            if (s.length() <= 1){
                return s;
            }
            // two characters are the same, add ~
            if (s.charAt(0) == s.charAt(1)){
                return s.charAt(0) + "~" + separateIdentical(s.substring(1));
            }
            // if not the same, print the first character, return str starting form the second character to the recursion
            return s.charAt(0)+separateIdentical(s.substring(1));
        }


    /******************************************************************************/
    /**
     * Reverses a string via recursion.
     *
     * @param s the non-null string to reverse
     * @return a new string with the characters in reverse order
     */
    public static String reverse(String s) {
        // str less or equal than 1 character, return itself
        if (s.length() <= 1 || (s == null)){
            return s;
        }
        //recursive call
        return reverse(s.substring(1)) + s.charAt(0);
    }

}
