#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int T, a, b;
    vector<int> A, B, ret;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> a >> b;
        A.push_back(a);
        B.push_back(b);
    }
    for (int i = 0; i < T; i++)
    {
        int big, small;
        if (A[i] > B[i])
        {
            big = A[i];
            small = B[i];
        }
        else
        {
            big = B[i];
            small = A[i];
        }
        int j = 1;
        while (1)
        {
            int tmp2 = big * j;
            if (tmp2 % small == 0)
            {
                ret.push_back(tmp2);
                break;
            }
            j++;
        }
    }
    for (int i = 0; i < T; i++)
        cout << ret[i] << '\n';

    return 0;
}