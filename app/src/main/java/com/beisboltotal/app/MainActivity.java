
package com.beisboltotal.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int carrerasLocal = 0;
    private int carrerasVisitante = 0;
    private int entrada = 1;

    private TextView marcador;
    private TextView entradaTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout pantalla = new LinearLayout(this);
        pantalla.setOrientation(LinearLayout.VERTICAL);
        pantalla.setPadding(28, 32, 28, 28);
        pantalla.setGravity(Gravity.CENTER_HORIZONTAL);
        pantalla.setBackgroundColor(Color.rgb(242, 247, 240));

        TextView titulo = new TextView(this);
        titulo.setText("⚾ BÉISBOL TOTAL");
        titulo.setTextSize(28);
        titulo.setTextColor(Color.rgb(20, 95, 55));
        titulo.setGravity(Gravity.CENTER);
        pantalla.addView(titulo);

        TextView subtitulo = new TextView(this);
        subtitulo.setText("Béisbol infantil / Youth Baseball");
        subtitulo.setTextSize(16);
        subtitulo.setGravity(Gravity.CENTER);
        pantalla.addView(subtitulo);

        marcador = new TextView(this);
        marcador.setTextSize(25);
        marcador.setGravity(Gravity.CENTER);
        marcador.setPadding(0, 35, 0, 20);
        pantalla.addView(marcador);

        entradaTexto = new TextView(this);
        entradaTexto.setTextSize(19);
        entradaTexto.setGravity(Gravity.CENTER);
        pantalla.addView(entradaTexto);

        agregarBoton(pantalla, "Carrera local / Home run",
            () -> carrerasLocal++);

        agregarBoton(pantalla, "Carrera visitante / Away run",
            () -> carrerasVisitante++);

        agregarBoton(pantalla, "Próxima entrada / Next inning",
            () -> entrada++);

        agregarBoton(pantalla, "Reiniciar partido / Reset game", () -> {
            carrerasLocal = 0;
            carrerasVisitante = 0;
            entrada = 1;
        });

        setContentView(pantalla);
        actualizar();
    }

    private void agregarBoton(LinearLayout pantalla,
            String texto, Runnable accion) {
        Button boton = new Button(this);
        boton.setText(texto);
        boton.setTextSize(15);
        boton.setOnClickListener(v -> {
            accion.run();
            actualizar();
        });
        pantalla.addView(boton,
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    private void actualizar() {
        marcador.setText(
            "LOCAL / HOME     " + carrerasLocal +
            "\nVISITANTE / AWAY     " + carrerasVisitante);
        entradaTexto.setText(
            "Entrada / Inning: " + entrada);
    }
}
