/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;



/**
 *
 * @author allegea
 */
public class Main {

    public static long gcd(long a,long b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           StringBuilder out = new StringBuilder();

            while ((line = in.readLine())!=null) 
            {
               long x = Integer.parseInt(line);
               
               BigInteger LCM = BigInteger.ONE;
               BigInteger GCD = BigInteger.ONE;
               BigInteger aux = BigInteger.ONE;
               String oo;
               for(long i=1;i<=x;i++){
               oo = in.readLine();
                   aux = new BigInteger(String.valueOf(oo));
                   GCD = LCM.gcd(aux);
                   LCM = (LCM.multiply(aux)).divide(GCD);
               }
               
               //System.out.println(Arrays.toString(numbers));
               System.out.println(LCM);
            }

        in.close();
        System.exit(0);
        
    }
}