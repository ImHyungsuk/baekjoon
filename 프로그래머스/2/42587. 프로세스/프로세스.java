import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            pq.add(priorities[i]);
            q.add(i);
        }
        answer=0;
        int v=pq.peek();
        while(!q.isEmpty()){
            int cur = q.poll();
            if(priorities[cur] == v){
                pq.poll();
                answer++;
                if(cur == location) break;
                v = pq.peek();
            } else q.add(cur);
        }
        return answer;
    }
}

class Task implements Comparable<Task>{
    int num,priority;
    
    public Task(int num,int priority){
        this.num=num;
        this.priority=priority;
    }
    
    @Override
    public int compareTo(Task o){
        if(o.priority==this.priority){
            return this.num-o.num;
        }
        return o.priority-this.priority;
    }
}