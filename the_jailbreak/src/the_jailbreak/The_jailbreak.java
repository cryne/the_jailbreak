/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_jailbreak;

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
        System.out.println("hola mundo");
                String matriz[][] = new String[40][40];

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                matriz[i][j] = " ";
            }

        }
        for (int i = 0; i < 40; i++) {
            matriz[i][0]="▓";
           // matriz[i][39]="▓";
            matriz[0][i]="▓";
           // matriz[39][i]="▓";
            
            
        }
        Random rnd = new Random();

        int num = rnd.nextInt(19)+1;
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
            
            if (cont==1) {
              matriz[x][y+1]="-";
              y=y+1;
              cont++;
            }else{
            
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

        }//fin while
        for (int i = 0; i < 1300; i++) {
            num = rnd.nextInt(39);
        
        num2 = rnd.nextInt(39);
            if (matriz[num][num2].equals(" ")) {
                matriz[num][num2]="-";
            }
            
        }
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (matriz[i][j].equals(" ")) {
                    matriz[i][j]="▓";
                }
                
            }
        }
         for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (matriz[i][j].equals("-")) {
                    matriz[i][j]="░";
                }
                
            }
        }
         
         
        
        for (int i = 0; i < 40; i++) {
            System.out.println("");
            for (int j = 0; j < 40; j++) {
                System.out.print("" + matriz[i][j] + "");
            }

        }//fin for
        
 

    }
    
}
