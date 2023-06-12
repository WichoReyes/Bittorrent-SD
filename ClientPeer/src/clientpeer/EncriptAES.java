/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpeer;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static clientpeer.Encript.AddRoundKeys;
import static clientpeer.Encript.ShiftRows;
import static clientpeer.Encript.SubBytes;
import static clientpeer.Encript.clavesR;
import static clientpeer.Encript.convAbin;
import static clientpeer.Encript.mixColumns;

/**
 *
 * @author mac
 */
public class EncriptAES {
    
    public static boolean cifrar(String ruta, String rutaRecibido, 
            String txt00, String txt01, String txt02, String txt03, 
            String txt10, String txt11, String txt12, String txt13, 
            String txt20, String txt21, String txt22, String txt23, 
            String txt30, String txt31, String txt32, String txt33){
        
        boolean fe = false;
        
        
        String matrizKey[][] = new String[4][4];
        String matrizState[][] = new String[4][4];
        String matrizKeyBinAdd[][] = new String[4][4];

        // Definición de matrizKey
        matrizKey[0][0] = ("3b");
        matrizKey[1][0] = ("7e");
        matrizKey[2][0] = ("15");
        matrizKey[3][0] = ("16");
        matrizKey[0][1] = ("28");
        matrizKey[1][1] = ("ae");
        matrizKey[2][1] = ("d2");
        matrizKey[3][1] = ("a6");
        matrizKey[0][2] = ("ab");
        matrizKey[1][2] = ("f7");
        matrizKey[2][2] = ("15");
        matrizKey[3][2] = ("88");
        matrizKey[0][3] = ("09");
        matrizKey[1][3] = ("cf");
        matrizKey[2][3] = ("4f");
        matrizKey[3][3] = ("3c");

        // Convertir matrizKey en binario
        matrizKeyBinAdd[0][0] = convAbin(matrizKey[0][0]);
        matrizKeyBinAdd[1][0] = convAbin(matrizKey[1][0]);
        matrizKeyBinAdd[2][0] = convAbin(matrizKey[2][0]);
        matrizKeyBinAdd[3][0] = convAbin(matrizKey[3][0]);
        matrizKeyBinAdd[0][1] = convAbin(matrizKey[0][1]);
        matrizKeyBinAdd[1][1] = convAbin(matrizKey[1][1]);
        matrizKeyBinAdd[2][1] = convAbin(matrizKey[2][1]);
        matrizKeyBinAdd[3][1] = convAbin(matrizKey[3][1]);
        matrizKeyBinAdd[0][2] = convAbin(matrizKey[0][2]);
        matrizKeyBinAdd[1][2] = convAbin(matrizKey[1][2]);
        matrizKeyBinAdd[2][2] = convAbin(matrizKey[2][2]);
        matrizKeyBinAdd[3][2] = convAbin(matrizKey[3][2]);
        matrizKeyBinAdd[0][3] = convAbin(matrizKey[0][3]);
        matrizKeyBinAdd[1][3] = convAbin(matrizKey[1][3]);
        matrizKeyBinAdd[2][3] = convAbin(matrizKey[2][3]);
        matrizKeyBinAdd[3][3] = convAbin(matrizKey[3][3]);

        // Generacion de llaves
        String matrizKeyR1[][] = clavesR(matrizKey, matrizKey, 0);
        String matrizKeyR1B[][] = new String[4][4];
        String matrizKeyR2B[][] = new String[4][4];
        String matrizKeyR3B[][] = new String[4][4];
        String matrizKeyR4B[][] = new String[4][4];
        String matrizKeyR5B[][] = new String[4][4];
        String matrizKeyR6B[][] = new String[4][4];
        String matrizKeyR7B[][] = new String[4][4];
        String matrizKeyR8B[][] = new String[4][4];
        String matrizKeyR9B[][] = new String[4][4];
        String matrizKeyR10B[][] = new String[4][4];
        // Devolver la llave de ronda 1
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR1[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 1
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR1B[i][j] = convAbin(matrizKeyR1[i][j]);
            }
        }

