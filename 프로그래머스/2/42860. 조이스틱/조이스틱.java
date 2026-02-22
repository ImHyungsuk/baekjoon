class Solution {
    public int solution(String name) {
        int answer = 0;
        int len=name.length();
        int[]count=new int[len];
        int[]parents=new int[len];
        for(int i=0;i<len;i++){
            parents[i]=i;
            char c=name.charAt(i);
            if((c-'A')>('Z'-'A')/2) count[i]='Z'-c+1;
            else count[i]=c-'A';
            answer+=count[i];
        }
        int move=len-1;
        for(int i=0;i<len;i++){
            int next=i+1;
            while(next<len&&count[next]==0){
                next++;
            }
            move=Math.min(move,2*i+(len-next));
            move=Math.min(move,i+2*(len-next));
        }
        answer+=move;
        
        
        return answer;
    }
}