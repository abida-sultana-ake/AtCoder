import java.util.*;

public class Main {
    public static class State {
        int[] visited;
        int now;

        public State(int[] visited, int now) {
            this.now = now;
            this.visited = visited.clone();
        }

        public String toString() {
            return Arrays.toString(this.visited) + String.format(" now: %d", this.now);
        }

        private boolean isAllVisited() {
            for (int i = 0; i < this.visited.length; i++) {
                if (this.visited[i] != 1)
                    return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;

        Queue<State> queue = new LinkedList<>();
        List<List<Integer>> paths = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            paths.add(i, new ArrayList<>());
        }

        int x,y;
        for (int i = 0; i < M; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            paths.get(x-1).add(y);
            paths.get(y-1).add(x);
        }
//        for (List<Integer> list : paths) {
//            System.out.println(list.toString());
//        }
        int[] visited = new int[N];
        visited[0] = 1;

        queue.add(new State(visited, 1));

        while(!queue.isEmpty()) {

            State state = queue.poll();
            int now = state.now;
//            System.out.println(state);
            if (state.isAllVisited()) {
                count += 1;
            } else {
                for (Integer i : paths.get(now-1)) {
                    if (state.visited[i-1] == 0) {
                        int[] v = state.visited.clone();
                        v[i-1] = 1;
                        queue.add(new State(v, i));
                    }
                }
            }
        }

        System.out.println(count);

    }

    private static int calc(int x) {
        return x;
    }

    private static void test() {
        assert calc(0) == 0;
    }
}
