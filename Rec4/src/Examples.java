import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;


public class Examples {
    public static void main(String[] args) {
        int[] ho= new int[25];
        ho[0]= 1;
        ho[2]= 1;
        ho[4]= 5;
        System.out.println(Arrays.toString(removeDuplicates(ho)));

        int[] findNegTest = {110, -1, 11, 101, -101};
        for (Integer i : findNegatives(findNegTest)) {
            System.out.print(i + " ");
        }
        System.out.println();

        String foo = "()()[()]([[]])";
        String bar = "([)])";
        System.out.println(checkBraces(foo));
        System.out.println(checkBraces(bar));
    	
    }

    //problem 1: Remove duplicates
    /** Return a new array with all unique values in array */
    public static Integer[] removeDuplicates(int[] array) {
    	//System.out.println("original array: " + Arrays.toString(array));
        HashSet<Integer> x = new HashSet<>();
        for (int a: array){
        	x.add(a);
        }
        Integer[] new_array = x.toArray(new Integer[0]);
        //System.out.println("Remove duplicate:" + Arrays.toString(new_array));
        return new_array;
    }

    // problem 2: find all negative numbers in an array
    /** return a new array with all negative values in the input array */
    public static Integer[] findNegatives(int[] array) {
    	//System.out.println("original array: " + Arrays.toString(array));
        HashSet<Integer> x = new HashSet<>();
        for (int a: array){
        	if (a < 0)
        		x.add(a);
        }
        Integer[] new_array = x.toArray(new Integer[x.size()]);
        //System.out.println("Find negatives: " + Arrays.toString(new_array));
        return new_array;
    }

    // problem 3: validate braces in a string
    /** return true iff all parens and square braces, i.e., ( and [
     * are properly matched and legally nested.  */
    public static boolean checkBraces(String s) {
        Stack<Character> x = new Stack<>();
        x.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
        	if (s.charAt(i) == ')' && x.peek() == '(')
        		x.pop();
        	else if (s.charAt(i) == ']' && x.peek() == '[')
        		x.pop();
        	else
        		x.push(s.charAt(i));
        }
        return x.empty();
    }
}
