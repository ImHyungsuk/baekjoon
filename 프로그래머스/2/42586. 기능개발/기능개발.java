import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int len=progresses.length;
        ArrayList<Integer>arr=new ArrayList<>();
        Queue<Task>q=new ArrayDeque<>();
        for(int i=0;i<len;i++){
            q.add(new Task(progresses[i],i));
        }
        while(!q.isEmpty()){
            Task cur=q.peek();
            int days=(100-cur.prog)/speeds[cur.index];
            days=((100-cur.prog)%speeds[cur.index]==0)?days:days+1;
            for(Task t:q){
                if(t.prog<100)
                    t.proceed(days*speeds[t.index]);
            }
            int cnt=0;
            while(cur.prog>=100){
                q.poll();
                cnt++;
                if(q.isEmpty()) break;
                cur=q.peek();
            }
            arr.add(cnt);
        }
        answer=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            answer[i]=arr.get(i);
        }
        return answer;
    }
}

class Task{
    int prog,index;
    public Task(int prog,int index){
        this.prog=prog;
        this.index=index;
    }
    public void proceed(int amount){
        this.prog+=amount;
    }
}