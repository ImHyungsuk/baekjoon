#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);

    int N, M;
    int tmp;
    map<int, int> list;
    vector<int> ret;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> tmp;
        if (list.find(tmp) != list.end())
            list[tmp]++;
        else
            list.insert(make_pair(tmp, 1));
    }
    cin >> M;
    for (int i = 0; i < M; i++)
    {
        cin >> tmp;
        if (list.find(tmp) != list.end())
            ret.push_back(list[tmp]);
        else
            ret.push_back(0);
    }
    for (int i = 0; i < ret.size(); i++)
        cout << ret[i] << ' ';

    return 0;
}