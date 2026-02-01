// tip: each public class is put in its own file
import java.util.*;
import java.io.*;
public class Main {
    // tip: arguments are passed via the field below this editor
    static long a, b;
    static long [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        dp = new long[55];
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            dp[i] = dp[i-1]*2+(long)Math.pow(2,i);
        }
        long result=calOne(b)-calOne(a-1);
        System.out.println(result);
    }

    static long calOne(long n){
        int size=(int)(Math.log(n)/Math.log(2));
        long cnt=n&1;
        for(int i=size;i>0;i--){
            if((n&(1L<<i))!=0){
                cnt+=dp[i-1]+(n-(1L<<i)+1);
                n-=(1L<<i);
            }
        }
        return cnt;
    }
}