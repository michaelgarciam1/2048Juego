package com.example.a2048juego;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TableLayout tableLayout;
    private GestureDetector mGestureDetector;

    private Game game;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableLayout = findViewById(R.id.tableLayout);
        game= new Game(tableLayout);
        game.escribirVista();
        mGestureDetector = new GestureDetector(this, new EscucharGestos());
        mButton = findViewById(R.id.btNewGame);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game= new Game(tableLayout);
            }
        });
        //        Button b = (Button) findViewById(R.id.button);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                algo();
//            }
//        });
    }





    private void algo() {

    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    class EscucharGestos extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            float ancho = Math.abs(e2.getX() - e1.getX());
            float alto = Math.abs(e2.getY() - e1.getY());

            if (ancho > alto) {
                if (e2.getX() > e1.getX()) {
                    game.movDerecha();
//                    mTextView.setText("Pa la derecha");
                } else {
                    game.movIzquierda();
//                    mTextView.setText("Pa la izq");
                }
            } else {
                if (e1.getY() > e2.getY()) {
                    game.movArriba();
//                    mTextView.setText("Pa la arriba");
                } else {
                    game.movAbajo();
//                    mTextView.setText("Pa la abajo");
                }
            }
            return true;
        }
    }
}