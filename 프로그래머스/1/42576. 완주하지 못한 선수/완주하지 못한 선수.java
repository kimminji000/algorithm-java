import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String , Integer> runners = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++) {
            runners.compute(participant[i], (k, v) -> v == null ? 1 : v + 1);
        }
        
        for(int i = 0; i < completion.length; i++) {
            runners.compute(completion[i], (k, v) -> v == 1 ? null : v - 1);
        }
        
        String answer = runners.keySet().iterator().next();
        
        return answer;
    }
}