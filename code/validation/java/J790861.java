import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		
		Student[] students = new Student[n];
		for (int i = 0; i < n; i++) {
			students[i] = new Student(i + 1, sc.nextInt());
		}
		sc.close();
		
		Arrays.sort(students);
		
		for (Student po : students) {
			out.println(po.id);
		}
		out.flush();
	}
	
	static class Student implements Comparable<Student> {
		int id, tall;
		
		public Student(int id, int tall) {
			this.id = id;
			this.tall = tall;
		}
		
		@Override
		public int compareTo(Student po) {
			return -(this.tall - po.tall);
		}
	}
	
}