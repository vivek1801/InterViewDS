package arrays;

import java.util.Scanner;

public class StringReverse {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    if (null != s && s.length() > 1) reverse(s);
  }

  private static void reverse(String string) {
    char[] charArray = string.toCharArray();
    char[] charNewArray = new char[charArray.length];
    for (int i = 0; i < charArray.length; i++) {
      charNewArray[i] = charArray[(charArray.length - 1) - i];
    }
    String x = new String(charNewArray);
    System.out.println(x);
  }
}
