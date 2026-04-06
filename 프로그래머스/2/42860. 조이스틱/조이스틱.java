class Solution {
    public int solution(String name) {
        int answer = 0;
        int len=name.length();
        int max=('Z'-'A');
        int []count=new int[len];
        for(int i=0;i<len;i++){
            char c=name.charAt(i);
            int cnt=c-'A';
            cnt=cnt>max/2?'Z'-c+1:cnt;
            count[i]=cnt;
            answer+=count[i];
        }
        int move=len-1;
        for(int i=1;i<len;i++){
            int tmp=i-1;
            while(i<len&&count[i]==0)i++;
            move=Math.min(move,2*tmp+len-i);
            move=Math.min(move,tmp+2*(len-i));
        }
        answer+=move;
        return answer;
    }
}