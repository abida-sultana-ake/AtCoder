import java.util.*;

public class Main { 

    static char A[][] = new char[10][10];        
    static boolean visited[][] = new boolean[10][10];
            
    public static void main(String[] args) {		        
        Scanner sc = new Scanner(System.in);                                                              
                                       
        for(int i = 1;i <= 10;i++){
            String str = sc.next();
            for(int j = 1; j <= 10;j++){
                A[i-1][j-1] = str.charAt(j-1);
            }            
        }
        
        int count = 0;
        
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 10;j++){
               if(A[i][j] == 'o'){
                   count++;
               }   
            }            
        }
                
        for(int i = 0;i < 10;i++){
            for(int j = 0 ;j < 10;j++){                                                
                if(A[i][j] == 'o'){
                   continue; 
                }              
                
                for(int k = 0;k < 10;k++){
                    for(int l = 0; l < 10;l++){
                        visited[k][l] = false;   
                    }                    
                }
                
                A[i][j] = 'o';
                if(dfs(i,j) == count+1){
                    System.out.println("YES");
                    return;
                }
                A[i][j] = 'x';
                
            }            
        }
        
        System.out.println("NO");
                      
    }   
    
    private static int dfs(int i,int j){
        if(i < 0 || 10 <= i || j<0 || 10 <=j) return 0;                
        if(visited[i][j]) return 0;
        visited[i][j] = true;
        if(A[i][j] == 'x') return 0;
        return dfs(i-1,j) + dfs(i,j-1) + dfs(i+1,j) + dfs(i,j+1) + 1;
    }    
    
}