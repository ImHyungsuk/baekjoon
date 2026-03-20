import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int cur=0,idx=0;
        Queue<Integer>waitQ=new ArrayDeque<>();
        Queue<Truck>processQ=new ArrayDeque<>();
        for(int i=0;i<truck_weights.length;i++){
            waitQ.add(truck_weights[i]);
        }
        while(!waitQ.isEmpty()){
            while(!waitQ.isEmpty()&&cur+waitQ.peek()<=weight){
                if(!processQ.isEmpty()&&answer-processQ.peek().time==bridge_length){
                    cur-=processQ.poll().weight;
                }
                int w=waitQ.poll();
                processQ.add(new Truck(w,answer));
                cur+=w;
                answer++;
            }
            if(!processQ.isEmpty()){
                Truck out=processQ.poll();
                answer=out.time+bridge_length;
                cur-=out.weight;                
            }
        }
        while(!processQ.isEmpty()){
            answer=processQ.poll().time+bridge_length;
        }
        return answer;
    }
}

class Truck{
    int weight,time;
    public Truck(int weight, int time){
        this.weight=weight;
        this.time=time;
    }
}