package com.example.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    TextView tvResults;
    Button btnAct2,btnAct3;
    final int ACTIVITY3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        tvResults = findViewById(R.id.tvResults);
        btnAct2 = findViewById(R.id.btnact2);
        btnAct3 = findViewById(R.id.btnact3);

        btnAct2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                           if (etName.getText().toString().isEmpty()) {
                                               Toast.makeText(MainActivity.this, "Kindly Enter your name", Toast.LENGTH_SHORT).show();
                                           } else {
                                               String fname = etName.getText().toString().trim();

                                               Intent intent = new Intent(MainActivity.this, com.example.explicitintent.Activity2.class);
                                               intent.putExtra("name", fname);
                                               startActivity(intent);
                                           }
                                       }
                                   }
        );

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.explicitintent.Activity3.class);
                startActivityForResult(intent, ACTIVITY3);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == 3)
            {
                if(resultCode == RESULT_OK)
                {
                    tvResults.setText(data.getStringExtra("sname"));
                }
                if(resultCode == RESULT_CANCELED)
                {
                    tvResults.setText("NO DATA RECEIVED");
                }
            }
        }
    }