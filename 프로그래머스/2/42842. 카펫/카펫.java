class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int c=1;
        while(c<=yellow/c){
            if(yellow%c==0){
                int r=yellow/c;
                if((r+2)*2+c*2==brown) {
                    answer[0]=r+2;
                    answer[1]=c+2;
                    break;
                }
            }
            c++;
        }
        return answer;
    }
}