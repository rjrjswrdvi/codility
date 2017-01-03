/*https://codility.com/programmers/task/winter_lights/*/
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
	Map<String, Boolean> map = new HashMap<String,Boolean>();
	public int solution(String S) {
		// write your code in Java SE 8
		long ct = S.length();
		String sub = null;
		int len = S.length();
		if(len == 1) return 1;

		int dcount = 0;
		int[] d = {0,1,2,3,4,5,6,7,8,9};
		for(int i=0;i<10;i++){
			if(S.indexOf(d[i]+"")>-1)dcount++;
		}
		if(dcount == 1){ return (len*(len+1)/2);}
		for(int l = 1;l<len;l++){
			for(int pos = 0;pos<len-l;pos++){
				sub = S.substring(pos,pos+l+1);
				boolean val;
				if(map.containsKey(sub)){
					ct++;
				}
				else{
					val = isPallindrome(sub);
					if(val){
						ct++;
						map.put(sub, val);
					}
				}
			}
		}

		return (int)ct%1000000007;

	}
	private boolean isPallindrome(String sub) {
		StringBuilder sb = new StringBuilder();
		sb.append(sub);
		if(sub.equals(sb.reverse().toString())) return true;

		int count[] = new int[10];
		int c = 0;
		char[] a = sub.toCharArray();
		while (c<a.length) {
			count[Integer.valueOf(a[c]+"")-0]++;
			c++;
		}
		int oddCt = 0;
		for(int i=0;i<10;i++){
			if(count[i]%2 !=0 ) oddCt++;
		}
		if(oddCt>1) return false;

		return true;
	}

	private void print(String sub) {
		// 	System.out.println(sub);

	}

//	public static void main(String[] a){
//		Solution s = new Solution();
//		String str = "0200202002020020200202002020020200202002020020200202002020020200202002020020200202002020020200202002";
//		Instant start = Instant.now();
//		System.out.println(s.solution(str));
//		Instant end = Instant.now();
//		System.out.println(str.length() + " "+ Duration.between(start, end));
//	}
}