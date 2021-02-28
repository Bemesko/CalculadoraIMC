package com.ifsc.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {

    String name;
    Double weight, height;
    TextView txtName, txtWeight, txtHeight, txtBMI;
    DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        height = bundle.getDouble("height");
        weight = bundle.getDouble("weight");

        txtName = findViewById(R.id.txtNameValue);
        txtHeight = findViewById(R.id.txtHeightValue);
        txtWeight = findViewById(R.id.txtWeightValue);
        txtBMI = findViewById(R.id.txtBMIValue);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtName.setText(name);
        txtHeight.setText(height.toString());
        txtWeight.setText(weight.toString());
        txtBMI.setText(decimalFormat.format(CalculateBMI(weight, height)));
    }

    public Double CalculateBMI(Double weight, Double height){
        Double bmi = weight/(height*height);
        return bmi;
    }
}