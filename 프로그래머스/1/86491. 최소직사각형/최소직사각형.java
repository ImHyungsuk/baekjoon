import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int c=sizes[0][1],r=sizes[0][0],len=sizes.length;
        answer=c*r;
        for (int i=1;i<len;i++){
            if(sizes[i][0]<=r&&sizes[i][1]<=c) continue;
            if(sizes[i][0]<=c&&sizes[i][1]<=r) continue;
            int[] tmp_c=new int[2];
            int[] tmp_r=new int[2];
            int[] tmp_ans=new int[2];
            
            for(int j=0;j<2;j++){
                tmp_r[j]=Math.max(r,sizes[i][j]);
                tmp_c[j]=Math.max(c,sizes[i][1-j]);
                tmp_ans[j]=tmp_c[j]*tmp_r[j];
            }
            if(tmp_ans[0]<tmp_ans[1]){
                c=Math.max(c,tmp_c[0]);
                r=Math.max(r,tmp_r[0]);
                answer=tmp_ans[0];
            }else{
                c=Math.max(c,tmp_c[1]);
                r=Math.max(r,tmp_r[1]);
                answer=tmp_ans[1];
            }
        }
        return answer;
    }
}