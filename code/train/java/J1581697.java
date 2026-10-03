import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.in;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String[] inputs = reader.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int R = Integer.parseInt(inputs[2]);

        inputs = reader.readLine().split(" ");

        int[] routes = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();

        FloydWarshall floydWarshall = new FloydWarshall(N);
        for (int i = 0; i < M; i++) {
            inputs = reader.readLine().split(" ");
            floydWarshall.addEdge(
                    Integer.parseInt(inputs[0]) - 1,
                    Integer.parseInt(inputs[1]) - 1,
                    Integer.parseInt(inputs[2]));

        }

        int[][] graph = floydWarshall.solve();

        ArrayList<ArrayList<Integer>> permutations = permute(routes);


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < permutations.size(); i++) {
            ArrayList<Integer> permutation = permutations.get(i);
            int sum = 0;
            for (int j = 0; j < permutation.size() - 1; j++) {
                sum += graph[permutation.get(j) - 1][permutation.get(j + 1) - 1];
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }

    private static ArrayList<ArrayList<Integer>> permute(int[] num) {
        return permuteHelper(num, 0);
    }

    private static ArrayList<ArrayList<Integer>> permuteHelper(int num[], int index) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (index == num.length - 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(num[index]);
            result.add(list);
            return result;
        } else {
            ArrayList<ArrayList<Integer>> partial = permuteHelper(num, index + 1);
            for (ArrayList<Integer> list : partial) {
                for (int i = 0; i <= list.size(); i++) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                    tmp.add(i, num[index]);
                    result.add(tmp);
                }
            }
            return result;
        }
    }

    public static class FloydWarshall {
        int n;
        int[][] dist;
        int INF = Integer.MAX_VALUE / 2;

        public FloydWarshall(int n) {
            this.n = n;
            this.dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        dist[i][j] = 0;
                    } else {
                        dist[i][j] = INF;
                    }
                }
            }
        }

        public void addEdge(int i, int j, int weight) {
            this.dist[i][j] =  this.dist[j][i] = weight;
        }

        public void removeEdge(int i, int j) {
            this.dist[i][j] = this.dist[j][i] = INF;
        }

        public int[][] solve() {

            for (int k = 0; k < this.n; k++) {
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.n; j++) {
                        this.dist[i][j] = Math.min(this.dist[i][j], this.dist[i][k] + this.dist[k][j]);
                    }
                }
            }
            return dist;
        }

    }

}
