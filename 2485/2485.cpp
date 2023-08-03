#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N, tmp = 1000000000;
    int loc[100000];
    vector<int> dis;
    cin >> N;
    cin >> loc[0];
    for (int i = 1; i < N; i++)
    {
        cin >> loc[i];
        dis.push_back(loc[i] - loc[i - 1]);
        tmp = tmp < (loc[i] - loc[i - 1]) ? tmp : (loc[i] - loc[i - 1]);
    }
    while (1)
    {
        int bo = 1;
        for (int i = 0; i < N - 1; i++)
        {
            if (dis[i] % tmp != 0)
            {
                bo = 0;
                break;
            }
        }
        if (bo)
            break;
        tmp--;
    }
    cout << (loc[N - 1] - loc[0]) / tmp - N + 1;

    return 0;
}