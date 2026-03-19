import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Task>q=new ArrayDeque<>();
        
        int l=priorities.length;
        for(int i=0;i<l;i++){
            pq.add(priorities[i]);
            q.add(new Task(i,priorities[i]));
        }
        while(!pq.isEmpty()){
            int cur_p=pq.poll();
            while(q.peek().p!=cur_p){
                q.add(q.poll());
            }
            answer++;
            if(location==q.poll().num) break;
        }
        return answer;
    }
}

class Task{
    int num,p;
    public Task(int num,int p){
        this.num=num;
        this.p=p;
    }
}