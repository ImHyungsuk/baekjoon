class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int len=number.length()-k;
        int idx=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<number.length();i++){
            char c=number.charAt(i);
            while(k>0 && sb.length()>0 && sb.charAt(sb.length()-1)<c){
                k--;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c);
        }
        return sb.substring(0,len);
    }
}