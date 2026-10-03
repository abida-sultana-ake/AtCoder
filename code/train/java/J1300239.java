import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Main main = new Main();
		main.solveD();
	}

	private void solveD() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<Long> list = new ArrayList<>();
		for (int i = 0; i < 3 * N; i++) {
			list.add(sc.nextLong());
		}

		List<Long> maxSumList = getSumList(list, new PriorityQueue<>(Comparator.naturalOrder()), N);
		Collections.reverse(list);
		List<Long> minSumList = getSumList(list, new PriorityQueue<>(Comparator.reverseOrder()), N);

		List<Long> scoreList = new ArrayList<>();
		for (int splitIndex = N; splitIndex <= 2 * N; splitIndex++) {
			scoreList.add(maxSumList.get(splitIndex - 1) - minSumList.get(3 * N - 1 - splitIndex));
		}
		System.out.println(scoreList.stream().max(Comparator.naturalOrder()).get());
	}

	private List<Long> getSumList(List<Long> list, PriorityQueue<Long> queue, int limitSize) {
		List<Long> sumList = new ArrayList<>();
		long sum = 0L;
		for (long value : list) {
			queue.add(value);
			sum += value;
			if (queue.size() > limitSize) {
				sum -= queue.remove();
			}
			sumList.add(sum);
		}
		return sumList;
	}
}