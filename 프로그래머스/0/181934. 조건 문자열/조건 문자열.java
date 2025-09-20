class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        String str = ineq + eq;
        
        switch (str) {
            case ">=":
                answer = n >= m ? 1 : 0;
                break;
            case ">!":
                answer = n > m ? 1 : 0;
                break;
            case "<=":
                answer = n <= m ? 1 : 0;
                break;
            case "<!":
                answer = n < m ? 1 : 0;
                break;
        }
        
        
        // if(ineq.equals(">")) {
        //     if(eq.equals("=")) {
        //         answer = n >= m ? 1 : 0;
        //     } else {
        //         answer = n > m ? 1 : 0;
        //     }
        // } else {
        //     if(eq.equals("=")) {
        //         answer = n <= m ? 1 : 0;
        //     } else {
        //         answer = n < m ? 1 : 0;
        //     }
        // }
        
        return answer;
    }
}