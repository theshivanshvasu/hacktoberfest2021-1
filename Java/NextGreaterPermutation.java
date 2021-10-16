class Solution {
    public boolean isDescending(int a[], int n){
        for(int i=0;i<n-1;i++){
            if(a[i]<a[i+1]) return false;
        }
        return true;
    }
    
    public boolean isAscending(int a[], int n){
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1]) return false;
        }
        return true;
    }
    
    public void nextPermutation(int[] a) {
        int n = a.length;
        if(isDescending(a,n)){
            Arrays.sort(a);
        }
        else if(isAscending(a,n)){
            int t = a[n-1];
            a[n-1] = a[n-2];
            a[n-2] = t;
        }
        else{
            int i1=0;
            for(int i=n-2;i>=0;i--){
                if(a[i]<a[i+1]){
                    i1 = i;
                    break;
                }
            }
            int i2=i1+1;
            for(int i=i1+1;i<n;i++){
                if(a[i]>a[i1] && a[i]<=a[i2]){
                    i2=i;
                }
            }
            int t=a[i1];
            a[i1]=a[i2];
            a[i2] = t;
            Arrays.sort(a,i1+1,n);
        }
        return;
    }
}
