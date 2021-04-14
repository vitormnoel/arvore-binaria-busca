package Tree;

import java.util.ArrayList;
import three.Three;

public class Main {

    public static void main(String[] args){
        Three bt = new Three();
        
        bt.adiciona(51);
        bt.adiciona(41);
        bt.adiciona(64);
        bt.adiciona(435);
        bt.adiciona(37);
        bt.adiciona(30);
        bt.adiciona(23);
        
        bt.search(51);
        
        bt.remove(23);
        bt.remove(30);
        
        System.out.println(bt.bfs().toString());
    }
}
