/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_jailbreak;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class Panel extends JPanel {

    @Override
    public void paint(Graphics g) {
        String matriz[][] = new String[40][40];
        String texto = "";
        System.out.println("panel");

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
            System.out.println("leyendo panel");
            System.out.println("Error al leer");
        }
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }

        //System.out.println("");
        int x1 = 50;//+13
        int y1 = 20;//+12

        /* g.drawString("h", 50, 20);
        g.setColor(Color.yellow);
        g.drawString("█", 50, 20);//+6 para moverse en horizontal
        g.setColor(Color.gray);
        g.drawString("█", 63, 20);
        g.setColor(Color.BLACK);
        g.drawString("█", 76, 20);
        g.setColor(Color.BLACK);
        g.drawString("█", 50, 32);// para moverse en el el vertical
        g.setColor(Color.GREEN);
        g.drawString("█", 50, 44);
         g.setColor(Color.RED);
        g.drawString("█", 50, 54);
         g.drawString("█", 50, 66);*/
        g.setColor(Color.RED);

        g.drawString("█", 50, 72);
        System.out.println("wilmer111");

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (matriz[i][j].equals("▓")) {
                    g.setColor(Color.BLACK);
                    g.drawString("█", y1, x1);
                    y1 = y1 + 12;
                }
                if (matriz[i][j].equals("░")) {
                    g.setColor(Color.GREEN);
                    g.drawString("█", y1, x1);
                    y1 = y1 + 12;
                }
                if (matriz[i][j].equals("E")) {
                    g.setColor(Color.RED);
                    g.drawString("█", y1, x1);
                    y1 = y1 + 12;
                }
                if (matriz[i][j].equals("S")) {
                    g.setColor(Color.BLACK);
                    g.drawString("S", y1, x1);
                    y1 = y1 + 12;
                }

            }
            x1 = x1 + 13;
            y1 = 23;
        }//fin for

    }

    public void leer() {

        //  int x = 1;
    }

}
