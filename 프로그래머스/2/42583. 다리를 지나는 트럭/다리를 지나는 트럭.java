import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck>complete=new ArrayDeque<>();
        Queue<Truck>proceeding =new ArrayDeque<>();
        int idx=1;
        int cur_weight=truck_weights[0];
        proceeding.add(new Truck(truck_weights[0],1));
        answer=1;
        while(!proceeding.isEmpty()){
            answer++;
            Truck tmp=proceeding.peek();
            if(tmp.t==answer-bridge_length){
                // System.out.printf("[Out]time: %d, first.time:%d, index:%d\n",answer,tmp.t,tmp.w);
                proceeding.poll();
                cur_weight-=tmp.w;
            }
            if(idx>=truck_weights.length) continue;
            int cur=truck_weights[idx];
            if(cur+cur_weight<=weight){
                // System.out.printf("[In]time: %d, index:%d, cur_w:%d, max:%d\n",answer,idx,cur+cur_weight,weight);
                proceeding.add(new Truck(cur,answer));
                cur_weight+=cur;
                idx++;
            }
        }
        return answer;
    }
}

class Truck{
    int w, t;
    
    public Truck(int w,int t){
        this.w=w;
        this.t=t;
    }
}