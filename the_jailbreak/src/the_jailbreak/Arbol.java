/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_jailbreak;

/**
 *
 * @author Romero
 */
public class Arbol {
    Node heap;

    public Arbol() {
    }

    public Arbol(Node heap) {
        this.heap = heap;
    }

    public Node getHeap() {
        return heap;
    }

    public void setHeap(Node heap) {
        this.heap = heap;
    }

    @Override
    public String toString() {
        return  "entrada"+heap.toString();
    }
    
}
