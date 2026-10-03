import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = input.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);

        int[][] graph = new int[n][n];
        final int INF = Integer.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }
        int m = Integer.parseInt(firstLine[1]);

        for (int i = 0; i < m; i++) {
            String[] in = input.readLine().split(" ");
            int from = Integer.parseInt(in[0]);
            int to = Integer.parseInt(in[1]);
            int weight = Integer.parseInt(in[2]);
            graph[from - 1][to - 1] = weight;
            graph[to - 1][from - 1] = weight;
        }

        int[][] answer = floydWarshall(graph, n);

        int[] possibleAnswers = new int[n];
        for (int i = 0; i < n; i++) {
            possibleAnswers[i] = getMaximumFromArray(answer[i]);
        }

        System.out.println(getMinimumFromArray(possibleAnswers));

    }

    private static int getMinimumFromArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    private static int getMaximumFromArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static int[][] floydWarshall(int[][] graph, int V) {

        int dist[][] = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        return dist;
    }
}
