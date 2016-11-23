/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_jailbreak;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public class Frame extends JFrame implements KeyListener {

    Panel panel;
    //JButton boton1, boton2;
    String matriz[][] = new String[40][40];

    public Frame() {
        System.out.println("hi");
        panel = new Panel();
        add(panel);
        
        setSize(700, 700);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);

        addKeyListener(this);
        
    }

    public void leer() {

        String texto = "";

        try {

            FileReader lector = new FileReader("texto.txt");
            
            BufferedReader contenido = new BufferedReader(lector);
            int x = 0;

            while ((texto = contenido.readLine()) != null) {
                for (int j = 0; j < 40; j++) {
                    char a = texto.charAt(j);
                    String l = "" + a;
                    matriz[x][j] = l;
                }
                x++;
                // System.out.println(texto);
                // break;
            }
            contenido.close();
            lector.close();

        } catch (Exception e) {
            System.out.println("Error al leer");
        }
        

        int x = 1;

        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        ke.getKeyCode();
       //repaint();
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Arriba");
         

        }/// fin del if para arriba
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Abajo");



        }// fin del if

        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("izquierda");



        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Derecha");
           //  Frame();
             leer();
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
            if (((x >= 0) && (x < 40)) && ((y >= 0) && (y < 40))) {
                y++;
                if (matriz[x][y].equals("░")) {
                    matriz[x][y] = "E";
                    matriz[x][y - 1] = "░";
                }

                System.out.println(matriz[x][y]);
                System.out.println(x + "," + y);
                System.out.println(matriz[x][y - 1]);
                System.out.println(x + "," + (y - 1));

            }

            String tempM = "";

            for (int i = 0; i < 40; i++) {
                for (int j = 0; j < 40; j++) {
                    tempM = tempM + matriz[i][j];
                }
                tempM = tempM;
            }
            System.out.println(tempM.length());
            try {

                File archivo = new File("texto.txt");
                archivo.delete();
                archivo = new File("texto.txt");
                FileWriter escribir = new FileWriter(archivo, true);

                escribir.write(tempM);

                escribir.close();
            } catch (Exception e) {
                System.out.println("Error al escribir");
            }
            
        }
       

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
