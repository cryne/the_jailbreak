/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_jailbreak;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Romero
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        System.out.println("hola mundo");

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                matriz[i][j] = " ";
            }

        }
        for (int i = 0; i < 40; i++) {
            matriz[i][0] = "▓";
            // matriz[i][39]="▓";
            matriz[0][i] = "▓";
            // matriz[39][i]="▓";

        }
        Random rnd = new Random();

        int num = rnd.nextInt(19) + 1;
        matriz[num][0] = "E";
        int num2 = rnd.nextInt(39);
        //  matriz[num2][39] = "S";
        System.out.println(num);

        /* for (int i = 0; i < 5; i++) {
            System.out.println("");
            for (int j = 0; j < 5; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }

        }*/
        int x = 0;
        int y = 0;

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (matriz[i][j].equals("E")) {
                    x = i;
                    y = j;
                }
            }
        }
        int cont = 1;
        for (int r = 0; r < 200; r++) {
            int temp = rnd.nextInt(3);
            //  System.out.println(temp);

            if (cont == 1) {
                matriz[x][y + 1] = "-";
                y = y + 1;
                cont++;
            } else {

                if (temp == 2) {
                    int h = y + 1;
                    if (y < 39 && 0 <= y) {
                        if (matriz[x][h].equals(" ")) {
                            if (h == 39) {
                                matriz[x][h] = "S";
                            } else {
                                matriz[x][h] = "-";
                                y = y + 1;
                            }
                        }
                    }
                    if (y == 39) {
                        break;
                    }

                }

                if (temp == 0) {
                    int h = x + 1;
                    if (x < 38 && 0 <= x) {
                        if (matriz[x][h].equals(" ")) {
                            matriz[h][y] = "-";
                            x = x + 1;
                        }

                    }

                }
                //if
                if (temp == 3) {
                    int h = x - 1;
                    if (x < 38 && 0 < x) {
                        if (matriz[x][h].equals(" ")) {
                            matriz[h][y] = "-";
                            x = x - 1;
                        }
                    }

                }

            }
            int numx = 0;
            int numy = 0;

        }//fin for Genera el camino hasta el final 
        String camino[][] = new String[40][40];
        camino=matriz;
        int numx = 0;
        int numy = 0;

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (matriz[i][j].equals(" ")) {
                    matriz[i][j] = "▓";
                }

            }
        }
        for (int i = 0; i < 40; i++) {

        }
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (matriz[i][j].equals("-")) {
                    matriz[i][j] = "░";
                }

            }
        }

        for (int i = 0; i < 80; i++) {
            num = rnd.nextInt(35) + 2;
            num2 = rnd.nextInt(35) + 2;
            int numAleatorio = rnd.nextInt(2);

            if (numAleatorio == 0) {
                numx = num;
                for (int j = 0; j < 25; j++) {

                    if (numx < 38 && (matriz[numx][num2 + 1].equals("▓")) && (matriz[numx][num2 - 1].equals("▓"))) {
                        matriz[numx][num2] = "░";
                        numx++;
                    }
                }
            }
            if (numAleatorio == 1) {
                numy = num2;
                for (int j = 0; j < 25; j++) {

                    if (numy < 38 && matriz[num + 1][numy].equals("▓") && matriz[num - 1][numy].equals("▓")) {
                        matriz[num][numy] = "░";
                        numy++;
                    }
                }

            }

        }// genera caminos aleatorios
        
        int pre_x=0;
        int pre_y=0;
        Arbol mapa=new Arbol();
        boolean exit=true;
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if(matriz[i][j].equals("E")){
                    Node inicio=new Node(i,j,false);
                    inicio.setRaiz(inicio);
                    mapa.agregar(inicio);
                }
            }
        } 
        boolean recorrido[][]=new boolean[40][40];
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if(matriz[i][j]=="░"||matriz[i][j]=="S"){
                    recorrido[i][j]=false;
                }else{
                    recorrido[i][j]=true;
                }
            }
        }
        Node siguiente=new Node(mapa.getFondo().getX(),mapa.getFondo().getY()+1,false);
        siguiente.setRaiz(mapa.getFondo());
        mapa.agregar(siguiente);
        pre_x=mapa.getFondo().getX();
        pre_y=mapa.getFondo().getY();
        for (int i = 0; i < 40; i++) {
            System.out.println("");
            for (int j = 0; j < 40; j++) {
                System.out.print("" + matriz[i][j] + "");
            }

        }//fin for
        
        int revision=0,contador=0;
        boolean up=false,down=false,left=false,right=false,cambio=true;
        while(exit){
            revision=0;
            up=false;
            down=false;
            left=false;
            right=false;
            if(matriz[pre_x][pre_y+1].equals("░")&&recorrido[pre_x][pre_y+1]==false){
                //System.out.println("1"+recorrido[pre_x][pre_y+1]);
                revision++;
                right=true;
            }
            if (matriz[pre_x][pre_y-1].equals("░")&&recorrido[pre_x][pre_y-1]==false) {
                //System.out.println("2"+recorrido[pre_x][pre_y-1]);
                revision++;
                left=true;
            }
            if (matriz[pre_x+1][pre_y].equals("░")&&recorrido[pre_x+1][pre_y]==false) {
                //System.out.println("3"+recorrido[pre_x+1][pre_y]);
                revision++;
                down=true;
            }
            if (matriz[pre_x-1][pre_y].equals("░")&&recorrido[pre_x-1][pre_y]==false) {
                //System.out.println("4"+recorrido[pre_x-1][pre_y]);
                revision++;
                up=true;
            }         
            if(revision==1){
                //System.out.println("x");
                if (right) {
                    //.out.println("11");
                    recorrido[pre_x][pre_y+1]=true;
                    pre_y++;
                    Node nuevo=new Node(pre_x,pre_y,false);
                    nuevo.setRaiz(mapa.getFondo().getRaiz());
                    nuevo.setDireccion("derecha");
                    mapa.agregar(nuevo);
                    
                }
                if (left) {
                    //System.out.println("12");
                    recorrido[pre_x][pre_y-1]=true;
                    pre_y--;
                    Node nuevo=new Node(pre_x,pre_y,false);
                    nuevo.setRaiz(mapa.getFondo().getRaiz());
                    nuevo.setDireccion("izquierda");
                    mapa.agregar(nuevo);
                }
                if (up) {
                    //System.out.println("13");
                    recorrido[pre_x-1][pre_y]=true;
                    pre_x--;
                    Node nuevo=new Node(pre_x,pre_y,false);
                    nuevo.setRaiz(mapa.getFondo().getRaiz());
                    nuevo.setDireccion("arriba");
                    mapa.agregar(nuevo);
                }
                if (down) {
                    //System.out.println("14");
                    recorrido[pre_x+1][pre_y]=true;
                    pre_x++;
                    Node nuevo=new Node(pre_x,pre_y,false);
                    nuevo.setRaiz(mapa.getFondo().getRaiz());
                    nuevo.setDireccion("abajo");
                    mapa.agregar(nuevo);
                }
            }else if(revision>1){
                //System.out.println("y");
                ArrayList<Node> hijos=new ArrayList<Node>();
                if (left) {
                    //System.out.println("22");
                    pre_y--;
                    Node nuevo=new Node(pre_x,pre_y,false);
                    nuevo.setDireccion("izquierda");
                    nuevo.setRaiz(mapa.getFondo());
                    hijos.add(nuevo);
                }
                if (up) {
                   // System.out.println("23");
                    pre_x--;
                    Node nuevo=new Node(pre_x,pre_y,false);
                    nuevo.setDireccion("arriba");
                    nuevo.setRaiz(mapa.getFondo());
                    hijos.add(nuevo);
                }
                if (down) {
                   // System.out.println("24");
                    pre_x++;
                    Node nuevo=new Node(pre_x,pre_y,false);
                    nuevo.setDireccion("abajo");
                    nuevo.setRaiz(mapa.getFondo());
                    hijos.add(nuevo);
                }
                if (right) {
                   // System.out.println("21");
                    pre_y++;
                    Node nuevo=new Node(pre_x,pre_y,false);
                    nuevo.setDireccion("derecha");
                    nuevo.setRaiz(mapa.getFondo());
                    hijos.add(nuevo);
                }
                if(hijos.size()==2){
                    hijos.get(0).setNext(hijos.get(1));
                }
                if (hijos.size()==3) {
                    hijos.get(1).setNext(hijos.get(2));
                    hijos.get(0).setNext(hijos.get(1));
                }
                if (hijos.size()!=0) {
                    if(mapa.getFondo().getLista()==null){
                        mapa.getFondo().setLista(hijos.get(0));
                    }
                    if(recorrido[hijos.get(0).getX()][hijos.get(0).getY()]==false){                     
                        mapa.setFondo(mapa.getFondo().getLista());
                        recorrido[mapa.getFondo().getX()][mapa.getFondo().getY()]=true;
                    }else if (recorrido[hijos.get(1).getX()][hijos.get(1).getY()]==false) {
                        mapa.setFondo(mapa.getFondo().getLista().getNext());
                        recorrido[mapa.getFondo().getX()][mapa.getFondo().getY()]=true;
                    }else if (hijos.size()==3) {
                        if(recorrido[hijos.get(2).getX()][hijos.get(2).getY()]==false){
                            mapa.setFondo(mapa.getFondo().getLista().getNext().getNext());
                            recorrido[mapa.getFondo().getX()][mapa.getFondo().getY()]=true;
                        }
                    }
                }
                
            }else{
                if(matriz[mapa.getFondo().getX()][mapa.getFondo().getY()]=="░"){
                    mapa.setFondo(mapa.getFondo().getRaiz());
                }
                //if (matriz[pre_x][pre_y+1].equals("S")&&recorrido[pre_x][pre_y+1]==false) {
                    //exit=false;
                //}
            }
            contador++;
            if (contador==35) {
                exit=false;
            }
        }
        
        System.out.println("");
        System.out.println(mapa.toString());
        System.out.println("");
        for (int i = 0; i < 40; i++) {
            System.out.println("");
            for (int j = 0; j < 40; j++) {
                if(recorrido[i][j]==false){
                    System.out.print("░");
                }else{
                    System.out.print("▓");
                }
            }

        }//fin for
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1067, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
String matriz[][] = new String[40][40];
public void arbol(String x[][],int i,int j,boolean up,boolean down,boolean right,boolean left){
    
}
}
