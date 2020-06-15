import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Tree {
    private Node root;

    public Tree(){
        this.root  =null;
    }
    
    public Tree(int value){
        this.root = new  Node(value);
    }

    public Node get_root(){
        return this.root;
    }

    // public static HashSet<Node> pre_order_recursive(Node root){
    //     HashSet<Node> visited = new HashSet<>();
        
    //     return recursive_helper(root, visited);

    // }
    // public static HashSet<Node> recursive_helper(Node root,HashSet<Node> visited){
        
    //     if (root != null){
    //         visited.add(root);
    //         recursive_helper(root.get_left_child(), visited);
    //         recursive_helper(root.get_right_child(), visited);
    //     }
    //     return visited;
        
    // }

    
    public static HashSet<Node> pre_Order_Traversal(_IterativeNode root){
        return new HashSet<>();
    }


    public static HashSet<Node> in_Order_Traversal_iterative(Node root){
        return new HashSet<>();
    }


    public static HashSet<Node> post_Order_Traversal_iterative(Node root){
        return new HashSet<>();
    }


    
    public static void main(String[] args) {

    //     4
    //  31     10
    //      41
        Tree tree =  new Tree(4);
        Node root = tree.get_root();
        Node node2= new Node(10);
        Node node4= new Node(41);
        Node node3= new Node(31);
        root.set_left_child(node3);
        root.set_right_child(node2);
        node3.set_right_child(node4);

        

        // for(Node node : pre_order){
        //     System.out.println(node.get_value());
        // }
        

    }
}