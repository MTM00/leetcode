package LongestSubstring;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s.isEmpty())
			return 0;
		int first = 0;
		int last = 0;
		int length = 1;
		for(int i = 1; i < s.length(); i++) {
			for(int j = first; j <= last ; j++) {
				if(s.charAt(i) == s.charAt(j)) {			
					length = length < last - first + 1?last - first + 1:length;
					first = j + 1;
				}
			}
			last = i;
		}
		length = length < last - first + 1?last - first + 1:length;
		return length;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int length = s.lengthOfLongestSubstring("sqefsqern");
		System.out.println(length);
	}
}
