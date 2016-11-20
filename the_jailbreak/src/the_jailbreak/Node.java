/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_jailbreak;

import java.util.ArrayList;



/**
 *
 * @author admin
 */
public class Node {
    int x;
    int y;
    ArrayList<Node> next=new ArrayList<Node>();
    Node raiz;
    boolean salida;

    public Node() {
    }

    public Node(int x, int y, Node raiz, boolean salida) {
        this.x = x;
        this.y = y;
        this.raiz = raiz;
        this.salida = salida;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Node> getNext() {
        return next;
    }

    public void setNext(ArrayList<Node> next) {
        this.next = next;
    }

    public boolean isSalida() {
        return salida;
    }

    public void setSalida(boolean salida) {
        this.salida = salida;
    }

    @Override
    public String toString() {
        if(salida==true){
            return "("+x + "," + y+")salida";
        }
        return "("+x + "," + y+")" ;
    }
    
    

}
