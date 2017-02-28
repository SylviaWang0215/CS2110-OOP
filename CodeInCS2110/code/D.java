import java.util.*;
/** Demo the development of recursive methods */
public class D {
  
  /** Implicit precondition of all String parameters: they are not null. */
  
  /** = sum of  digits in the decimal representation of n.
    e.g. sum(0) = 0, sum(3) = 3
    sum(34) = 7. 
    sum(1356) = 15.     6  + sum of the digits in 135
    Precondition: n >= 0. */
  public static int sumDigs(int n) {
    if (n < 10) {
      return n;
    }
    // {10 <= n}
    // return n%10 + sum of digits of n/10
    return n%10 + sumDigs(n/10);
  }
  
  
  
  /** = the length of s --without using function s.length. */
  public static int len(String s) {
      if (s.equals(""))
        return 0;
      return 1 + len(s.substring(1));
  }
  
  
  
  /** = number of 'e's in s */
  public static int countEm(String s)  {
    if (s.length() == 0) {
      return 0;
    }
    // {s.length() > 0}
    if (s.charAt(0) == 'e') {
      // return 1 + number of e's in s.substring(1)
      return 1 + countEm(s.substring(1));
    }
    return countEm(s.substring(1));
  }
  
  
  
  /** = number of the digits in the decimal representation of n.
    e.g. numDigits(0) = 1, numDigits(3) = 1, numDigits(34) = 2. 
    numDigits(1356) = 4.
    Precondition: n >= 0. */
  public static int numDigits(int n) {
    throw new UnsupportedOperationException();
  }
  
  
  
  /** = s with adjacent duplicates removed.
    Example: for s = "abbcccdeaaa", the answer is "abcdea".*/
  public static String rem1(String s) {
    throw new UnsupportedOperationException();
  }
  
  
  
  /** = s with every char duplicated. */
  public static String dup(String s) {
    if (s.equals("")) 
      return s;
    return "" + s.charAt(0) + s.charAt(0) + dup(s.substring(1));
    
  }
  
  
  
  /** = "s is a palindrome" --reads the same backward and forward. */
  public static boolean isPal(String s) {
    if (len(s) <= 1)
      return true;
    return s.charAt(0) == s.charAt(s.length() - 1) && isPal(s.substring(1, s.length() - 1));
  }
  
  
  
  /** = the reverse of s */
  public static String rev(String s) {
    if (s.length() <= 1)
      return s;
    return ""+s.charAt(s.length()-1) + rev(s.substring(0, s.length()-1));
  }
  
  
  
  
  
  /** = the permutations of s.
    e.g. the permutations of "abc" are 
    "abc", "acb", "bac", "bca", "cab", "cba"
    Precondition: the chars of s are all different.*/
  public static ArrayList<String> perms(String s) {
    throw new UnsupportedOperationException();
  }
  
}