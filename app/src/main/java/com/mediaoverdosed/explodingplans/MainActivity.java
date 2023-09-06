package com.mediaoverdosed.explodingplans;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etLeftTop, etLeftBottom, etRightTop, etRightBottom;
    private Button btnLeftBottom, btnLeftTop, btnRightBottom, btnRightTop, btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLeftTop = findViewById(R.id.etLeftTop);
        etLeftBottom = findViewById(R.id.etLeftBottom);
        etRightTop = findViewById(R.id.etRightTop);
        etRightBottom = findViewById(R.id.etRightBottom);

        btnLeftBottom = findViewById(R.id.btnLeftBottom);
        btnLeftTop = findViewById(R.id.btnLeftTop);
        btnRightBottom = findViewById(R.id.btnRightBottom);
        btnRightTop = findViewById(R.id.btnRightTop);
        btnClear = findViewById(R.id.btnClear);


        btnLeftTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 calculateProportion(true, true);
            }
        });
        btnLeftBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateProportion(true, false);
            };
        });
        btnRightTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateProportion(false, true);
            }
        });
        btnRightBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateProportion(false, false);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFields();
            }
        });
    }

    @SuppressLint("SetTextI18n") // IKD why, but otherwise IDE outlines it.
    public void calculateProportion(boolean left, boolean top) {
        EditText[] fields = {etLeftTop, etLeftBottom, etRightTop, etRightBottom};
        float[] values = {0.0F, 0.0F, 0.0F, 0.0F};

        for (int i = 0; i <= 3; i++) {
            if (!TextUtils.isEmpty(fields[i].getText())) {
                values[i] = Float.parseFloat(fields[i].getText().toString());
            }
        }

        float leftTop = values[0];
        float leftBottom = values[1];
        float rightTop = values[2];
        float rightBottom = values[3];

        float result;

        if (left && top) {
            result = leftBottom * rightTop / rightBottom;
            etLeftTop.setText(Float.toString(result));
        } else if (left && !top) {
            result = leftTop * rightBottom / rightTop;
            etLeftBottom.setText(Float.toString(result));
        } else if (!left && top) {
            result = leftTop * rightBottom / leftBottom;
            etRightTop.setText(Float.toString(result));
        } else {
            result = leftBottom * rightTop / leftTop;
            etRightBottom.setText(Float.toString(result));
        }
    }
    public void clearFields() {
        etLeftTop.setText("");
        etLeftBottom.setText("");
        etRightTop.setText("");
        etRightBottom.setText("");

    }

}
