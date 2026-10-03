import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class Main {
    public static void main (String[] args) throws IOException
    {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	
    	int len = s.length();
    	int score = 0;
    	
    	for (int i = 1 ; i <= len ; i++){
    		if (i % 2 == 1){
    			if ("p".equals(s.substring(i-1,i))){
    				score = score - 1;
    			}
    			
    		} else {
    			if ("g".equals(s.substring(i-1,i))){
    				score = score + 1;
    			}
    			
    		}
    			
    	}
    	
    	System.out.println(score);
    }	
}
    
   