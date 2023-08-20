package com.mediaoverdosed.explodingplans;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etLeftTop, etLeftBottom, etRightTop, etRightBottom;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLeftTop = findViewById(R.id.etLeftTop);
        etLeftBottom = findViewById(R.id.etLeftBottom);
        etRightTop = findViewById(R.id.etRightTop);
        etRightBottom = findViewById(R.id.etRightBottom);

        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 // Math operations here
            }
        });
    }
}