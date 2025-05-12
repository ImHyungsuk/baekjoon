import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static int[] visited;
    public static int[] parent;
    public static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        int N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N + 1];
        visited = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(input.nextToken());
            int v2 = Integer.parseInt(input.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        dfs(1, 0);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int cur, int layer) {
        for (int i = 0; i < adjList[cur].size(); i++) {
            int next = adjList[cur].get(i);
            if (visited[next] == 0) {
                visited[next] = 1;
                parent[next] = cur;
                dfs(next, layer + 1);
            }
        }
    }
}