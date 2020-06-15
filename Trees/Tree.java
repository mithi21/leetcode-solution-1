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

    public static HashSet<Node> pre_order_recursive(Node root){
        HashSet<Node> visited = new HashSet<>();
        
        return recursive_helper(root, visited);

    }
    public static HashSet<Node> recursive_helper(Node root,HashSet<Node> visited){
        
        if (root != null){
            visited.add(root);
            recursive_helper(root.get_left_child(), visited);
            recursive_helper(root.get_right_child(), visited);
        }
        return visited;
        
    }
    public static HashSet<Node> pre_Order_Traversal(Node root){
        HashSet<Node> visited = new HashSet<>();
        Stack<Node> stack =  new Stack<Node>();
        stack.push(root);
        
        while( !stack.isEmpty()){
            Node node = stack.pop();
            visited.add(node);
            if(node.has_left_child() && !visited.contains(node.get_left_child())){
                stack.push(node.get_left_child());
            }
            if(node.has_right_child() && !visited.contains(node.get_right_child())){
                stack.push(node.get_right_child());
            }

            
        }
        return visited;
    }

    
    public static void main(String[] args) {
        Tree tree =  new Tree(4);
        Node root = tree.get_root();
        Node node2= new Node(10);
        Node node4= new Node(41);
        Node node3= new Node(31);
        root.set_left_child(node3);
        root.set_right_child(node2);
        node3.set_right_child(node4);

        HashSet<Node> pre_order = Tree.pre_Order_Traversal(root);
        pre_order = pre_order_recursive(root);

        for(Node node : pre_order){
            System.out.println(node.get_value());
        }

    }
}