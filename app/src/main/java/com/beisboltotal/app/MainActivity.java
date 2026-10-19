
package com.beisboltotal.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int carrerasLocal = 0;
    private int carrerasVisitante = 0;
    private int entrada = 1;

    private TextView marcador;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout pantalla = new LinearLayout(this);
        pantalla.setOrientation(LinearLayout.VERTICAL);
        pantalla.setGravity(Gravity.CENTER);
        pantalla.setPadding(24, 24, 24, 24);
        pantalla.setBackgroundColor(Color.rgb(20, 75, 45));

        TextView titulo = new TextView(this);
        titulo.setText("BÉISBOL TOTAL");
        titulo.setTextSize(30);
        titulo.setTextColor(Color.WHITE);
        titulo.setGravity(Gravity.CENTER);
        pantalla.addView(titulo);

        marcador = new TextView(this);
        marcador.setTextColor(Color.WHITE);
        marcador.setTextSize(26);
        marcador.setGravity(Gravity.CENTER);
        marcador.setPadding(10, 30, 10, 20);
        pantalla.addView(marcador);

        info = new TextView(this);
        info.setTextColor(Color.WHITE);
        info.setTextSize(20);
        info.setGravity(Gravity.CENTER);
        pantalla.addView(info);

        agregarBoton(pantalla, "Carrera LOCAL", v -> {
            carrerasLocal++;
            actualizar();
        });

        agregarBoton(pantalla, "Carrera VISITANTE", v -> {
            carrerasVisitante++;
            actualizar();
        });

        agregarBoton(pantalla, "Siguiente entrada", v -> {
            entrada++;
            actualizar();
        });

        agregarBoton(pantalla, "Reiniciar marcador", v -> {
            carrerasLocal = 0;
            carrerasVisitante = 0;
            entrada = 1;
            actualizar();
        });

        setContentView(pantalla);
        actualizar();
    }

    private void agregarBoton(
            LinearLayout pantalla,
            String texto,
            View.OnClickListener accion) {

        Button boton = new Button(this);
        boton.setText(texto);
        boton.setTextSize(17);
        boton.setOnClickListener(accion);

        LinearLayout.LayoutParams parametros =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        parametros.setMargins(0, 8, 0, 8);
        pantalla.addView(boton, parametros);
    }

    private void actualizar() {
        marcador.setText(
                "LOCAL   " + carrerasLocal
                + "   -   " + carrerasVisitante
                + "   VISITANTE");

        info.setText("Entrada: " + entrada);
    }
}
