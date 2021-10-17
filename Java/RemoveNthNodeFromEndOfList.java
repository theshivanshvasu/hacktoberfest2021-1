class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode n1=head, n2 = head;
        
        for(int i=1;i<=n;i++) n1=n1.next;
        if(n1==null) return head.next;
        n1 = n1.next;
        while(n1!=null){
            n1 = n1.next;
            n2 = n2.next;
        }
        n2.next=n2.next.next;
        return head;
    }
}
