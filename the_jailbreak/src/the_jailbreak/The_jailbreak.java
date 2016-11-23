/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_jailbreak;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 *
 * @author Romero
 */
public class The_jailbreak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String matriz[][] = new String[40][40];

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

        for (int i = 0; i < 40; i++) {
            System.out.println("");
            for (int j = 0; j < 40; j++) {
                System.out.print("" + matriz[i][j] + "");
            }

        }//fin for*/

        String tempM = "";

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                tempM = tempM + matriz[i][j];
            }
            tempM = tempM + "\n";
        }
        //System.out.println(tempM);
        System.out.println(tempM.length());
        try {
//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File("texto.txt");
            archivo.delete();
            archivo = new File("texto.txt");
//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);

//Escribimos en el archivo con el metodo write 
            escribir.write(tempM);

//Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }

        Frame frame = new Frame();
        frame.setVisible(true);

        for (int i = 0; i < 10; i++) {

            // frame.repaint();
            try {
                Thread.sleep(0);
            } catch (Exception e) {
            }
        }

    }

}
