import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        PriorityQueue<Stock>pq=new PriorityQueue<>();
        int t=1,idx=0;
        pq.add(new Stock(prices[0],0));
        while(t<prices.length){
            while(!pq.isEmpty()&&prices[t]<pq.peek().price){
                answer[pq.peek().time]=t-pq.poll().time;
            }
            pq.add(new Stock(prices[t],t));
            t++;
        }
        t--;
        while(!pq.isEmpty()){
            answer[pq.peek().time]=t-pq.poll().time;
        }
        // answer[prices.length-1]--;
        return answer;
    }
}

class Stock implements Comparable<Stock>{
    int price,time;
    
    public Stock(int price, int time){
        this.price=price;
        this.time=time;
    }
    
    @Override public int compareTo(Stock o){
        return o.price-this.price;
    }
}