import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        ArrayList<Task>arr=new ArrayList<>();
        PriorityQueue<Task> waitQ=new PriorityQueue<>();
        for(int i=0;i<jobs.length;i++){
            arr.add(new Task(i,jobs[i][0],jobs[i][1]));
        }
        arr.sort((o1,o2)->o1.start-o2.start);
        int time=0;
        int idx=0;
        waitQ.add(arr.get(idx++));
        time=waitQ.peek().start;
        while(idx<jobs.length&&time>=arr.get(idx).start) waitQ.add(arr.get(idx++));
        while(!waitQ.isEmpty()){
            Task cur=waitQ.poll();
            if(time<cur.start)time=cur.start;
            System.out.printf("time: %d cur.start: %d\n",time,cur.start);
            time+=cur.time;
            answer+=(time-cur.start);
            System.out.printf("turnaround: %d\n",time-cur.start);
            
            if(waitQ.isEmpty()&&idx<jobs.length&&time<arr.get(idx).start) {
                time=arr.get(idx).start;
                waitQ.add(arr.get(idx++));
            }
            while(idx<jobs.length&&time>=arr.get(idx).start) waitQ.add(arr.get(idx++));
        }
        answer/=jobs.length;
        return answer;
    }
}

class Task implements Comparable<Task>{
    int num,start,time;
    
    public Task(int num, int start, int time){
        this.num=num;
        this.start=start;
        this.time=time;
    }
    
    @Override
    public int compareTo(Task o){
            if(this.time==o.time){
                if(this.start==o.start)
                    return this.num-o.num;
                return this.start-o.start;
            }
            return this.time-o.time;
    }
}