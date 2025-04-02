#include <bits/stdc++.h>
using namespace std;

int find_p(vector<int> &parent, int num)
{
    if (parent[num] != num)
    {
        return find_p(parent, parent[num]);
    }
    else
    {
        return parent[num];
    }
}

void merge(vector<int> &parent, int u, int v)
{
    u = find_p(parent, u);
    v = find_p(parent, v);
    if (u != v)
    {
        if (u < v)
        {
            parent[v] = parent[u];
        }
        else
        {
            parent[u] = parent[v];
        }
    }
}

int main()
{
    int N, M, K, input, pNum, p, ret;
    vector<int> reality, visited, parent(51);
    vector<vector<int>> party, people, peo_par_list;
    cin >> N >> M;
    party.resize(M);
    cin >> K;
    for (int i = 0; i < 51; i++)
    {
        parent[i] = i;
    }
    if (K != 0)
    {
        for (int i = 0; i < K; i++)
        {
            cin >> input;
            parent[input] = 0;
        }
    }
    for (int i = 0; i < M; i++)
    {
        cin >> pNum;
        cin >> p;
        party[i].resize(pNum);
        party[i][0] = p;
        for (int j = 1; j < pNum; j++)
        {
            cin >> input;
            party[i][j] = input;
            merge(parent, p, input);
        }
    }
    // cout << "input end\n";
    ret = M;
    // cout << "ret = " << ret << "\n";
    for (int i = 0; i < M; i++)
    {
        // cout << "for \n";
        for (int j = 0; j < party[i].size(); j++)
        {
            if (find_p(parent, party[i][j]) == 0)
            {
                // cout << "ret -- " << i << " " << party[i][j] << "\n";
                ret--;
                break;
            }
        }
    }
    cout << ret;
    return 0;
}