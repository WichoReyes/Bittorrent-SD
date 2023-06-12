/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpeer;

import java.util.Scanner;

/**
 *
 * @author mac
 */
public class Encript {
    
    public static String convAbin(String h){
     
        int numHex = Integer.parseInt( h, 16);
        String bin = Integer.toBinaryString(numHex);
        //System.out.println(bin);
        return bin;
    }
    
    public static String XORAdd(String b1, String b2){
        int bt1, bt2;
        
        bt1 = Integer.parseInt(b1, 2);
        bt2 = Integer.parseInt(b2, 2);
        
        int xOr = bt1 ^ bt2;

        String bin = Integer.toBinaryString(xOr);
        String xOrhex = Integer.toHexString(xOr);
        //System.out.println("Resultado de XOR:  " + bin);
        return xOrhex;
    }
    
    public static String XOR(String b1, String b2){
        int bt1, bt2;
        
        bt1 = Integer.parseInt(b1, 2);
        bt2 = Integer.parseInt(b2, 2);
        
        int xOr = bt1 ^ bt2;

        String bin = Integer.toBinaryString(xOr);
        //System.out.println("Resultado de XOR:  " + bin);
        return bin;
    }
    
    public static String XORtot(String b1, String b2, String b3, String b4){
        int bt1, bt2, bt3, bt4;
        
        bt1 = Integer.parseInt(b1, 2);
        bt2 = Integer.parseInt(b2, 2);
        bt3 = Integer.parseInt(b3, 2);
        bt4 = Integer.parseInt(b4, 2);
        
        int xOr = bt1 ^ bt2 ^ bt3 ^ bt4;

        String bin = Integer.toBinaryString(xOr);
        //System.out.println("Resultado de XOR:  " + bin);
        return bin;
    }
    
    // Método para hacer XOR entre numeros binarios
    public static String XOR2(String b1, String b2){
        int bt1, bt2, bt3;
        
        bt1 = Integer.parseInt(b1, 2);
        bt2 = Integer.parseInt(b2, 2);
        
        int xOr = bt1 ^ bt2;

        String bin = Integer.toBinaryString(xOr);
        String xOrhex = Integer.toHexString(xOr);
        //System.out.println("Resultado de XOR:  " + bin);
        return xOrhex;
    }
    
    public static String XOR3(String b1, String b2, String b3){
        int bt1, bt2, bt3;
        
        bt1 = Integer.parseInt(b1, 2);
        bt2 = Integer.parseInt(b2, 2);
        bt3 = Integer.parseInt(b3, 2);
        
        int xOr = bt1 ^ bt2 ^bt3;

        String bin = Integer.toBinaryString(xOr);
        String xOrhex = Integer.toHexString(xOr);
        //System.out.println("Resultado de XOR:  " + bin);
        return xOrhex;
    }
    
