class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val-b.val;
            }
        });
        ListNode head=new ListNode(), ans = head;
        for(ListNode n:lists){
            if(n!=null) pq.add(n);
        }
        while(!pq.isEmpty()){
            ListNode n = pq.remove();
            if(n.next!=null) pq.add(n.next);
            head.next = n;
            head = head.next;
        }
        return ans.next;
    }
}
