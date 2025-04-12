/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null ; 
        if(node.neighbors.isEmpty()) return new Node(node.val); 
        HashMap<Node , Node> mpp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        mpp.put(node , new Node(node.val)) ; 
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node adjNode : curr.neighbors){
                if(!mpp.containsKey(adjNode)){
                    mpp.put(adjNode , new Node(adjNode.val)); 
                    q.offer(adjNode); 
                }
                mpp.get(curr).neighbors.add(mpp.get(adjNode)); 
            }
        }
        return mpp.get(node); 
    }
}