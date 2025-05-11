import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    final static long mod = 1000000007;
    public static long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[][] A = {{1, 1}, {1, 0}};

        System.out.println(procession_pow(n - 1, A)[0][0]);
    }

    public static long[][] procession_pow(long n, long[][] A) {
        if (n == 1 || n == 0) {
            return A;
        }
        long[][] ret = procession_pow(n / 2, A);
        ret = procession_multiply(ret, ret);
        if (n % 2 == 1) {
            ret = procession_multiply(ret, origin);
        }
        return ret;
    }

    public static long[][] procession_multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];
        ret[0][0] = (o1[0][0] * o2[0][0] + o1[0][1] * o2[1][0]) % mod;
        ret[0][1] = (o1[0][0] * o2[0][1] + o1[0][1] * o2[1][1]) % mod;
        ret[1][0] = (o1[1][0] * o2[0][0] + o1[1][1] * o2[1][0]) % mod;
        ret[1][1] = (o1[1][0] * o2[0][1] + o1[1][1] * o2[1][1]) % mod;

        return ret;
    }
}