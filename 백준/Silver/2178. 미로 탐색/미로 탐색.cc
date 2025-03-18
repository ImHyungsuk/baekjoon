#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, M, i, j, cnt;
    char map[101][101];
    int visit[101][101] = {0,},distance[101][101]={0,};
    queue<pair<pair<int, int>,int>> q;
    cin >> N >> M;
    for (i = 0; i < N; i++)
    {
        for (j = 0; j < M; j++)
        {
            cin >> map[i][j];
        }
    }
    q.push(make_pair(make_pair(0, 0),1));
    while (!q.empty())
    {
        i = q.front().first.first;
        j = q.front().first.second;
        int dist=q.front().second;
        // cout<<map[i][j]<<" "<<i<<" "<<j<<"\n";
        q.pop();
        if (i + 1 < N && map[i + 1][j] == '1'&&visit[i + 1][j]==0)
        {
            q.push(make_pair(make_pair(i + 1, j),dist+1));
            visit[i + 1][j]=1;
        distance[i+1][j]=dist+1;
        }
        if (i - 1 >= 0 && map[i - 1][j] == '1'&&visit[i - 1][j]==0)
        {
            q.push(make_pair(make_pair(i - 1, j),dist+1));
            visit[i - 1][j]=1;
        distance[i-1][j]=dist+1;
        }
        if (j + 1 < M && map[i][j+1] == '1'&&visit[i][j+1]==0)
        {
            q.push(make_pair(make_pair(i, j+1),dist+1));
            visit[i][j+1]=1;
        distance[i][j+1]=dist+1;
        }
        if (j - 1 >= 0 && map[i][j-1] == '1'&&visit[i][j-1]==0)
        {
            q.push(make_pair(make_pair(i , j-1),dist+1));
            visit[i][j-1]=1;
        distance[i][j-1]=dist+1;
        }
    }
    cout<<distance[N-1][M-1];

    return 0;
}