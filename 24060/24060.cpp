#include "bits/stdc++.h"
using namespace std;

int result = -1;
int cnt = 0;
int N;

void merge(int A[], int p, int q, int r, int K)
{
    int i, j, k, tmp[50000];
    i = p;
    j = q + 1;
    k = 1;
    while (i <= q && j <= r)
    {
        if (A[i] > A[j])
            tmp[k++] = A[j++];
        else
            tmp[k++] = A[i++];
    }
    while (i <= q)
        tmp[k++] = A[i++];
    while (j <= r)
        tmp[k++] = A[j++];
    i = p;
    k = 1;
    while (i <= r)
    {
        A[i++] = tmp[k++];
        cnt++;
        if (cnt == K)
            result = tmp[k - 1];
    }
}

int mergesort(int A[], int p, int r, int K)
{
    int q;
    if (p < r)
    {
        q = (p + r) / 2;
        mergesort(A, p, q, K);
        mergesort(A, q + 1, r, K);
        merge(A, p, q, r, K);
    }
    return cnt;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int K, tmp, cnt;
    int A[50000];
    cin >> N >> K;
    for (int i = 0; i < N; i++)
    {
        cin >> A[i];
    }
    mergesort(A, 0, N - 1, K);
    cout << result;

    return 0;
}