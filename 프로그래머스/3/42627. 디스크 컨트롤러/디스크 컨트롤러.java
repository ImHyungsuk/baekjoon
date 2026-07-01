import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        ArrayList<Job>list=new ArrayList<>();
        for(int i=0;i<jobs.length;i++){
            list.add(new Job(i,jobs[i][0],jobs[i][1]));
        }
        list.sort((j1,j2)->j1.arrive-j2.arrive);
        PriorityQueue<Job>pq=new PriorityQueue<>((j1,j2)->{
            if(j1.time==j2.time){
                if(j1.arrive==j2.arrive) 
                    return j1.num-j2.num;
                return j1.arrive-j2.arrive;
            }
            return j1.time-j2.time;
        });
        int idx=0;
        int t=list.get(idx).arrive;
        while(idx<jobs.length||!pq.isEmpty()){
            while(idx<jobs.length&&list.get(idx).arrive<=t){
                pq.add(list.get(idx++));
            }
            if(pq.isEmpty()){
                t=list.get(idx).arrive;
                continue;
            }
            
            Job cur=pq.poll();
            t+=cur.time;
            // System.out.printf("num:%d, t: %d, arrive: %d\n",cur.num, t, cur.arrive);
            answer+=(t-cur.arrive);
        }
        answer/=jobs.length;
        return answer;
    }
}

class Job{
    int num, arrive, time;
    Job(int num,int arrive, int time){
        this.num=num;
        this.arrive=arrive;
        this.time=time;
    }
}