package com.example.androidhorario;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.example.androidhorario.MainActivity.asignaturas;
public class verHorario extends Activity implements AdapterView.OnItemSelectedListener {

    ArrayAdapter<String> diasAdapter;
    ArrayAdapter<Evento> asignaturasAdapter;
    String[] dias = {"Lunes", "Martes", "Miércoles",
            "Jueves", "Viernes"};
    ArrayList<Evento> asignaturasDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_horario);

        diasAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dias);
        Spinner spDia = findViewById(R.id.spDia);
        spDia.setAdapter(diasAdapter);
        spDia.setOnItemSelectedListener(this);

        asignaturasDia = new ArrayList<>();
        asignaturasAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, asignaturasDia);
        ListView lvAsignaturas = findViewById(R.id.lvAsignaturas);
        lvAsignaturas.setAdapter(asignaturasAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        asignaturasDia.clear();

        String dia = dias[position];
        for (Evento asignatura : asignaturas) {
            if (asignatura.getDia().equals(dia)) {
                asignaturasDia.add(asignatura);
            }
        }

        asignaturasAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}