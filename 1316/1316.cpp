#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    string a;
    int alp[27] = {
        0,
    };
    int N, cnt = 0;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> a;
        int j = 0;
        while (a[j])
        {
            if (alp[a[j] - 97] == 1)
                break;
            else
            {
                if (a[j] != a[j + 1])
                    alp[a[j] - 97] = 1;
            }
            if (a[j + 1] == '\0')
                cnt++;
            j++;
        }
        for (j = 0; j < 27; j++)
            alp[j] = 0;
    }
    cout << cnt;
    return 0;
}