#include <iostream>
#include <vector>

using namespace std;

int main()
{
    // ios_base::sync_with_stdio(false);
    int T;
    unsigned int n;
    vector<unsigned int> tmp;
    vector<long long> ret;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> n;
        tmp.push_back(n);
    }
    for (int i = 0; i < T; i++)
    {
        if (tmp[i] < 2)
        {
            ret.push_back(2);
            continue;
        }
        while (1)
        {
            // cout << "increase tmp\n";
            int key = 1;
            for (int j = 2; j * j <= tmp[i]; j++)
            {
                // cout << "check " << tmp[i] << " " << j << '\n';
                if (tmp[i] % j == 0)
                {
                    key = 0;
                    break;
                }
            }
            if (key)
            {
                ret.push_back(tmp[i]);
                break;
            }
            tmp[i]++;
        }
    }
    for (int i = 0; i < T; i++)
        cout << ret[i] << '\n';

    return 0;
}