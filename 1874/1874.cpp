#include <iostream>
#include <stack>

using namespace std;

int main()
{
    int n, tmp1;
    // 수열은 st1에, st2는 정렬할 때 활용할 빈 스택
    stack<int> st1, st2;
    stack<char> ret;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        // 입력받는 수열을 st1에 push
        cin >> tmp1;
        st1.push(tmp1);
    }
    // 주어진 수열을 빈 스택에 push, pop을 하여 내림차순으로 정렬하기
    // 정렬하는 과정에서 st2를 기준으로 행해지는 push, pop 연산을
    // 역으로 바꿔주면 문제의 해답이 됨
    for (int i = n; i > 0; i--)
    {
        // st1이 비지 않고 st2의 top이 정렬할 차례인 숫자 일 때까지
        while (!st1.empty())
        {
            // while문 조건에 st2.top()!=i를 넣었을 때 segfault 발생
            // 처음엔 비어있기 때문에 발생할거라 판단해서 if문으로 바꿈
            if (!st2.empty() && st2.top() == i)
                break;
            st2.push(st1.top());
            st1.pop();
            ret.push('-');
            // cout << "push -\n";
        }
        // 첫 try에서 segfault가 떴는데
        // 예시는 잘 모르겠으나 st2가 비어있는 상태에서
        // st2.top()을 쓰면 segfault의 가능성이 있을거라 판단
        // 하지만 2번째 try에서도 segfault 발생
        if (!st2.empty() && st2.top() == i)
        {
            st2.pop();
            ret.push('+');
            // cout << "push +\n";
        }
        else
        {
            cout << "NO";
            return 0;
        }
    }
    while (!ret.empty())
    {
        cout << ret.top() << '\n';
        ret.pop();
    }

    return 0;
}