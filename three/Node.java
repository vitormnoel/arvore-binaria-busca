package three;

/**
 *
 * @author Vitor Manoel
 */
public class Node {
    private int element;
    private Node right;
    private Node left;
    private Node parent;
            
    public Node(int element){
        this.element = element;
        this.right = null;
        this.left = null;
        this.parent = null;
    }
    
    public Node(int element, Node right, Node left, Node parent){
        this.element = element;
        this.right = right;
        this.left = left;
        this.parent = parent;
    }

    public boolean hasOnlyLeftCHild(){
        return this.getLeft() == null && this.getRight() !=null;
    }
    
    public boolean hasOnlyRightChild(){
        return this.left == null && this.getRight() != null;
    }
    
    public boolean isLeaf(){
        return this.getLeft() == null && this.getRight() == null;
    }
    
    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getElement() {
        return element;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    
    
}
