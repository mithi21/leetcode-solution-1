/**
|  0 |   |   |   |   |
|---|---|---|---|---|
| 0,0  |   |   |   |   | snap id 0 index 0 value 0
| 0,5  |   |   |   |   | snapId 0 index 0 value 5
| 0,6 |   |   |   |   | snapId 1 index 0 value 6



**/


class Node implements Comparable<Node> {
    
    int maxSnapId;
    int value;
    
    Node(int snapId, int val) {
        this.maxSnapId =  snapId;
        this.value = val;
        
    }
    
    Node(int snap) {
        this.maxSnapId = snap;
    }
    
    
    @Override
    public int compareTo(Node n1) {
        return Integer.compare(this.maxSnapId, n1.maxSnapId);
    }
    
}

class SnapshotArray {
    
    
    ArrayList<ArrayList<Node>> snaps;
    int maxSnaps;
    
    

    public SnapshotArray(int length) {
        snaps = new ArrayList();
        maxSnaps = 0;
        for (int i =0;i< length;i ++) {
            ArrayList<Node> nodeList = new ArrayList();
            nodeList.add(new Node(maxSnaps, 0));
            snaps.add(nodeList);
        }
        
    }
    
    public void set(int index, int val) {
        
//          if index not present then add
        Node newNode = new Node(maxSnaps, val);
        List<Node> nodeList = snaps.get(index);
        if(nodeList.get(nodeList.size()-1).maxSnapId != maxSnaps) {
            nodeList.add(newNode);
        }else{
            nodeList.get(nodeList.size()-1).value = val;
        }
        
        
    }
    
    public int snap() {
        maxSnaps++;
        return maxSnaps -1;
        
    }
    
    public int get(int index, int snap_id) {
        int x = Collections.binarySearch(snaps.get(index), new Node(snap_id));
        if(x<0) {
            
            x = Math.abs(x)-2;
        }
        return snaps.get(index).get(x).value;
        
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
