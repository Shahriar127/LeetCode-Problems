import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOf(String s) {
        int n = s.length();
        int left = 0;
        Set<Character> st = new HashSet<>();
        int mxLength = 0;
        for (int right = 0; right < n; right++) {
            if (!st.contains(s.charAt(right))) {
                st.add(s.charAt(right));
                mxLength = Math.max(mxLength, right - left + 1);
            } else {
                while (st.contains(s.charAt(right))) {
                    st.remove(s.charAt(left));
                    left++;
                }
                st.add(s.charAt(right));
            }
        }
        return mxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();  // Create an object to call the non-static method
        int result = obj.lengthOf(s);
        System.out.println(result);
    }
}
