#include <iostream>
#include <string>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    double scr = 0, sum = 0;
    string sub, sc;
    double a;
    for (int i = 0; i < 20; i++)
    {
        cin >> sub >> a >> sc;

        if (sub == "")
            break;
        if (sc == "P")
            continue;
        else if (sc == "A+")
            scr += 4.5 * a;
        else if (sc == "A0")
            scr += 4.0 * a;
        else if (sc == "B+")
            scr += 3.5 * a;
        else if (sc == "B0")
            scr += 3.0 * a;
        else if (sc == "C+")
            scr += 2.5 * a;
        else if (sc == "C0")
            scr += 2.0 * a;
        else if (sc == "D+")
            scr += 1.5 * a;
        else if (sc == "D0")
            scr += 1.0 * a;
        sum += a;
    }
    scr /= sum;
    cout << scr;

    return 0;
}