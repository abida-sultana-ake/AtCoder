import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
public static void main(String[] args) throws IOException {

BufferedReader input =new BufferedReader (new InputStreamReader (System.in));
String str = input.readLine( );
String[] list = str.split(" ");
int a = Integer.parseInt(list[0]);
int b = Integer.parseInt(list[1]);
int c = Integer.parseInt(list[2]);

if(a==b){
System. out. println(c);
}else if(a==c){
System. out. println(b);
}else if(b==c){
System. out. println(a);
}
}}
