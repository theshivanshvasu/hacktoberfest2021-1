class Solution {
    int prevmax=0,m_i=0,m_j=0;
    public String longestPalindrome(String s) {
        
        int n = s.length();
        for(int i=0;i<n;i++){
            calc(i,i,s,n);
            calc(i,i+1,s,n);
        }
        
        
    System.out.println(m_i+" "+m_j);
        return s.substring(m_i,m_j+1);
    }
    
    public void calc(int i, int j, String s, int n){
        while(i>-1 && j<n && s.charAt(i)==s.charAt(j)){
            if(j-i+1>prevmax){
                prevmax = j-i+1;
                m_i=i;
                m_j=j;
            }
            i--;
            j++;
        }        
    }
}
