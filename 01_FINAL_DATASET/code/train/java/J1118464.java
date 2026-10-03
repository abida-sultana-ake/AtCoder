//package com.regular.arc069;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        if(s.length()<N){
            s+=sc.next();
        }
        String [] heads = {"SS","SW","WS","WW"};
        boolean flag = true;
        for(int i=0;i<4&&flag;i++){
            String tmp = checkCase(heads[i],s);
            if(!tmp.equals("")){
                System.out.println(tmp);
                flag = false;
            }
        }
        if(flag){
            System.out.println(-1);
        }

        sc.close();

    }

    private static String checkCase(String head,String s){
        char[] ans = new char [s.length()];
        ans[0] = head.charAt(0);
        ans[1] = head.charAt(1);

        for(int i=2; i<s.length();i++){
            if(ans[i-1]=='S'){
                if(s.charAt(i-1)=='o') {
                    ans[i] = ans[i - 2];
                }
                else{
                    if(ans[i-2]=='S'){
                        ans[i] = 'W';
                    }
                    else{
                        ans[i] = 'S';
                    }
                }
            }
            else{
                if(s.charAt(i-1)=='x') {
                    ans[i] = ans[i - 2];
                }
                else{
                    if(ans[i-2]=='S'){
                        ans[i] = 'W';
                    }
                    else{
                        ans[i] = 'S';
                    }
                }
            }

//            if(s.charAt(i-1)=='o'){
//                ans[i] = ans[i-2];
//            }
//            else{
//                if(ans[i-2]=='S'){
//                    ans[i] = 'W';
//                }
//                else{
//                    ans[i] = 'S';
//                }
//            }
        }

        boolean valid  = true;

        if(s.charAt(s.length()-1)=='o'){
            if(ans[s.length()-1]=='S') {
                if (ans[0] != ans[s.length() - 2]) {
                    valid = false;
                }
            }
            else {
                if (ans[0] == ans[s.length() - 2]) {
                    valid = false;
                }
            }
        }
        else {
            if(ans[s.length()-1]=='S') {
                if (ans[0] == ans[s.length() - 2]) {
                    valid = false;
                }
            }
            else {
                if (ans[0] != ans[s.length() - 2]) {
                    valid = false;
                }
            }
        }

        if(s.charAt(0)=='o'){
            if(ans[0]=='S') {
                if (ans[1] != ans[s.length() - 1]) {
                    valid = false;
                }
            }
            else {
                if (ans[1] == ans[s.length() - 1]) {
                    valid = false;
                }
            }
        }
        else {
            if(ans[0]=='S') {
                if (ans[1] == ans[s.length() - 1]) {
                    valid = false;
                }
            }
            else {
                if (ans[1] != ans[s.length() - 1]) {
                    valid = false;
                }
            }
        }

        if(valid){
            return String.valueOf(ans);
        }
        else{
            return "";
        }

    }

}
