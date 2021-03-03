package com.example.challengecricketchrips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etchrips;
    TextView tvQuestion;
    TextView tvAns;
    ImageView img;
    Button btnSubmit;
    DecimalFormat formatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etchrips = findViewById(R.id.etchrips);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvAns = findViewById(R.id.tvAns);
        img = findViewById(R.id.img);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvAns.setVisibility(View.GONE);
        formatter = new DecimalFormat("#0.0");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etchrips.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Kindly Enter all the fields!!", Toast.LENGTH_SHORT).show();
                } else {
                    String chrips = etchrips.getText().toString().trim();
                    int no = Integer.parseInt(chrips);

                    double ans = ((no / 3.0) + 4);

                    tvAns.setText("The Approximate Temprature outside is" + formatter.format(ans) + "degree celcisus");
                    tvAns.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}