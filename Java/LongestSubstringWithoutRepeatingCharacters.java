class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a[] = new int[256];
        int n = s.length();
        int i=0,j=0,ans=0;
        while(i<n && j<n){
            a[(int)s.charAt(i)]++;
            while(a[(int)s.charAt(i)]>1){
                a[(int)s.charAt(j)]--;
                j++;
            }
            ans = Math.max(ans,i-j+1);
            i++;
            //System.out.println(i+" "+j);
        }
        return ans;
    }
}
