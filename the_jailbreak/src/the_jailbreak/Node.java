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
    String direccion;
    Node next;
    Node raiz;
    Node lista;
    boolean salida;

    public Node() {
    }

    public Node(int x, int y, boolean salida) {
        this.x = x;
        this.y = y;
        this.salida = salida;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public Node getLista() {
        return lista;
    }

    public void setLista(Node lista) {
        this.lista = lista;
    }
    
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
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

    public boolean isSalida() {
        return salida;
    }

    public void setSalida(boolean salida) {
        this.salida = salida;
    }

    @Override
    public String toString() {
        if (next!=null) {
            return "v"+next+"v"+direccion+" sigue "+lista;
        }
        return direccion+" sigue "+lista;
    }
    
    

}
