class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer += dfs(numbers, 0, target, 0);
        return answer;
    }
    
    static int dfs(int[] numbers, int idx, int target, int result){
        int sum = 0;
        if(idx == numbers.length) {
            if(result == target) {
                return 1;
            } else return 0;
        }
        sum += dfs(numbers, idx + 1, target, result + numbers[idx]);
        sum += dfs(numbers, idx + 1, target, result - numbers[idx]);
        
        return sum;
    }
}