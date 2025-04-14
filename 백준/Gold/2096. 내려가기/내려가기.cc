#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, max = 0, min = 1000001;
    vector<int> v;
    queue<pair<int, int>> q;
    int min_tmp[3];
    int max_tmp[3];
    cin >> N;
    v.resize(N, 3);
    cin >> v[0] >> v[1] >> v[2];
    for (int j = 0; j < 3; j++)
    {
        min_tmp[j] = v[j];
        max_tmp[j] = v[j];
    }
    for (int i = 1; i < N; i++)
    {
        cin >> v[0] >> v[1] >> v[2];
        // cout << min_tmp[0] << "/" << max_tmp[0] << " " << min_tmp[1] << "/" << max_tmp[1] << " " << min_tmp[2] << "/" << max_tmp[2] << "\n";
        min_tmp[0] = min_tmp[0] < min_tmp[1] ? min_tmp[0] : min_tmp[1];
        min_tmp[2] = min_tmp[1] < min_tmp[2] ? min_tmp[1] : min_tmp[2];
        min_tmp[1] = min_tmp[0] < min_tmp[2] ? min_tmp[0] : min_tmp[2];
        max_tmp[0] = max_tmp[0] > max_tmp[1] ? max_tmp[0] : max_tmp[1];
        max_tmp[2] = max_tmp[1] > max_tmp[2] ? max_tmp[1] : max_tmp[2];
        max_tmp[1] = max_tmp[0] > max_tmp[2] ? max_tmp[0] : max_tmp[2];
        for (int j = 0; j < 3; j++)
        {
            min_tmp[j] += v[j];
            max_tmp[j] += v[j];
        }
    }
    for (int j = 0; j < 3; j++)
    {
        min = min < min_tmp[j] ? min : min_tmp[j];
        max = max > max_tmp[j] ? max : max_tmp[j];
        q.pop();
    }
    cout << max << " " << min;
    return 0;
}