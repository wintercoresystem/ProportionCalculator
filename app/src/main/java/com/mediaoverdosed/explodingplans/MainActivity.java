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
    private Button btnLeftBottom, btnLeftTop, btnRightBottom, btnRightTop;


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
            }
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
    }

    @SuppressLint("SetTextI18n") // IKD why
    public void calculateProportion(boolean left, boolean top) {
        float leftTop, leftBottom, rightTop, rightBottom;
        if (TextUtils.isEmpty(etLeftTop.getText())) {
             leftTop = 0.0F;
        } else {
             leftTop = Float.parseFloat(etLeftTop.getText().toString());
        }

        if (TextUtils.isEmpty(etLeftBottom.getText())) {
             leftBottom = 0.0F;
        } else {
             leftBottom = Float.parseFloat(etLeftBottom.getText().toString());
        }

        if (TextUtils.isEmpty(etRightTop.getText())) {
             rightTop = 0.0F;
        } else {
             rightTop = Float.parseFloat(etRightTop.getText().toString());
        }

        if (TextUtils.isEmpty(etRightBottom.getText())) {
             rightBottom = 0.0F;
        } else {
             rightBottom = Float.parseFloat(etRightBottom.getText().toString());
        }

        float result;

        if (left && top) {
            result = leftBottom * rightTop / rightBottom;
            etLeftTop.setText(Float.toString(result));
        }
        if (left && !top) {
            result = leftTop * rightBottom / rightTop;
            etLeftBottom.setText(Float.toString(result));
        }
        if (!left && top) {
            result = leftTop * rightBottom / leftBottom;
            etRightTop.setText(Float.toString(result));
        }
        if (!left && !top) {
            result = leftBottom * rightTop / leftTop;
            etRightBottom.setText(Float.toString(result));
        }

    }

}