    public static String[][] clavesR(String [][] matrizKey, String [][] matrizKey1, int z){
        
        String matrizKeyBin[][] = new String[4][4];
        String matrizKeyBin1[][] = new String[4][4];
        String matrizKeyR1[][] = new String[4][4];
        String row;
        String gg = null;
        String f1, c1;
        char f, c;
        int g, h, y;
        
        // S-Box
        String sBox [][] = { {"63", "7c", "77", "7b", "f2", "6b", "6f", "c5", "30", "01", "67", "2b", "fe","d7", "ab", "76"}, {"ca", "82", "c9", "7d", "fa", "59", "47", "f0", "ad", "d4", "a2", "af", "9c", "a4", "72","c0"}, {"b7", "fd", "93", "26", "36", "3f", "f7", "cc", "34", "a5", "e5", "f1", "71", "d8", "31", "15"}, {"04","c7", "23", "c3", "18", "96", "05", "9a", "07", "12", "80", "e2", "eb", "27", "b2", "75"}, {"09", "83", "2c","1a", "1b", "6e", "5a", "a0", "52", "3b", "d6", "b3", "29", "e3", "2f", "84"}, {"53", "d1", "00", "ed", "20","fc", "b1", "5b", "6a", "cb", "be", "39", "4a", "4c", "58", "cf"}, {"d0", "ef", "aa", "fb", "43", "4d", "33","85", "45", "f9", "02", "7f", "50", "3c", "9f", "a8"}, {"51", "a3", "40", "8f", "92", "9d", "38", "f5", "bc","b6", "da", "21", "10", "ff", "f3", "d2"}, {"cd", "0c", "13", "ec", "5f", "97", "44", "17", "c4", "a7", "7e","3d", "64", "5d", "19", "73"}, {"60", "81", "4f", "dc", "22", "2a", "90", "88", "46", "ee", "b8", "14", "de","5e", "0b", "db"}, {"e0", "32", "3a", "0a", "49", "06", "24", "5c", "c2", "d3", "ac", "62", "91", "95", "e4","79"}, {"e7", "c8", "37", "6d", "8d", "d5", "4e", "a9", "6c", "56", "f4", "ea", "65", "7a", "ae", "08"}, {"ba","78", "25", "2e", "1c", "a6", "b4", "c6", "e8", "dd", "74", "1f", "4b", "bd", "8b", "8a"}, {"70", "3e", "b5","66", "48", "03", "f6", "0e", "61", "35", "57", "b9", "86", "c1", "1d", "9e"}, {"e1", "f8", "98", "11", "69","d9", "8e", "94", "9b", "1e", "87", "e9", "ce", "55", "28", "df"}, {"8c", "a1", "89", "0d", "bf", "e6", "42","68", "41", "99", "2d", "0f", "b0", "54", "bb", "16"} };
        // Matriz Rcon
        String Rcon [][] = {{"01", "02", "04", "08", "10", "20", "40", "80", "1b", "36"}, {"00", "00", "00", "00", "00", "00", "00", "00", "00", "00"}, {"00", "00", "00", "00", "00", "00", "00", "00", "00", "00"}, {"00", "00", "00", "00", "00", "00", "00", "00", "00", "00"}};
        
        matrizKey1[0][0] = (matrizKey[0][0]);
        matrizKey1[1][0] = (matrizKey[1][0]);
        matrizKey1[2][0] = (matrizKey[2][0]);
        matrizKey1[3][0] = (matrizKey[3][0]);
        matrizKey1[0][1] = (matrizKey[0][1]);
        matrizKey1[1][1] = (matrizKey[1][1]);
        matrizKey1[2][1] = (matrizKey[2][1]);
        matrizKey1[3][1] = (matrizKey[3][1]);
        matrizKey1[0][2] = (matrizKey[0][2]);
        matrizKey1[1][2] = (matrizKey[1][2]);
        matrizKey1[2][2] = (matrizKey[2][2]);
        matrizKey1[3][2] = (matrizKey[3][2]);
        matrizKey1[0][3] = (matrizKey[0][3]);
        matrizKey1[1][3] = (matrizKey[1][3]);
        matrizKey1[2][3] = (matrizKey[2][3]);
        matrizKey1[3][3] = (matrizKey[3][3]);
        
        // Definición de matrizKey
        //
        
        //
        
        matrizKeyBin1[0][0] = convAbin(matrizKey[0][0]);
        matrizKeyBin1[1][0] = convAbin(matrizKey[1][0]);
        matrizKeyBin1[2][0] = convAbin(matrizKey[2][0]);
        matrizKeyBin1[3][0] = convAbin(matrizKey[3][0]);
        matrizKeyBin1[0][1] = convAbin(matrizKey[0][1]);
        matrizKeyBin1[1][1] = convAbin(matrizKey[1][1]);
        matrizKeyBin1[2][1] = convAbin(matrizKey[2][1]);
        matrizKeyBin1[3][1] = convAbin(matrizKey[3][1]);
        matrizKeyBin1[0][2] = convAbin(matrizKey[0][2]);
        matrizKeyBin1[1][2] = convAbin(matrizKey[1][2]);
        matrizKeyBin1[2][2] = convAbin(matrizKey[2][2]);
        matrizKeyBin1[3][2] = convAbin(matrizKey[3][2]);
        matrizKeyBin1[0][3] = convAbin(matrizKey[0][3]);
        matrizKeyBin1[1][3] = convAbin(matrizKey[1][3]);
        matrizKeyBin1[2][3] = convAbin(matrizKey[2][3]);
        matrizKeyBin1[3][3] = convAbin(matrizKey[3][3]);
        
        row = matrizKey[0][3];
        
        for (int i = 0; i <= 2; i++) {
            matrizKey[i][3] = matrizKey[i+1][3];
        }
        matrizKey[3][3] = row;
        
        // Se sustituye cada casilla con SubBytes
        for (int i = 0; i <= 3; i++) {
                gg = matrizKey[i][3];
                f = gg.charAt(0);
                c = gg.charAt(1);
                
                f1 = String.valueOf(f);
                c1 = String.valueOf(c);
                
                if (f == 'a') {
                    f1 = "10";
                }else if (f == 'b') {
                    f1 = "11";
                }else if (f == 'c') {
                    f1 = "12";
                }else if (f == 'd') {
                    f1 = "13";
                }else if (f == 'e') {
                    f1 = "14";
                }else if (f == 'f') {
                    f1 = "15";
                }
                
                if (c == 'a') {
                    c1 = "10";
                }else if (c == 'b') {
                    c1 = "11";
                }else if (c == 'c') {
                    c1 = "12";
                }else if (c == 'd') {
                    c1 = "13";
                }else if (c == 'e') {
                    c1 = "14";
                }else if (c == 'f') {
                    c1 = "15";
                }
                
                g = Integer.parseInt(f1);
                h = Integer.parseInt(c1);
                matrizKey[i][3] = sBox[g][h];   ////////////////////// PUEDE QUE HAYA UN ERROR AQUI ///////////////////////////
            }
        
        // Convertir matrizKey a binario para hacer XOR
        matrizKeyBin[0][0] = convAbin(matrizKey[0][0]);
        matrizKeyBin[1][0] = convAbin(matrizKey[1][0]);
        matrizKeyBin[2][0] = convAbin(matrizKey[2][0]);
        matrizKeyBin[3][0] = convAbin(matrizKey[3][0]);
        matrizKeyBin[0][1] = convAbin(matrizKey[0][1]);
        matrizKeyBin[1][1] = convAbin(matrizKey[1][1]);
        matrizKeyBin[2][1] = convAbin(matrizKey[2][1]);
        matrizKeyBin[3][1] = convAbin(matrizKey[3][1]);
        matrizKeyBin[0][2] = convAbin(matrizKey[0][2]);
        matrizKeyBin[1][2] = convAbin(matrizKey[1][2]);
        matrizKeyBin[2][2] = convAbin(matrizKey[2][2]);
        matrizKeyBin[3][2] = convAbin(matrizKey[3][2]);
        matrizKeyBin[0][3] = convAbin(matrizKey[0][3]);
        matrizKeyBin[1][3] = convAbin(matrizKey[1][3]);
        matrizKeyBin[2][3] = convAbin(matrizKey[2][3]);
        matrizKeyBin[3][3] = convAbin(matrizKey[3][3]);
        
        // Mostrar matriz
//        for (int i = 0; i <= 3; i++) {
//            for (int j = 0; j <= 3; j++) {
//                System.out.print(matrizKey[i][j] + " ");
//            }
//            System.out.println(" ");
//        }
        
        // Llenar primer columna de matrizKeyR1
        for (int i = 0; i <=3; i++) {
                matrizKeyR1[i][0] = XOR3(matrizKeyBin[i][0], matrizKeyBin[i][3], convAbin(Rcon[i][z]));
        }
        
        // Lenar el resto de matrizKeyR1
        y = 0;
        for (int i = 1; i <=3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (y == 2) {
                    matrizKeyR1[j][i] = XOR2(matrizKeyBin1[j][i], convAbin(matrizKeyR1[j][y]));
                }else
                matrizKeyR1[j][i] = XOR2(matrizKeyBin[j][i], convAbin(matrizKeyR1[j][y]));
            }
            y++;
        }
        