        // Devolver llave de ronda 2
        System.out.println("");
        String matrizKeyR2[][] = clavesR(matrizKeyR1, matrizKey, 1);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR2[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 2
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR2B[i][j] = convAbin(matrizKeyR2[i][j]);
            }
        }

        // Devolver llave de rond 3
        System.out.println("");
        String matrizKeyR3[][] = clavesR(matrizKeyR2, matrizKeyR1, 2);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR3[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 3
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR3B[i][j] = convAbin(matrizKeyR3[i][j]);
            }
        }

        // Devolver lalve de ronda 4
        System.out.println("");
        String matrizKeyR4[][] = clavesR(matrizKeyR3, matrizKeyR2, 3);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR4[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 4
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR4B[i][j] = convAbin(matrizKeyR4[i][j]);
            }
        }

        // Devolver llave de ronda 5
        System.out.println("");
        String matrizKeyR5[][] = clavesR(matrizKeyR4, matrizKeyR3, 4);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR5[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 5
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR5B[i][j] = convAbin(matrizKeyR5[i][j]);
            }
        }

        // Devolver llave de ronda 6
        System.out.println("");
        String matrizKeyR6[][] = clavesR(matrizKeyR5, matrizKeyR4, 5);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR6[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 6
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR6B[i][j] = convAbin(matrizKeyR6[i][j]);
            }
        }

        // Devolver llave de ronda 7
        System.out.println("");
        String matrizKeyR7[][] = clavesR(matrizKeyR6, matrizKeyR5, 6);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR7[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 7
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR7B[i][j] = convAbin(matrizKeyR7[i][j]);
            }
        }

        // Devolver llave de ronda 8
        System.out.println("");
        String matrizKeyR8[][] = clavesR(matrizKeyR7, matrizKeyR6, 7);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR8[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 8
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR8B[i][j] = convAbin(matrizKeyR8[i][j]);
            }
        }

        // Devolver llave de ronda 9
        System.out.println("");
        String matrizKeyR9[][] = clavesR(matrizKeyR8, matrizKeyR7, 8);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR9[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 9
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR9B[i][j] = convAbin(matrizKeyR9[i][j]);
            }
        }

        // Devolver llave de ronda final
        System.out.println("");
        String matrizKeyR10[][] = clavesR(matrizKeyR9, matrizKeyR8, 9);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizKeyR10[i][j] + " ");
            }
            System.out.println("");
        }
        // Convertir a binario la llave de ronda 10
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizKeyR10B[i][j] = convAbin(matrizKeyR10[i][j]);
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String State[][] = new String[4][4];
        String StateBin[][] = new String[4][4];
        String matrizStateBin[][] = new String[4][4];

        // MATRIZ ESTADO (TEXTO PLANO)
        //        for (int i = 0; i <= 3; i++) {
            //            for (int j = 0; j <= 3; j++) {
                //                System.out.println("\nIngrese valores de matriz estado " + i + "," + j + ":");
                //                State[i][j] = in.nextLine();
                //            }
            //        }

        //        StateBin[0][0] = convAbin(State[0][0]);
        //        StateBin[1][0] = convAbin(State[1][0]);
        //        StateBin[2][0] = convAbin(State[2][0]);
        //        StateBin[3][0] = convAbin(State[3][0]);
        //        StateBin[0][1] = convAbin(State[0][1]);
        //        StateBin[1][1] = convAbin(State[1][1]);
        //        StateBin[2][1] = convAbin(State[2][1]);
        //        StateBin[3][1] = convAbin(State[3][1]);
        //        StateBin[0][2] = convAbin(State[0][2]);
        //        StateBin[1][2] = convAbin(State[1][2]);
        //        StateBin[2][2] = convAbin(State[2][2]);
        //        StateBin[3][2] = convAbin(State[3][2]);
        //        StateBin[0][3] = convAbin(State[0][3]);
        //        StateBin[1][3] = convAbin(State[1][3]);
        //        StateBin[2][3] = convAbin(State[2][3]);
        //        StateBin[3][3] = convAbin(State[3][3]);

        //
        //        matrizState[0][0] = ("1a");
        //        matrizState[1][0] = ("2b");
        //        matrizState[2][0] = ("3c");
        //        matrizState[3][0] = ("4d");
        //        matrizState[0][1] = ("5e");
        //        matrizState[1][1] = ("6f");
        //        matrizState[2][1] = ("7a");
        //        matrizState[3][1] = ("8b");
        //        matrizState[0][2] = ("9c");
        //        matrizState[1][2] = ("1d");
        //        matrizState[2][2] = ("2e");
        //        matrizState[3][2] = ("3f");
        //        matrizState[0][3] = ("4a");
        //        matrizState[1][3] = ("5b");
        //        matrizState[2][3] = ("6d");
        //        matrizState[3][3] = ("7e");

        /// ESTA ES LA MATRIZ DEL VECTOR DE INICIALIZACION

        matrizState[0][0] = convAbin(txt00);
        matrizState[0][1] = convAbin(txt01);
        matrizState[0][2] = convAbin(txt02);
        matrizState[0][3] = convAbin(txt03);
        matrizState[1][0] = convAbin(txt10);
        matrizState[1][1] = convAbin(txt11);
        matrizState[1][2] = convAbin(txt12);
        matrizState[1][3] = convAbin(txt13);
        matrizState[2][0] = convAbin(txt20);
        matrizState[2][1] = convAbin(txt21);
        matrizState[2][2] = convAbin(txt22);
        matrizState[2][3] = convAbin(txt23);
        matrizState[3][0] = convAbin(txt30);
        matrizState[3][1] = convAbin(txt31);
        matrizState[3][2] = convAbin(txt32);
        matrizState[3][3] = convAbin(txt33);

        matrizStateBin[0][0] = convAbin(matrizState[0][0]);
        matrizStateBin[1][0] = convAbin(matrizState[1][0]);
        matrizStateBin[2][0] = convAbin(matrizState[2][0]);
        matrizStateBin[3][0] = convAbin(matrizState[3][0]);
        matrizStateBin[0][1] = convAbin(matrizState[0][1]);
        matrizStateBin[1][1] = convAbin(matrizState[1][1]);
        matrizStateBin[2][1] = convAbin(matrizState[2][1]);
        matrizStateBin[3][1] = convAbin(matrizState[3][1]);
        matrizStateBin[0][2] = convAbin(matrizState[0][2]);
        matrizStateBin[1][2] = convAbin(matrizState[1][2]);
        matrizStateBin[2][2] = convAbin(matrizState[2][2]);
        matrizStateBin[3][2] = convAbin(matrizState[3][2]);
        matrizStateBin[0][3] = convAbin(matrizState[0][3]);
        matrizStateBin[1][3] = convAbin(matrizState[1][3]);
        matrizStateBin[2][3] = convAbin(matrizState[2][3]);
        matrizStateBin[3][3] = convAbin(matrizState[3][3]);

        ////////// PROCESO DE RONDA 1 //////////

        System.out.println("After AddRoundKeys");
        String matrizAfterAddR[][] = AddRoundKeys(matrizKeyBinAdd, matrizState);
        System.out.println("After SubBytes");
        String matrizAfterSuBy[][] = SubBytes(matrizAfterAddR);
        System.out.println("After ShiftRows");
        String matrizAfterSftR[][] = ShiftRows(matrizAfterSuBy);

        String matrizIn[][] = new String[4][4];
        String col1[] = mixColumns(matrizAfterSftR[0][0], matrizAfterSftR[1][0], matrizAfterSftR[2][0], matrizAfterSftR[3][0]);
        String col2 [] = mixColumns(matrizAfterSftR[0][1], matrizAfterSftR[1][1], matrizAfterSftR[2][1], matrizAfterSftR[3][1]);
        String col3 [] = mixColumns(matrizAfterSftR[0][2], matrizAfterSftR[1][2], matrizAfterSftR[2][2], matrizAfterSftR[3][2]);
        String col4 [] = mixColumns(matrizAfterSftR[0][3], matrizAfterSftR[1][3], matrizAfterSftR[2][3], matrizAfterSftR[3][3]);

        for (int i = 0; i <=3; i++) {
            matrizIn[i][0] = col1[i];
            matrizIn[i][1] = col2[i];
            matrizIn[i][2] = col3[i];
            matrizIn[i][3] = col4[i];
        }

        System.out.println("After MixColumns");
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizIn[i][j] + " ");
            }
            System.out.println("");
        }

        ////////// PROCESO DE RONDA 2 //////////

        // Convertir a binario matriz resultante de ronda 1
        String matrizStateR1B[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizStateR1B[i][j] = convAbin(matrizIn[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("RONDA 2");
        System.out.println("After AddRoundKeys");
        String matrizAfterAddR2[][] = AddRoundKeys(matrizKeyR1B, matrizStateR1B);
        System.out.println("After SubBytes");
        String matrizAfterSuBy2[][] = SubBytes(matrizAfterAddR2);
        System.out.println("After ShiftRows");
        String matrizAfterSftR2[][] = ShiftRows(matrizAfterSuBy2);

        String matrizIn2[][] = new String[4][4];
        String col12[] = mixColumns(matrizAfterSftR2[0][0], matrizAfterSftR2[1][0], matrizAfterSftR2[2][0], matrizAfterSftR2[3][0]);
        String col22 [] = mixColumns(matrizAfterSftR2[0][1], matrizAfterSftR2[1][1], matrizAfterSftR2[2][1], matrizAfterSftR2[3][1]);
        String col32 [] = mixColumns(matrizAfterSftR2[0][2], matrizAfterSftR2[1][2], matrizAfterSftR2[2][2], matrizAfterSftR2[3][2]);
        String col42 [] = mixColumns(matrizAfterSftR2[0][3], matrizAfterSftR2[1][3], matrizAfterSftR2[2][3], matrizAfterSftR2[3][3]);

        for (int i = 0; i <=3; i++) {
            matrizIn2[i][0] = col12[i];
            matrizIn2[i][1] = col22[i];
            matrizIn2[i][2] = col32[i];
            matrizIn2[i][3] = col42[i];
        }

        System.out.println("After MixColumns");
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizIn2[i][j] + " ");
            }
            System.out.println("");
        }

        ////////// PROCESO DE RONDA 3 //////////

        // Convertir a binario matriz resultante de ronda 1
        String matrizStateR2B[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizStateR2B[i][j] = convAbin(matrizIn2[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("RONDA 3");
        System.out.println("After AddRoundKeys");
        String matrizAfterAddR3[][] = AddRoundKeys(matrizKeyR2B, matrizStateR2B);
        System.out.println("After SubBytes");
        String matrizAfterSuBy3[][] = SubBytes(matrizAfterAddR3);
        System.out.println("After ShiftRows");
        String matrizAfterSftR3[][] = ShiftRows(matrizAfterSuBy3);

        String matrizIn3[][] = new String[4][4];
        String col13[] = mixColumns(matrizAfterSftR3[0][0], matrizAfterSftR3[1][0], matrizAfterSftR3[2][0], matrizAfterSftR3[3][0]);
        String col23[] = mixColumns(matrizAfterSftR3[0][1], matrizAfterSftR3[1][1], matrizAfterSftR3[2][1], matrizAfterSftR3[3][1]);
        String col33[] = mixColumns(matrizAfterSftR3[0][2], matrizAfterSftR3[1][2], matrizAfterSftR3[2][2], matrizAfterSftR3[3][2]);
        String col43[] = mixColumns(matrizAfterSftR3[0][3], matrizAfterSftR3[1][3], matrizAfterSftR3[2][3], matrizAfterSftR3[3][3]);

        for (int i = 0; i <=3; i++) {
            matrizIn3[i][0] = col13[i];
            matrizIn3[i][1] = col23[i];
            matrizIn3[i][2] = col33[i];
            matrizIn3[i][3] = col43[i];
        }

        System.out.println("After MixColumns");
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizIn3[i][j] + " ");
            }
            System.out.println("");
        }

        ////////// PROCESO DE RONDA 4 //////////

        // Convertir a binario matriz resultante de ronda 1
        String matrizStateR3B[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizStateR3B[i][j] = convAbin(matrizIn3[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("RONDA 4");
        System.out.println("After AddRoundKeys");
        String matrizAfterAddR4[][] = AddRoundKeys(matrizKeyR3B, matrizStateR3B);
        System.out.println("After SubBytes");
        String matrizAfterSuBy4[][] = SubBytes(matrizAfterAddR4);
        System.out.println("After ShiftRows");
        String matrizAfterSftR4[][] = ShiftRows(matrizAfterSuBy4);

        String matrizIn4[][] = new String[4][4];
        String col14[] = mixColumns(matrizAfterSftR4[0][0], matrizAfterSftR4[1][0], matrizAfterSftR4[2][0], matrizAfterSftR4[3][0]);
        String col24[] = mixColumns(matrizAfterSftR4[0][1], matrizAfterSftR4[1][1], matrizAfterSftR4[2][1], matrizAfterSftR4[3][1]);
        String col34[] = mixColumns(matrizAfterSftR4[0][2], matrizAfterSftR4[1][2], matrizAfterSftR4[2][2], matrizAfterSftR4[3][2]);
        String col44[] = mixColumns(matrizAfterSftR4[0][3], matrizAfterSftR4[1][3], matrizAfterSftR4[2][3], matrizAfterSftR4[3][3]);

        for (int i = 0; i <=3; i++) {
            matrizIn4[i][0] = col14[i];
            matrizIn4[i][1] = col24[i];
            matrizIn4[i][2] = col34[i];
            matrizIn4[i][3] = col44[i];
        }

        System.out.println("After MixColumns");
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizIn4[i][j] + " ");
            }
            System.out.println("");
        }

        ////////// PROCESO DE RONDA 5 //////////

        // Convertir a binario matriz resultante de ronda 1
        String matrizStateR4B[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizStateR4B[i][j] = convAbin(matrizIn4[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("RONDA 5");
        System.out.println("After AddRoundKeys");
        String matrizAfterAddR5[][] = AddRoundKeys(matrizKeyR4B, matrizStateR4B);
        System.out.println("After SubBytes");
        String matrizAfterSuBy5[][] = SubBytes(matrizAfterAddR5);
        System.out.println("After ShiftRows");
        String matrizAfterSftR5[][] = ShiftRows(matrizAfterSuBy5);

        String matrizIn5[][] = new String[4][4];
        String col15[] = mixColumns(matrizAfterSftR5[0][0], matrizAfterSftR5[1][0], matrizAfterSftR5[2][0], matrizAfterSftR5[3][0]);
        String col25[] = mixColumns(matrizAfterSftR5[0][1], matrizAfterSftR5[1][1], matrizAfterSftR5[2][1], matrizAfterSftR5[3][1]);
        String col35[] = mixColumns(matrizAfterSftR5[0][2], matrizAfterSftR5[1][2], matrizAfterSftR5[2][2], matrizAfterSftR5[3][2]);
        String col45[] = mixColumns(matrizAfterSftR5[0][3], matrizAfterSftR5[1][3], matrizAfterSftR5[2][3], matrizAfterSftR5[3][3]);

        for (int i = 0; i <=3; i++) {
            matrizIn5[i][0] = col15[i];
            matrizIn5[i][1] = col25[i];
            matrizIn5[i][2] = col35[i];
            matrizIn5[i][3] = col45[i];
        }

        System.out.println("After MixColumns");
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizIn5[i][j] + " ");
            }
            System.out.println("");
        }

        ////////// PROCESO DE RONDA 6 //////////

        // Convertir a binario matriz resultante de ronda 1
        String matrizStateR5B[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizStateR5B[i][j] = convAbin(matrizIn5[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("RONDA 6");
        System.out.println("After AddRoundKeys");
        String matrizAfterAddR6[][] = AddRoundKeys(matrizKeyR5B, matrizStateR5B);
        System.out.println("After SubBytes");
        String matrizAfterSuBy6[][] = SubBytes(matrizAfterAddR6);
        System.out.println("After ShiftRows");
        String matrizAfterSftR6[][] = ShiftRows(matrizAfterSuBy6);

        String matrizIn6[][] = new String[4][4];
        String col16[] = mixColumns(matrizAfterSftR6[0][0], matrizAfterSftR6[1][0], matrizAfterSftR6[2][0], matrizAfterSftR6[3][0]);
        String col26[] = mixColumns(matrizAfterSftR6[0][1], matrizAfterSftR6[1][1], matrizAfterSftR6[2][1], matrizAfterSftR6[3][1]);
        String col36[] = mixColumns(matrizAfterSftR6[0][2], matrizAfterSftR6[1][2], matrizAfterSftR6[2][2], matrizAfterSftR6[3][2]);
        String col46[] = mixColumns(matrizAfterSftR6[0][3], matrizAfterSftR6[1][3], matrizAfterSftR6[2][3], matrizAfterSftR6[3][3]);

        for (int i = 0; i <=3; i++) {
            matrizIn6[i][0] = col16[i];
            matrizIn6[i][1] = col26[i];
            matrizIn6[i][2] = col36[i];
            matrizIn6[i][3] = col46[i];
        }

        System.out.println("After MixColumns");
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizIn6[i][j] + " ");
            }
            System.out.println("");
        }

        ////////// PROCESO DE RONDA 7 //////////

        // Convertir a binario matriz resultante de ronda 1
        String matrizStateR6B[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizStateR6B[i][j] = convAbin(matrizIn6[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("RONDA 7");
        System.out.println("After AddRoundKeys");
        String matrizAfterAddR7[][] = AddRoundKeys(matrizKeyR6B, matrizStateR6B);
        System.out.println("After SubBytes");
        String matrizAfterSuBy7[][] = SubBytes(matrizAfterAddR7);
        System.out.println("After ShiftRows");
        String matrizAfterSftR7[][] = ShiftRows(matrizAfterSuBy7);

        String matrizIn7[][] = new String[4][4];
        String col17[] = mixColumns(matrizAfterSftR7[0][0], matrizAfterSftR7[1][0], matrizAfterSftR7[2][0], matrizAfterSftR7[3][0]);
        String col27[] = mixColumns(matrizAfterSftR7[0][1], matrizAfterSftR7[1][1], matrizAfterSftR7[2][1], matrizAfterSftR7[3][1]);
        String col37[] = mixColumns(matrizAfterSftR7[0][2], matrizAfterSftR7[1][2], matrizAfterSftR7[2][2], matrizAfterSftR7[3][2]);
        String col47[] = mixColumns(matrizAfterSftR7[0][3], matrizAfterSftR7[1][3], matrizAfterSftR7[2][3], matrizAfterSftR7[3][3]);

        for (int i = 0; i <=3; i++) {
            matrizIn7[i][0] = col17[i];
            matrizIn7[i][1] = col27[i];
            matrizIn7[i][2] = col37[i];
            matrizIn7[i][3] = col47[i];
        }

        System.out.println("After MixColumns");
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizIn7[i][j] + " ");
            }
            System.out.println("");
        }

        ////////// PROCESO DE RONDA 8 //////////

        // Convertir a binario matriz resultante de ronda 1
        String matrizStateR7B[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizStateR7B[i][j] = convAbin(matrizIn7[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("RONDA 8");
        System.out.println("After AddRoundKeys");
        String matrizAfterAddR8[][] = AddRoundKeys(matrizKeyR7B, matrizStateR7B);
        System.out.println("After SubBytes");
        String matrizAfterSuBy8[][] = SubBytes(matrizAfterAddR8);
        System.out.println("After ShiftRows");
        String matrizAfterSftR8[][] = ShiftRows(matrizAfterSuBy8);

        String matrizIn8[][] = new String[4][4];
        String col18[] = mixColumns(matrizAfterSftR8[0][0], matrizAfterSftR8[1][0], matrizAfterSftR8[2][0], matrizAfterSftR8[3][0]);
        String col28[] = mixColumns(matrizAfterSftR8[0][1], matrizAfterSftR8[1][1], matrizAfterSftR8[2][1], matrizAfterSftR8[3][1]);
        String col38[] = mixColumns(matrizAfterSftR8[0][2], matrizAfterSftR8[1][2], matrizAfterSftR8[2][2], matrizAfterSftR8[3][2]);
        String col48[] = mixColumns(matrizAfterSftR8[0][3], matrizAfterSftR8[1][3], matrizAfterSftR8[2][3], matrizAfterSftR8[3][3]);

        for (int i = 0; i <=3; i++) {
            matrizIn8[i][0] = col18[i];
            matrizIn8[i][1] = col28[i];
            matrizIn8[i][2] = col38[i];
            matrizIn8[i][3] = col48[i];
        }

        System.out.println("After MixColumns");
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizIn8[i][j] + " ");
            }
            System.out.println("");
        }

        ////////// PROCESO DE RONDA 9 //////////

        // Convertir a binario matriz resultante de ronda 1
        String matrizStateR8B[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizStateR8B[i][j] = convAbin(matrizIn8[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("RONDA 9");
        System.out.println("After AddRoundKeys");
        String matrizAfterAddR9[][] = AddRoundKeys(matrizKeyR8B, matrizStateR8B);
        System.out.println("After SubBytes");
        String matrizAfterSuBy9[][] = SubBytes(matrizAfterAddR9);
        System.out.println("After ShiftRows");
        String matrizAfterSftR9[][] = ShiftRows(matrizAfterSuBy9);

        String matrizIn9[][] = new String[4][4];
        String col19[] = mixColumns(matrizAfterSftR9[0][0], matrizAfterSftR9[1][0], matrizAfterSftR9[2][0], matrizAfterSftR9[3][0]);
        String col29[] = mixColumns(matrizAfterSftR9[0][1], matrizAfterSftR9[1][1], matrizAfterSftR9[2][1], matrizAfterSftR9[3][1]);
        String col39[] = mixColumns(matrizAfterSftR9[0][2], matrizAfterSftR9[1][2], matrizAfterSftR9[2][2], matrizAfterSftR9[3][2]);
        String col49[] = mixColumns(matrizAfterSftR9[0][3], matrizAfterSftR9[1][3], matrizAfterSftR9[2][3], matrizAfterSftR9[3][3]);

        for (int i = 0; i <=3; i++) {
            matrizIn9[i][0] = col19[i];
            matrizIn9[i][1] = col29[i];
            matrizIn9[i][2] = col39[i];
            matrizIn9[i][3] = col49[i];
        }

        System.out.println("After MixColumns");
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizIn9[i][j] + " ");
            }
            System.out.println("");
        }

        ////////// PROCESO DE RONDA FINAL //////////

        // Convertir a binario matriz resultante de ronda 1
        String matrizStateR9B[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizStateR9B[i][j] = convAbin(matrizIn9[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("RONDA FINAL");
        System.out.println("After AddRoundKeys");
        String matrizAfterAddR10[][] = AddRoundKeys(matrizKeyR9B, matrizStateR9B);
        System.out.println("After SubBytes");
        String matrizAfterSuBy10[][] = SubBytes(matrizAfterAddR10);
        System.out.println("After ShiftRows");
        String matrizAfterSftR10[][] = ShiftRows(matrizAfterSuBy10);

        String bbb[][] = new String[4][4];
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                bbb[i][j] = convAbin(matrizAfterSftR10[i][j]);
            }
        }

        String matrizEncript[][] = AddRoundKeys(matrizKeyR10B, bbb);

        System.out.println("");
        System.out.println("MATRIZ CIFRADA AES");
        System.out.println("");

        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizEncript[i][j] + " ");
            }
            System.out.println("");
        }

        String matrizEncriptBin[][] = new String[4][4];

        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                matrizEncriptBin[i][j] = convAbin(matrizEncript[i][j]);
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // TOMANDO ARCHIVO PARA CONVERTIRLO EN BINARIO Y PASARLO A MATRIZ STATE

        int contador = 0;
        int counter = 0;
        byte in1 = 0;
        String [][] state = new String[4][4];

        // Se abre archivo para poder leerlo
        FileInputStream archivo = null;
        try {                              ///// Ruta del archivo a descifrar
            archivo = new FileInputStream(ruta);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedInputStream buff = new BufferedInputStream (archivo);
        DataInputStream datos = new DataInputStream(buff);

        try{
            try{
                {//Se leen los datos y se usa un contador para saber el tamaño del vector
                    while(true){
                        in1 = datos.readByte();
                        //System.out.print(" " + in);
                        contador++;
                    }

                }
            }catch(EOFException eof){
                // Se cierra el archivo
                buff.close();
            }
        }catch(IOException e){
            System.out.println("Error..." + e.toString());
        }

        // Se declara un vector para guardar ahí los datos
        int vec[]=new int[contador];

        try {
            // Se vuelve a abrir el archivo   ///// Ruta del archivo a descifrar
            archivo = new FileInputStream(ruta);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        buff = new BufferedInputStream (archivo);
        datos = new DataInputStream(buff);

        try{
            {  // Hacemos otro while para llenar el vector
                while(true){
                    in1 = datos.readByte();
                    counter++;
                    vec[counter-1] = in1;
                }
            }
        }catch(EOFException eof){
            try {
                buff.close();
            } catch (IOException ex) {
                //Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            //Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        String shido;

        //System.out.print("\nlol " + in);
        //        for (int i = 0; i <contador; i++) {
            //            System.out.print(" " + Integer.toHexString(vec[i]));
            //        }

        System.out.println("\n");

        int k = contador;

        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                if (k>0) {
                    state[i][j] = Integer.toHexString(vec[contador-k]);
                    k--;
                }else {
                    state[i][j] = Integer.toHexString(0);
                }

            }
        }

        for ( int p = 0; p <=3; p++) {
            for (int o = 0; o <= 3; o++) {
                System.out.print(state[p][o] + " ");
            }
            System.out.println("");
        }

        StateBin[0][0] = convAbin(state[0][0]);
        StateBin[1][0] = convAbin(state[1][0]);
        StateBin[2][0] = convAbin(state[2][0]);
        StateBin[3][0] = convAbin(state[3][0]);
        StateBin[0][1] = convAbin(state[0][1]);
        StateBin[1][1] = convAbin(state[1][1]);
        StateBin[2][1] = convAbin(state[2][1]);
        StateBin[3][1] = convAbin(state[3][1]);
        StateBin[0][2] = convAbin(state[0][2]);
        StateBin[1][2] = convAbin(state[1][2]);
        StateBin[2][2] = convAbin(state[2][2]);
        StateBin[3][2] = convAbin(state[3][2]);
        StateBin[0][3] = convAbin(state[0][3]);
        StateBin[1][3] = convAbin(state[1][3]);
        StateBin[2][3] = convAbin(state[2][3]);
        StateBin[3][3] = convAbin(state[3][3]);

        // XOR ENTRE LA SALIDA DE AES Y EL TEXTO PLANO
        String cipher[][] = AddRoundKeys(matrizEncriptBin, StateBin);

        System.out.println("");
        System.out.println("MATRIZ CIFRADA CFB");
        System.out.println("");

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(cipher[i][j] + " ");
            }
            System.out.println("");
        }

        //        String caca = "4d";
        //        System.out.println("valor valor " + convAbin(caca));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // CONVERTIR LA AMTRIZ A VECTOR Y LEER BYTES EN ARCHIVO
        // Bloque para cifrar

        int veco[] = new int[contador];
        int l = 0;

        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                veco[l] = Integer.parseInt(convAbin(cipher[i][j]));
                l++;
            }
        }

        for (int i = 0; i <veco.length; i++) {
            System.out.print(" " + veco[i]);
        }

        // PARA LEER UN ARCHIVO POR SUS BYTES

        //Con el metodo getBytes que tiene la clase String te devuelve el un arreglo de bytes
        byte bytes[] = new byte[contador];
        for (int i = 0; i < contador; i++) {
            bytes[i] = (byte) veco[i];
        }
        //Para esciribir en un archivo
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(rutaRecibido);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i <contador; i++) {
            try {
                out.write(bytes[i]);
                fe = true;
            } catch (IOException ex) {
                //Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
                fe = false;
            }
            try {
                out.flush();
            } catch (IOException ex) {
                //Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            out.close();
        } catch (IOException ex) {
            //Logger.getLogger(Cifrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        


        return fe;
                
            
        }
    
}
