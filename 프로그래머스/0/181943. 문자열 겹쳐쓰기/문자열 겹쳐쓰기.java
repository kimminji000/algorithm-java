import java.util.*;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();
        
        // for(int i = 0; i < s; i++) {
        //     sb.append(my_string.charAt(i));
        // }        
        // for(int i = 0; i < overwrite_string.length(); i++) {
        //     sb.append(overwrite_string.charAt(i));
        // }        
        // for(int i = s + overwrite_string.length(); i < my_string.length(); i++) {
        //     sb.append(my_string.charAt(i));
        // }
        
        sb.append(my_string.substring(0, s));
        sb.append(overwrite_string);
        sb.append(my_string.substring(s + overwrite_string.length()));
        
        String answer = sb.toString();
        return answer;
    }
}