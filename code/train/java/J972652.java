import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.StringBuilder;
import java.lang.Math;

public class Main {
  char[] input;

  private static char[] simplify(char[] chseq) {
    StringBuilder ret = new StringBuilder();

    int i = 0;
    while (i < chseq.length) {
      char ch = chseq[i];
      i++;
      while(i < chseq.length && chseq[i] == ch) i++;
      ret.append(ch);
    }

    return ret.toString().toCharArray();
  }

  private static char[] putStone(char[] chseq) {
    int i = 0;
    char[] ret = new char[chseq.length - 1];
    while (i < ret.length) {
      ret[i] = chseq[i];
      i++;
    }
    return ret;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String inStr = in.next();

    int cnt = 0;

    char[] chseq = inStr.toCharArray();
    chseq = simplify(chseq);
    if (chseq.length != 1) {
      cnt = chseq.length - 1;
    }

    System.out.println(cnt);
  }
}