#include <iostream>
#include <vector>
#include <ctime>
#define SIZE 1000000

using namespace std;

int main()
{
    int T, tmp;
    clock_t start, finish;
    double dur;
    int *c = new int[SIZE + 1];
    vector<int> ret, N;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> tmp;
        N.push_back(tmp);
    }
    start = clock();
    for (int i = SIZE; i > 1; i--)
    {
        c[i] = i;
        for (int j = 2; i * j < SIZE + 1; j++)
            c[i * j] = 0;
    }
    for (int i = 0; i < T; i++)
    {
        tmp = 0;
        for (int j = 2; j <= N[i] / 2; j++)
        {
            if (c[j] != 0 && c[N[i] - j] != 0)
                tmp++;
        }
        ret.push_back(tmp);
    }
    for (int i = 0; i < T; i++)
        cout << ret[i] << '\n';

    finish = clock();
    dur = (double)(finish - start) / CLOCKS_PER_SEC;
    cout << dur << "secs\n";

    return 0;
}