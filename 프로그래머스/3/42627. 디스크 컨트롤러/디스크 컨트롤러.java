import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        PriorityQueue<Task>waitQ=new PriorityQueue<>();
        ArrayList<Integer>arr=new ArrayList<>();
        int time=0;
        int idx=0;
        int cnt=0;
        while(cnt<jobs.length){
            if(waitQ.isEmpty()&&idx<jobs.length&&time<jobs[idx][0]){
                time=jobs[idx][0];
                waitQ.add(new Task(idx,jobs[idx][0],jobs[idx][1]));
                idx++;
            }
            while(idx<jobs.length&&jobs[idx][0]<=time){
                waitQ.add(new Task(idx,jobs[idx][0],jobs[idx][1]));
                idx++;
            }
            Task cur=waitQ.poll();
            time+=cur.l;
            answer+=time-cur.s;
            cnt++;
        }
        answer/=jobs.length;
        return answer;
    }
}

class Task implements Comparable<Task>{
    int num,s,l;
    public Task(int num,int s, int l){
        this.num=num;
        this.s=s;
        this.l=l;
    }
    
    @Override
    public int compareTo(Task t){
        if(this.l==t.l){
            return this.s-t.s;
        }else{
            return this.l-t.l;
        }
    }
}