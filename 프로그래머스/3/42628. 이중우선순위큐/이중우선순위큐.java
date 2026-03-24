import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer>maxQ=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer>minQ=new PriorityQueue<>();
        Map<Integer,Integer>count=new HashMap<>();
        for(String op:operations){
            String[]line=op.split(" ");
            if(line[0].equals("I")){
                Integer num=Integer.parseInt(line[1]);
                count.put(num,count.getOrDefault(num,0)+1);
                maxQ.add(num);
                minQ.add(num);
                // System.out.printf("%d in\n",num);
            }else{
                if(maxQ.isEmpty())continue;
                Integer num=Integer.parseInt(line[1]);
                if(num==1){
                    int a=maxQ.poll();
                    count.put(a,count.get(a)-1);
                    // System.out.printf("%d out\n",a);
                }else{
                    int a=minQ.poll();
                    count.put(a,count.get(a)-1);
                    // System.out.printf("%d out\n",a);
                }
            }
            while(!maxQ.isEmpty()&&count.get(maxQ.peek())==0)maxQ.poll();
            while(!minQ.isEmpty()&&count.get(minQ.peek())==0)minQ.poll();
        }
        if(maxQ.isEmpty())answer=new int[]{0,0};
        else{
            answer=new int[2];
            answer[0]=maxQ.peek();
            answer[1]=minQ.peek();
        }
        return answer;
    }
}