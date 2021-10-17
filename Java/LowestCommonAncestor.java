import java.util.HashSet;

class LowestCommonAncestor {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public int findLca(TreeNode node1, TreeNode node2) {
        HashSet<Integer> visitedNodes = new HashSet<>();
        while(node1 != null) {
            visitedNodes.add(node1.data);
            node1 = node1.parent;
        }

        while(node2 != null) {
            if(visitedNodes.contains(node2.data)) {
                return node2.data;
            }
            node2 = node2.parent;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        
        node1.left = node2;
        node2.parent = node1;
        node1.right = node5;
        node5.parent = node1;

        node2.left = node3;
        node3.parent = node2;
        node2.right = node4;
        node4.parent = node2;

        node5.left = node6;
        node6.parent = node5;
        node5.right = node7;
        node7.parent = node5;

        node6.left = node8;
        node8.parent = node6;

        System.out.println("Fetching Lowest Common Ancestor (LCA)");
        LowestCommonAncestor lca = new LowestCommonAncestor();

        System.out.println("LCA for Node 2 and Node 6 is Node " + lca.findLca(node2, node6));
        System.out.println("LCA for Node 7 and Node 8 is Node " + lca.findLca(node7, node8));
        System.out.println("LCA for Node 3 and Node 4 is Node " + lca.findLca(node3, node4));
        System.out.println("LCA for Node 1 and Node 8 is Node " + lca.findLca(node1, node8));
    }
}