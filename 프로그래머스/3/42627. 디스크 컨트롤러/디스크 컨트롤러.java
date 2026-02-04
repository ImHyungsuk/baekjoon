import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job>pq=new PriorityQueue<>();
        ArrayList<Job>arr=new ArrayList<>();
        int idx=0,time=0;
        while(idx<jobs.length){
            arr.add(new Job(idx,jobs[idx][0],jobs[idx][1]));
            idx++;
        }
        arr.sort(new Comparator<Job>(){
            @Override
            public int compare(Job o1, Job o2){
                return o1.time-o2.time;
            }
        });
        idx=0;
        while(idx<arr.size() || !pq.isEmpty()){
            while(idx<arr.size() && time>=arr.get(idx).time){
                pq.add(arr.get(idx++));
            }
            if(!pq.isEmpty()){
                Job w= pq.poll();
                time+=w.amount;
                answer+=time-w.time;
            }else {
                time=arr.get(idx).time;
            }
        }
        answer/=jobs.length;
        return answer;
    }
}

class Job implements Comparable<Job>{
    int num,time,amount;
    public Job(int num, int time, int amount){
        this.num=num;
        this.time=time;
        this.amount=amount;
    }
    
    @Override
    public int compareTo(Job o){
        if(this.amount==o.amount){
            if(this.time==o.time)
                return this.num-o.num;
            return this.time-o.time;
        }
        return this.amount-o.amount;
    }
}