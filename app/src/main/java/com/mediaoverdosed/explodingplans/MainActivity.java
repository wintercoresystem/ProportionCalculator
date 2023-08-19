package com.mediaoverdosed.explodingplans;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private EditText etFirstNumber, etSecondNumber;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float first_number = Float.parseFloat(etFirstNumber.getText().toString());
                float second_number = Float.parseFloat(etSecondNumber.getText().toString());
                float result = first_number + second_number;
                tvResult.setText(String.valueOf(result));

            }
        });
    }
}