package com.example.androidhorario;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;



public class NuevaClase extends Activity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevaclase);

        Button btAnadir = findViewById(R.id.btAnadir);
        btAnadir.setOnClickListener(this);
        Button btCancelar = findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(this);

        String[] dias = {"Lunes", "Martes", "Miércoles",
                "Jueves", "Viernes"};
        ArrayAdapter<String> adapterDias =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                        dias);
        Spinner spDia = findViewById(R.id.spDia);
        spDia.setAdapter(adapterDias);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btAnadir:
                EditText etAsignatura = findViewById(R.id.etAsignatura);
                Spinner spDia = findViewById(R.id.spDia);
                EditText etHora = findViewById(R.id.etHora);

                String nombre = etAsignatura.getText().toString();
                String dia = (String) spDia.getSelectedItem();
                String hora = etHora.getText().toString();

                Evento asignatura = new Evento(nombre, dia, hora);
                asignaturas.add(asignatura);

                etAsignatura.setText("");
                etHora.setText("");
                spDia.setSelection(0);

                Toast.makeText(this, R.string.mensaje_anadir, Toast.LENGTH_LONG).show();
                break;
            case R.id.btCancelar:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}