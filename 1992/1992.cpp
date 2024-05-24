#include "bits/stdc++.h"

using namespace std;
int arr[65][65];
string video[64];
vector<int> v;
string str = "";
int n = 0;
int N;

void quadtree(int N, int x, int y)
{
    char curr = video[y][x];
    for (int i = y; i < y + N; i++)
    {
        for (int j = x; j < x + N; j++)
        {
            if (video[i][j] != curr)
            {
                cout << "(";
                quadtree(N / 2, x, y);
                quadtree(N / 2, x + N / 2, y);
                quadtree(N / 2, x, y + N / 2);
                quadtree(N / 2, x + N / 2, y + N / 2);
                cout << ")";
                return;
            }
        }
    }
    cout << curr;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> video[i];
    }
    quadtree(N, 0, 0);
    return 0;
}