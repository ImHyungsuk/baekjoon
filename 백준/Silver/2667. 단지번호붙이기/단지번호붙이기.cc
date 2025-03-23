#include <bits/stdc++.h>
using namespace std;
int N;
vector<vector<char>> v(25, vector<char>(25));
vector<vector<int>> visited(25, vector<int>(25, 0));
vector<int> ret;
stack<pair<int, int>> st;

int dfs()
{
    int ret = 1;
    while (!st.empty())
    {
        int x = st.top().first;
        int y = st.top().second;
        // cout << "x " << x << " y " << y << " ret " << ret << "\n";
        st.pop();
        if (x - 1 >= 0 && visited[x - 1][y] == 0)
        {
            st.push(make_pair(x - 1, y));
            visited[x - 1][y] = 1;
            ret++;
        }
        if (x + 1 < N && visited[x + 1][y] == 0)
        {
            st.push(make_pair(x + 1, y));
            visited[x + 1][y] = 1;
            ret++;
        }
        if (y - 1 >= 0 && visited[x][y - 1] == 0)
        {
            st.push(make_pair(x, y - 1));
            visited[x][y - 1] = 1;
            ret++;
        }
        if (y + 1 < N && visited[x][y + 1] == 0)
        {
            st.push(make_pair(x, y + 1));
            visited[x][y + 1] = 1;
            ret++;
        }
    }
    return ret;
}

int main()
{
    int cnt = 0;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> v[i][j];
            if (v[i][j] == '0')
                visited[i][j] = 1;
        }
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (v[i][j] == '1' && visited[i][j] == 0)
            {
                cnt++;
                st.push(make_pair(i, j));
                visited[i][j] = 1;
                ret.push_back(dfs());
            }
        }
    }
    sort(ret.begin(), ret.begin() + cnt);
    cout << cnt << "\n";
    for (int i = 0; i < cnt; i++)
    {
        cout << ret[i] << "\n";
    }
    return 0;
}