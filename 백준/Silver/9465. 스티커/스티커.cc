    #include<bits/stdc++.h>
    using namespace std;

    int main(){
        int N,T;
        vector<int>ret;
        vector<vector<int>>v,dp;
        cin>>T;
        ret.resize(T,0);
        for(int t=0;t<T;t++){   
            cin>>N;
            v.resize(2); // 바깥 벡터 크기 조절
            for (int i = 0; i < 2; ++i)
                v[i].assign(N, 0); // 안쪽 벡터까지 초기화

            dp.resize(2);
            for (int i = 0; i < 2; ++i)
                dp[i].assign(N, 0);
            for(int i=0;i<2;i++){
                for(int j=0;j<N;j++){
                    cin>>v[i][j];
                }
            }
            if (N==1){
                ret[t]=v[0][0]>v[1][0]?v[0][0]:v[1][0];
                continue;
            }
            dp[0][0]=v[0][0];
            dp[1][0]=v[1][0];
            dp[0][1]=dp[1][0]+v[0][1];
            dp[1][1]=dp[0][0]+v[1][1];
            for(int i=2;i<N;i++){
                int tmp;
                // dp[0][i] = dp[1][i-1] dp[0][i-2] dp[1][i-2]
                tmp=dp[1][i-1]>dp[0][i-2]?dp[1][i-1]:dp[0][i-2];
                tmp=tmp>dp[1][i-2]?tmp:dp[1][i-2];
                dp[0][i]=tmp+v[0][i];

                // dp[1]][i] = dp[0][i-1] dp[0][i-2] dp[1][i-2]
                tmp=dp[0][i-1]>dp[1][i-2]?dp[0][i-1]:dp[1][i-2];
                tmp=tmp>dp[0][i-2]?tmp:dp[0][i-2];
                dp[1][i]=tmp+v[1][i];
            }
            ret[t]=dp[0][N-1]>dp[1][N-1]?dp[0][N-1]:dp[1][N-1];
        }
        for(int t=0;t<T;t++){
            cout<<ret[t]<<"\n";
        }
        return 0;
    }