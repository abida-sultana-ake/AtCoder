//atcoder beginner contest 60
import java.util.Scanner;
class Main{
  private int n;
  private int bettime;
  private int[] time;
  public static void main(String[] args){
    Main s = new Main();
    s.readcommand();
    System.out.println(s.calctime());
  }

  void readcommand(){
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    bettime = scan.nextInt();
    time = new int[n];
    for(int i=0;i<n;i++) time[i] = scan.nextInt();
  }

  int calctime(){
    int counttime = 0;
    for(int i=0;i<n-1;i++){
      if(time[i+1]-time[i] < bettime){
        counttime += time[i+1]-time[i];
      }else{
        counttime += bettime;
      }
    }
    return counttime+bettime;
  }
}
