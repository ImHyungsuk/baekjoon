#include <iostream>
#include <ctime>

using namespace std;

int main()
{
    clock_t start, finish;
    double dur;
    int N, ret;
    cin >> N;
    start = clock();
    ret = 2;
    while (ret * ret <= N)
        ret++;
    cout << ret - 1 << '\n';
    finish = clock();
    dur = (double)(finish - start) / CLOCKS_PER_SEC;
    cout << dur << "secs\n";

    return 0;
}