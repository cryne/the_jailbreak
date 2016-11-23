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
    Node fondo;
    
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

    public Node getFondo() {
        return fondo;
    }

    public void setFondo(Node fondo) {
        this.fondo = fondo;
    }

    @Override
    public String toString() {
        return "heap=" + heap ;
    }
    
    public void agregar(Node nuevo){
        if (heap == null){
            heap=nuevo;
            fondo=nuevo;
        }else{
            fondo.setLista(nuevo);
            fondo=nuevo;
        }
    }
    
}
