package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Vitor Manoel
 */
public class Three {
    private Node root;
    private int size;
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void adiciona(int element){
        size += 1;
        if(isEmpty()){
            System.out.println("Árvore vazia, primeiro elemento adicionado.");
            this.root = new Node(element);
        }else{
            
            Node aux = this.root;
            
            while(aux !=null){
                if(element < aux.getElement()){
                    if(aux.getLeft() == null){
                        System.out.println("Elemento adicionado a esquerda!");
                        Node newNode = new Node(element);
                        aux.setLeft(newNode);
                        newNode.setParent(aux);
                        return;
                    }
                    
                    aux = aux.getLeft();
                }else{
                    if(aux.getRight() == null){
                        System.out.println("Elemento adicionado a direita!");
                        Node newNode = new Node(element);
                        aux.setRight(newNode);
                        newNode.setParent(aux);
                        return;
                    }
                    
                    aux = aux.getRight();
                }
            }
        }
    }
    
    public Node search(int element){
        Node aux = this.root;
        
        try{
            while(aux != null){
            if(aux.getElement() == element) {
                System.out.println("> Elemento "+aux.getElement()+" encontrado!");    
                return aux;
            }
            if(element < aux.getElement()) aux = aux.getLeft();
            
            if(element > aux.getElement()) aux = aux.getRight();
        }
        }catch(Exception e){
            System.out.println(">> Elemento não encontrado. :/ ERRO: "+e);
        }
        return null;
    }
    
    public int height(Node node){
        if(node == null) return -1;
        else return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
    
    public void remove(int value){
        Node toRemove = search(value);
        if(toRemove != null){
            remove(toRemove);
            this.size -= 1;
        }
    }
    
    private void remove(Node toRemove){
        //Quando o nó é uma folha
        if(toRemove.isLeaf()){
            System.out.println("folha removida!");
            if(toRemove == this.root){
                this.root = null;
            }else{
                if(toRemove.getElement() < toRemove.getParent().getElement())
                    toRemove.getParent().setLeft(null);
                else
                    toRemove.getParent().setRight(null);
            }
        } //Quando o nó pai só tem um filho na direita ou esquerda
        else if(toRemove.hasOnlyLeftCHild()){
            System.out.println("filho da esquerda removido!");
            if(toRemove == this.root){
                this.root = toRemove.getLeft();
                this.root.setParent(null);
            }else{
                toRemove.getLeft().setParent(toRemove.getParent());
                if(toRemove.getElement() < toRemove.getParent().getElement()){
                    toRemove.getParent().setLeft(toRemove.getLeft());
                }else
                    toRemove.getParent().setRight(toRemove.getLeft());
            }
        }else if(toRemove.hasOnlyRightChild()){
            System.out.println("filho da direita removido!");
            if(toRemove == this.root){
                this.root = toRemove.getRight();
                this.root.setParent(null);
            }else{
                toRemove.getRight().setParent(toRemove.getParent());
                
                if(toRemove.getElement() < toRemove.getParent().getElement())
                    toRemove.getParent().setLeft(toRemove.getRight());
                else
                    toRemove.getParent().setRight(toRemove.getRight());
            }
        }//Quando o nó tem dois filhos
        else{
            System.out.println("filhos da esquerda e direita removidos!");
            Node sucessor = sucessor(toRemove);
            toRemove.setElement(sucessor.getElement());
            remove(sucessor);
        }
    }
    
    public Node sucessor(Node node) {
        if (node == null) return null;
        
        if (node.getRight() != null)
            return min(node.getRight());
        else {
            Node aux = node.getParent();
            
            while (aux != null && aux.getElement() < node.getElement())
                aux = aux.getParent();
            
            return aux;
        }
    }
    
    public Node min() {
        if (isEmpty()) return null;
        return min(this.root);
    }
    
    private Node min(Node node) {
        if (node.getLeft() == null) return node;
        else return min(node.getLeft());
    }
    
     public ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Node> queue = new LinkedList<Node>();
        
        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                
                list.add(current.getElement());
                
                if(current.getLeft() != null) 
                    queue.addLast(current.getLeft());
                if(current.getRight() != null) 
                    queue.addLast(current.getRight());   
            }
        }
        return list;
    }
}
