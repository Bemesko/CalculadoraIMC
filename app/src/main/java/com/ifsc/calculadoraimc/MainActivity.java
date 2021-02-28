package com.ifsc.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edTxtName, edTxtHeight, edTxtWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtName = findViewById(R.id.editTextName);
        edTxtHeight = findViewById(R.id.editTextHeight);
        edTxtWeight = findViewById(R.id.editTextWeight);
    }

    public void calculateBMI(View view){
        Intent intent = new Intent(this, BmiActivity.class);

        String name = edTxtName.getText().toString();
        Double weight = Double.parseDouble(edTxtWeight.getText().toString());
        Double height = Double.parseDouble(edTxtHeight.getText().toString());

        intent.putExtra("name", name);
        intent.putExtra("height", height);
        intent.putExtra("weight", weight);

        startActivity(intent);
    }
}