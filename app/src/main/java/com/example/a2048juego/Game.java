package com.example.a2048juego;


import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

public class Game {

    private TableLayout mTableLayout;
    private int[][] matrix;
    private static final int ARRIBA = 0;
    private static final int ABAJO = 1;
    private static final int IZQUIERDA = 2;
    private static final int DERECHA = 3;

    private int posx = 2;
    private int posy = 2;

    public Game(TableLayout tableLayout) {
        this.matrix = new int[4][4];
        this.matrix[2][2] = 2;
        this.mTableLayout = tableLayout;
        escribirVista();
    }


    public int getValor(int x, int y) {
        return matrix[x][y];
    }

    public void escribirVista() {
        for (int i = 0; i < 4; i++) {
            TableRow row = (TableRow) mTableLayout.getChildAt(i);
            for (int j = 0; j < 4; j++) {
                TextView textView = (TextView) row.getChildAt(j);

                if (matrix[i][j] == 0) {

                    textView.setText("");
                } else {
                    textView.setText(String.valueOf(matrix[i][j]));
                }
            }
        }
    }

    public void movArriba() {
        if (posx > 0) {
            matrix[posx - 1][posy] = 2;
            matrix[posx][posy] = 0;
            posx--;
        }
        escribirVista();
    }

    public void movAbajo() {
        if (posx < matrix.length - 1) {
            matrix[posx + 1][posy] = 2;
            matrix[posx][posy] = 0;
            posx++;
//                }else{
//                    hacerVibracion();
        }
        escribirVista();
    }

    public void movIzquierda() {
        if (posy > 0) {
            matrix[posx][posy - 1] = 2;
            matrix[posx][posy] = 0;
            posy--;
//                }else{
//                    hacerVibracion();
        }
        escribirVista();
    }

    public void movDerecha(){
        if (posy < matrix[0].length - 1) {
            matrix[posx][posy + 1] = 2;
            matrix[posx][posy] = 0;
            posy++;
//                }else{
//                    hacerVibracion();
        }
        escribirVista();
    }
    private void colocarSitioRandom() {
        Random ran = new Random();
        int x, y;
        x = ran.nextInt(4);
        y = ran.nextInt(4);
        boolean empty = false;

        while (!empty) {
            if (matrix[x][y] == 0) {
                matrix[x][y] = 2;
                empty = true;
            }else{
                x = ran.nextInt(4);
                y = ran.nextInt(4);
            }
        }

    }
    public void hacerMovimiento(int movimiento) {
        switch (movimiento) {
            case ARRIBA:
                if (posx > 0) {
                    matrix[posx - 1][posy] = 2;
                    matrix[posx][posy] = 0;
                    posx--;
//                }else{
//                    hacerVibracion();
                }
                break;

            case ABAJO:
                if (posx < matrix.length - 1) {
                    matrix[posx + 1][posy] = 2;
                    matrix[posx][posy] = 0;
                    posx++;
//                }else{
//                    hacerVibracion();
                }
                break;

            case IZQUIERDA:
                if (posy > 0) {
                    matrix[posx][posy - 1] = 2;
                    matrix[posx][posy] = 0;
                    posy--;
//                }else{
//                    hacerVibracion();
                }
                break;

            case DERECHA:
                if (posy < matrix[0].length - 1) {
                    matrix[posx][posy + 1] = 2;
                    matrix[posx][posy] = 0;
                    posy++;
//                }else{
//                    hacerVibracion();
                }
                break;

            default:
                Log.e("hay un error", "epaa");
        }
        escribirVista();
    }
}
