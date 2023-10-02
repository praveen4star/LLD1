public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        if(n == 0) return 0;
        int cnt = 1, dir = 0;
        int idx = 0;
        while(idx+1 < n){
            if( A[idx] <= A[idx+1]){
                while(idx+1 < n && A[idx] <= A[idx+1]) idx++;
                idx++;
                cnt++;
            }
            else{
                while(idx+1 < n && A[idx] >= A[idx+1]) idx++;
                idx++;
                cnt++;
            }
        }
        System.out.println(idx+" "+A.length);
        return cnt;

    }
}
