public class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s.length()*2+2);
        sb.append("$#");
        for (int i=0; i<s.length(); i++) {
            sb.append(s.substring(i, i+1));
            sb.append("#");
        }
        String t = sb.toString();
        int mx = 0;
        int id = 0;
        int[] mp = new int[t.length()];
        for (int i=0; i<t.length(); i++) {
            mp[i] = mx>i ? Math.min(mp[2*id-i], mx-i) : 1;
            while (i+mp[i]<t.length() && i-mp[i]>=0 && t.charAt(i+mp[i]) == t.charAt(i-mp[i])) mp[i]++;
            if (i+mp[i]>mx) {
                mx = i + mp[i];
                id = i;
            }
        }
        int longest = 0, p = 0;
        for (int i=0; i<t.length(); i++) {
            if (mp[i]>longest) {
                p = i;
                longest = mp[i];
            }
        }
        longest--;
        sb = new StringBuilder(longest);
        for (int i=p-longest; i<p+longest; i++) {
            if (t.charAt(i)!='#' && t.charAt(i)!='$') sb.append(t.charAt(i));
        }
        return sb.toString();
    }
}