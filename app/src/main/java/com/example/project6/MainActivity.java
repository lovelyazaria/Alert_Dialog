package com.example.project6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerJenis;
    EditText editNomor;
    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerJenis = findViewById(R.id.spinnerJenis);
        editNomor = findViewById(R.id.editNomor);
        btnAlert = findViewById(R.id.btnAlert);

        // pilihan persis kaya foto kamu
        String[] jenis = {
                "Telepon Sekolah",
                "Telepon Rumah",
                "Telepon Kantor",
                "Telepon Orang Tua",
                "Telepon Darurat"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, jenis);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJenis.setAdapter(adapter);

        btnAlert.setOnClickListener(v -> {

            String tipe = spinnerJenis.getSelectedItem().toString();
            String nomor = editNomor.getText().toString();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("No Telepon");
            alert.setMessage("No (" + tipe + ") : " + nomor);
            alert.setPositiveButton("OK", null);
            alert.show();
        });
    }
}
