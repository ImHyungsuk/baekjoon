import java.util.*;
import java.io.*;

public class Main {
	static String input, bomb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		input = br.readLine();
		bomb = br.readLine();

		int input_len=input.length();
		int bomb_len=bomb.length();

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < input_len; i++) {
			int count = 0;
			st.push(input.charAt(i));
			if (st.size() >= bomb_len && input.charAt(i) == bomb.charAt(bomb_len - 1)) {
				for (int j = 0; j < bomb_len; j++) {
					if (st.get(st.size() - bomb_len + j) == bomb.charAt(j)) {
						count++;
					}
					if (count == bomb_len) {
						for (int k = 0; k < bomb_len; k++) {
							st.pop();
						}
					}
				}
			}
		}

		if(st.empty()){
			System.out.println("FRULA");
		}else{
			for(char ch:st){
				sb.append(ch);
			}
			System.out.println(sb);
		}
	}
}