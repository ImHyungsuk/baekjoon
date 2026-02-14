import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[]answer={};
        ArrayList<Integer> arr = new ArrayList<>();
        int[]scores=new int[3];
        int[][]students={
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        for(int i=0;i<answers.length;i++){
            for(int j=0;j<3;j++){
                int len=students[j].length;
                if(answers[i]==students[j][i%len]) scores[j]++;
            }
        }
        int max=0;
        for(int j=0;j<3;j++){
            if(max<scores[j]){
                max=scores[j];
                arr.clear();
                arr.add(j);
            }else if(max==scores[j]) arr.add(j);
        }
        answer=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            answer[i]=arr.get(i)+1;
        }
        return answer;
    }
}