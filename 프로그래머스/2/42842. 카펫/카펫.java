class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int half=yellow/2;
        for(int i=1;i*i<=yellow;i++){
            if(yellow%i!=0)continue;
            int j=yellow/i;
            int a1=i+2,a2=j+2;
            if(2*a1+2*a2-4==brown){
                answer=new int[]{a2,a1};
                break;
            }
        }
        return answer;
    }
}