        String salida[][] = new String[4][4];
        
        // Agrega un cero si algun valor de casilla es un solo numero
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                if (matrizKeyR1[i][j].length() != 2) {
                    matrizKeyR1[i][j] = "0" + matrizKeyR1[i][j];
                }
            }
        }
 
        
        
        // Imprimir matriz llave de primera ronda
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <= 3; j++) {
//                System.out.print(matrizKeyR1[i][j] + " ");
                salida[i][j] = matrizKeyR1[i][j];
            }
//            System.out.println("");
        }
        return salida;
    }
    
    public static String[][] AddRoundKeys(String [][] matrizKey, String [][] matrizState){
        
        String matrizResult[][] = new String[4][4];
                
        // XOR entre matricez
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                matrizResult[i][j] = XORAdd(matrizState[i][j], matrizKey[i][j]);
            }
        }
        
        // Agrega un cero si algun valor de casilla es un solo numero
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                if (matrizResult[i][j].length() != 2) {
                    matrizResult[i][j] = "0" + matrizResult[i][j];
                }
            }
        }
        
        // Imprimiendo matriz resultado
        System.out.println("");
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(matrizResult[i][j] + " ");
            }
            System.out.println(" ");
        }
        return matrizResult;
    }    
    
    public static String[][] SubBytes(String [][] matrizState){
        
        // Matriz s-box
        String sBox [][] = { {"63", "7c", "77", "7b", "f2", "6b", "6f", "c5", "30", "01", "67", "2b", "fe","d7", "ab", "76"}, {"ca", "82", "c9", "7d", "fa", "59", "47", "f0", "ad", "d4", "a2", "af", "9c", "a4", "72","c0"}, {"b7", "fd", "93", "26", "36", "3f", "f7", "cc", "34", "a5", "e5", "f1", "71", "d8", "31", "15"}, {"04","c7", "23", "c3", "18", "96", "05", "9a", "07", "12", "80", "e2", "eb", "27", "b2", "75"}, {"09", "83", "2c","1a", "1b", "6e", "5a", "a0", "52", "3b", "d6", "b3", "29", "e3", "2f", "84"}, {"53", "d1", "00", "ed", "20","fc", "b1", "5b", "6a", "cb", "be", "39", "4a", "4c", "58", "cf"}, {"d0", "ef", "aa", "fb", "43", "4d", "33","85", "45", "f9", "02", "7f", "50", "3c", "9f", "a8"}, {"51", "a3", "40", "8f", "92", "9d", "38", "f5", "bc","b6", "da", "21", "10", "ff", "f3", "d2"}, {"cd", "0c", "13", "ec", "5f", "97", "44", "17", "c4", "a7", "7e","3d", "64", "5d", "19", "73"}, {"60", "81", "4f", "dc", "22", "2a", "90", "88", "46", "ee", "b8", "14", "de","5e", "0b", "db"}, {"e0", "32", "3a", "0a", "49", "06", "24", "5c", "c2", "d3", "ac", "62", "91", "95", "e4","79"}, {"e7", "c8", "37", "6d", "8d", "d5", "4e", "a9", "6c", "56", "f4", "ea", "65", "7a", "ae", "08"}, {"ba","78", "25", "2e", "1c", "a6", "b4", "c6", "e8", "dd", "74", "1f", "4b", "bd", "8b", "8a"}, {"70", "3e", "b5","66", "48", "03", "f6", "0e", "61", "35", "57", "b9", "86", "c1", "1d", "9e"}, {"e1", "f8", "98", "11", "69","d9", "8e", "94", "9b", "1e", "87", "e9", "ce", "55", "28", "df"}, {"8c", "a1", "89", "0d", "bf", "e6", "42","68", "41", "99", "2d", "0f", "b0", "54", "bb", "16"} };
        String matrizResult[][] = new String[4][4];
        String gg = null;
        char f, c;
        
        
         //Mostrando matriz s-box
        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 15; j++) {
                System.out.print(sBox[i][j] + " ");
            }
            System.out.println(" ");
        }
        
        
        // Mostrando matriz estado
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(matrizState[i][j] + " ");
            }
            System.out.println(" ");
        }
        
        int g = 0,h = 0;
        
        //String oo = "abcdef";
        //int aa = 0, bb, cc, dd, ee, ff;
        String f1, c1;
        
        // Llenado de matriz result
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                gg = matrizState[i][j];
                f = gg.charAt(0);
                c = gg.charAt(1);
                
                f1 = String.valueOf(f);
                c1 = String.valueOf(c);
                
                if (f == 'a') {
                    f1 = "10";
                }else if (f == 'b') {
                    f1 = "11";
                }else if (f == 'c') {
                    f1 = "12";
                }else if (f == 'd') {
                    f1 = "13";
                }else if (f == 'e') {
                    f1 = "14";
                }else if (f == 'f') {
                    f1 = "15";
                }
                
                if (c == 'a') {
                    c1 = "10";
                }else if (c == 'b') {
                    c1 = "11";
                }else if (c == 'c') {
                    c1 = "12";
                }else if (c == 'd') {
                    c1 = "13";
                }else if (c == 'e') {
                    c1 = "14";
                }else if (c == 'f') {
                    c1 = "15";
                }
                
                g = Integer.parseInt(f1);
                h = Integer.parseInt(c1);
                matrizResult[i][j] = sBox[g][h];   
            }
        }
        
        System.out.println(" ");
        
        // Agrega un cero si algun valor de casilla es un solo numero
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                if (matrizResult[i][j].length() != 2) {
                    matrizResult[i][j] = "0" + matrizResult[i][j];
                }
            }
        }
        
        // Mostrando matriz result
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <=3; j++) {
                System.out.print(matrizResult[i][j] + " ");
            }
            System.out.println(" ");
        }
        return matrizResult;
    }
    
    public static String[][] ShiftRows(String[][] matrizState){
        
        // Mostrando matriz estado
//        for (int i = 0; i <= 3; i++) {
//            for (int j = 0; j <= 3; j++) {
//                System.out.print(matrizState[i][j] + " ");
//            }
//            System.out.println(" ");
//        }
        
        // Rotando y mostrando valores de filas de la matriz
        String row1 = matrizState[1][0];
        //String row11 = matrizState[1][3];
        String row2 = matrizState[2][0];
        String row3 = matrizState[2][1];
        String row4 = matrizState[3][0];
        String row5 = matrizState[3][1];
        String row6 = matrizState[3][2];
        
        System.out.println(" ");
        
        // Recorriendo fila 1
        for (int i = 0; i <= 2; i++) {
            matrizState[1][i] = matrizState[1][i+1];
        }
        matrizState[1][3] = row1;
        
        // Recorriendo fila 2
        for (int i = 0; i <= 1; i++) {
            matrizState[2][i] = matrizState[2][i+2];
        }
        matrizState[2][2] = row2;
        matrizState[2][3] = row3;
        
        // Recorriendo fila 3
        matrizState[3][0] = matrizState[3][3];
        matrizState[3][1] = row4;
        matrizState[3][2] = row5;
        matrizState[3][3] = row6;
        
        
        // Agrega un cero si algun valor de casilla es un solo numero
        for (int i = 0; i <=3; i++) {
            for (int j = 0; j <=3; j++) {
                if (matrizState[i][j].length() != 2) {
                    matrizState[i][j] = "0" + matrizState[i][j];
                }
            }
        }
        
        // Mostrando matriz AfterShiftRows
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(matrizState[i][j] + " ");
            }
            System.out.println(" ");
        }
        return matrizState;
    }
    
    public static String[] mixColumns(String vec1, String vec2, String vec3, String vec4){
        
        Scanner in = new Scanner(System.in);
        int numHex = 0, numHexCor = 0;
        String res [] = new String[4];
        String vecbin [] = new String[4];
        String vecom [] = new String[4];
        String binCor, irr = "100011011", binCor2;
        String bueno = null, por3 = null;
        
        
        // Convertimos a binario el vector hexadecimal
        
        vecbin[0] = convAbin(vec1);
        vecbin[1] = convAbin(vec2);
        vecbin[2] = convAbin(vec3);
        vecbin[3] = convAbin(vec4);
        
        ////////////////////// Para primer valor del vector///////////////////////////
        // Para multiplicar por 02
        numHex = Integer.parseInt(vecbin[0], 2);
        numHexCor = numHex << 1;
        binCor = Integer.toBinaryString(numHexCor);
        if(binCor.length()>=9 && binCor.charAt(0) == '1'){
            binCor = XOR(binCor,irr);
        }
        // Corrimiento para multiplicar por 03
        numHex = Integer.parseInt(vecbin[1], 2);
        numHexCor = numHex << 1;
        binCor2 = Integer.toBinaryString(numHexCor);
        if(binCor2.length()>=9 && binCor.charAt(0) == '1'){
            binCor2 = XOR(binCor2,irr);
        }
        // XOR entre corrimiento de 03 y 03
        por3 = XOR(binCor2,vecbin[1]);
        
        // XOR de los tres resultados y conversion a hexadecimal
        int f = Integer.parseInt(XORtot(vecbin[2], vecbin[3], binCor, por3), 2);
        res[0] = Integer.toHexString(f);
        
        
//        XORtot(vecbin[0], vecbin[1], binCor, por3)
        
        //////////////////////// Para segundo valor del vector//////////////////////////
        
        numHex = Integer.parseInt(vecbin[1], 2);
        numHexCor = numHex << 1;
        binCor = Integer.toBinaryString(numHexCor);
        if(binCor.length()>=9 && binCor.charAt(0) == '1'){
            binCor = XOR(binCor,irr);
        }
        // Corrimiento para multiplicar por 03
        numHex = Integer.parseInt(vecbin[2], 2);
        numHexCor = numHex << 1;
        binCor2 = Integer.toBinaryString(numHexCor);
        if(binCor2.length()>=9 && binCor.charAt(0) == '1'){
            binCor2 = XOR(binCor2,irr);
        }
        // XOR entre corrimiento de 03 y 03
        por3 = XOR(binCor2,vecbin[2]);
        
        // XOR de los tres resultados y conversion a hexadecimal
        f = Integer.parseInt(XORtot(vecbin[0], vecbin[3], binCor, por3), 2);
        res[1] = Integer.toHexString(f);
        
        /////////// Para el tercer valor del vector///////////////////////////////
        numHex = Integer.parseInt(vecbin[2], 2);
        numHexCor = numHex << 1;
        binCor = Integer.toBinaryString(numHexCor);
        if(binCor.length()>=9 && binCor.charAt(0) == '1'){
            binCor = XOR(binCor,irr);
        }
        // Corrimiento para multiplicar por 03
        numHex = Integer.parseInt(vecbin[3], 2);
        numHexCor = numHex << 1;
        binCor2 = Integer.toBinaryString(numHexCor);
        if(binCor2.length()>=9 && binCor.charAt(0) == '1'){
            binCor2 = XOR(binCor2,irr);
        }
        // XOR entre corrimiento de 03 y 03
        por3 = XOR(binCor2,vecbin[3]);
        
        // XOR de los tres resultados y conversion a hexadecimal
        f = Integer.parseInt(XORtot(vecbin[0], vecbin[1], binCor, por3), 2);
        res[2] = Integer.toHexString(f);
        
        /////////// Para el cuarto valor del vector///////////////////////////////
        numHex = Integer.parseInt(vecbin[3], 2);
        numHexCor = numHex << 1;
        binCor = Integer.toBinaryString(numHexCor);
        //System.out.println("\nVector recorrido(02): " + binCor);
        if(binCor.length()>=9 && binCor.charAt(0) == '1'){
            binCor = XOR(binCor,irr);
        }
        // Corrimiento para multiplicar por 03
        numHex = Integer.parseInt(vecbin[0], 2);
        numHexCor = numHex << 1;
        binCor2 = Integer.toBinaryString(numHexCor);
        if(binCor2.length()>=9 && binCor.charAt(0) == '1'){
            binCor2 = XOR(binCor2,irr);
        }
        // XOR entre corrimiento de 03 y 03
        por3 = XOR(binCor2,vecbin[0]);
        
        // XOR de los tres resultados y conversion a hexadecimal
        f = Integer.parseInt(XORtot(vecbin[1], vecbin[2], binCor, por3), 2);
        res[3] = Integer.toHexString(f);
        
        // Agrega un cero si algun valor de casilla es un solo numero
        for (int i = 0; i <=3; i++) {
            if (res[i].length() != 2) {
                res[i] = "0" + res[i];
            }
        }
        
        return res;
    }
    
    //public static 
    
}
