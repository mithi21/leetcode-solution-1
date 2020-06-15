

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(){
        System.out.println("Empty Node created");
    }
    public Node(int value){

        this.value = value;
    }

    public void set_value(int value){
        this.value = value;
    }

    public int get_value(){
        return this.value;
    }
    
    public void set_left_child(Node left){
        this.left = left;
    }

    public Node get_left_child(){
        return this.left;
    }

    public void set_right_child(Node right){
        this.right = right;
    }
    public Node get_right_child(){
        return this.right;
    }

    public boolean has_left_child(){
       return this.left != null;
    }
    public boolean has_right_child(){
        return this.right != null;
    }

    public void __repr__(){
        System.out.println(this.value);
    }

}