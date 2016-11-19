/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Random;

/**
 *
 * @author pc
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String matriz[][] = new String[40][40];

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                matriz[i][j] = " ";
            }

        }
        Random rnd = new Random();
        
        for (int i = 0; i < 10; i++) {
            System.out.println(rnd.nextInt(3));
        }
        int num = rnd.nextInt(9);
        matriz[num][0] = "E";
        int num2 = rnd.nextInt(9);
        matriz[num2][39] = "S";
        System.out.println(num);

        /* for (int i = 0; i < 5; i++) {
            System.out.println("");
            for (int j = 0; j < 5; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }

        }*/
        int x = 0;
        int y = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j].equals("E")) {
                    x = i;
                    y = j;
                }
            }
        }

        for (int r = 0;r<200;r++) {
            int temp = rnd.nextInt(3);
            System.out.println(temp);
            int tempx = 0;
            int tempy = 0;
            if (temp==2){
                int h= y+1;
                if (y<39 && 0<=y) {
                    if (matriz[x][h].equals (" ")) {
                     matriz[x][h]="-";
                     y=y+1;
                    }
                }
                if(y==39){
                    break;
                }
               
            }
            
            if (temp==0){
                int h= x+1;
                if (x<39 && 0<=x) {
                    if (matriz[x][h].equals (" ")) {
                       matriz[h][y]="-";
                     x=x+1; 
                    }
                     
                }
                
               
            }
            //if
            if (temp==3){
                int h= x-1;
                if (x<39 && 0<x) {
                    if (matriz[x][h].equals (" ")) {
                     matriz[h][y]="-";
                     x=x-1;
                    }
                }
                
               
            }
         
        //  System.out.println("-------");
            System.out.println("x0=" +tempx);
            System.out.println("y0="+tempy);
            
           // System.out.println("");
            
            int numx = 0;
            int numy = 0;
        
            

        }//fin while

        for (int i = 0; i < 40; i++) {
            System.out.println("");
            for (int j = 0; j < 40; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }

        }//fin for

    }

}
