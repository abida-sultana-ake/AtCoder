import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String a = br.readLine();
    sb.append(a);
    String[] str = br.readLine().split(" ");
    for(int i = 0; i < 4; i++){
      int pos = Integer.parseInt(str[i]) + i;
      sb.insert(pos,'\"');
    }
    System.out.println(sb);
  }
}