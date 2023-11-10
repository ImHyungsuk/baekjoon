#include <iostream>
#include <queue>
using namespace std;

int dfs[1001][1001] = {
    0,
};
int bfs[1001][1001] = {
    0,
};
int node[1001] = {
    0,
};

void DFS(int V, int N)
{
    for (int i = 1; i < N + 1; i++)
    {
        // cout << V << " to " << i << '\n';
        if ((dfs[V][i] == 1 || dfs[i][V] == 1) && !node[i])
        {
            cout << i << ' ';
            dfs[V][i] = 0;
            dfs[i][V] = 0;
            node[i] = 1;
            DFS(i, N);
        }
    }
    return;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N, M, V, tmp1, tmp2;
    queue<int> q;
    cin >> N >> M >> V;
    for (int i = 0; i < M; i++)
    {
        cin >> tmp1 >> tmp2;
        dfs[tmp1][tmp2] = 1;
        dfs[tmp2][tmp1] = 1;
        bfs[tmp1][tmp2] = 1;
        bfs[tmp2][tmp1] = 1;
    }
    cout << V << ' ';
    node[V] = 1;
    DFS(V, N);
    cout << '\n';
    // 방문 노드 초기화
    for (int i = 0; i < N + 1; i++)
    {
        node[i] = 0;
    }
    // bfs
    q.push(V);
    node[V] = 1;
    while (!q.empty())
    {
        // q를 pop해야하므로 q.front()를 tmp에 저장
        int tmp = q.front();
        cout << tmp << ' ';
        q.pop();
        // tmp( = pop하기 전 q.front())와 이어진 노드를 탐색 후 q에 푸시
        for (int i = 1; i <= N; i++)
        {
            // && 연산자가 || 보다 우선순위 높으므로 괄호 필수
            // 높지 않더라도 가독성을 위해 괄호가 더 좋음
            if ((bfs[tmp][i] == 1 || bfs[i][tmp] == 1) && node[i] == 0)
            {
                q.push(i);
                bfs[tmp][i] = 0;
                bfs[i][tmp] = 0;
                node[i] = 1;
            }
        }
    }

    return 0;
}