/* NetIds: sw883. Time spent: 1 hours, mm minutes. */

/** A collection of static String utility functions.
 * All methods assume that String parameters are non-null.
 *
 * If any method is called with arguments that do not satisfy the preconditions,
 * the behavior is undefined (it can do anything you want). For example, you
 * could (but do not have to) use assert statements to test preconditions.
 */
public class A2 {

	
    public static int sumDif(boolean b, int s1, int s2) {
        // This method is already implemented; it is here to give you something
        // to test, and to show you different ways of writing return statements.
        if (b) {
            int s;
            s = s1 + s2;
            return s;
        }
        return s1 - s2;
    }
 
    
    public static boolean isDoubled(String s) {
    	int len = s.length();
    	String s1 = s.substring(0, len/2);
    	String s2 = s.substring(len/2, len);
    	if (s1.equals(s2)){
    		return true;
    	}
        return false;
    }


    public static String reverse(String s) {
    	String rev = "";
    	int len = s.length();
    	if (len == 0 || len == 1){
    		return s;
    	}
    	for(int i = 0; i < len; i = i + 1){
    		rev = rev + Character.toString(s.charAt(len-i-1));
    	}
        return rev;
    }

    
    public static String encode(String s, String input, String output) {
    	int len2 = input.length();
    	if (len2 == 0){
    		return s;
    	}
    	for(int i = 0; i < len2; i = i +1){
    		if (s.contains(Character.toString(input.charAt(i)))){
    			s = s.replaceAll( Character.toString(input.charAt(i)), Character.toString(output.charAt(i)) );
    		}
    	}
        return s;
    }


    public static String deduplicate(String s) {
    	if (s.equals("")) {
            return s;
        }
        String x = Character.toString(s.charAt(0));
        int contain = s.substring(1).indexOf(x);
        int start_index = contain + 1;
        if (contain == -1){
            return s;
        }

        int len = s.length();
        String sub = s.substring(0, start_index);
        int len_sub = sub.length();
        while (contain != -1) {
            if (start_index + len_sub > len){
                return s;
            }
            if (sub.equals(s.substring(start_index, start_index+len_sub))){
                contain = s.substring(start_index + len_sub).indexOf(x);
                start_index = contain + start_index + len_sub;
                if (start_index + len_sub == len){
                    return sub;
                }
            }
            else{
                contain = s.substring(len_sub+1).indexOf(x);
                start_index = contain + len_sub + 1;
                sub = s.substring(0, start_index);
                len_sub = sub.length();
            }
        }
        return s;
    }


    public static int evaluate(String s) {
    	int sum = 0;
        int temp = 0;
        String sign = "";
        int start_index = 0;
        int end_index = 0;
        s = s.replaceAll("\\s+", "");
        int len = s.length();
        while (end_index < len){
            if(Character.isDigit(s.charAt(end_index))){
                end_index = end_index + 1;
                temp = Integer.parseInt(s.substring(start_index, end_index));
            }
            else{
                if (sign.equals("+")){
                    sum = sum + temp;
                }
                else if (sign.equals("-")){
                    sum = sum - temp;
                }
                else{
                    sum = temp;
                }
                sign = s.substring(end_index, end_index +1);
                start_index = end_index + 1;
                end_index = start_index;
            }

        }
        if (sign.equals("+")){
            sum = sum + temp;
        }
        else if(sign.equals("-")){
            sum = sum - temp;
        }
        else{
            sum = temp;
        }
        return sum;
    }
}
