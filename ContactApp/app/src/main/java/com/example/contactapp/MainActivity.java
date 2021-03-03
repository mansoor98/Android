package com.example.contactapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCreate;
    TextView tvName;
    ImageView imgCall,imgWeb,imgLocation;

    final int CREATE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        tvName = findViewById(R.id.tvName);
        imgCall = findViewById(R.id.imgCall);
        imgLocation = findViewById(R.id.imgLocation);
        imgWeb = findViewById(R.id.imgWeb);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, com.example.contactapp.CreateContact.class);
                startActivityForResult(intent,CREATE);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == CREATE)
            {
                if(resultCode == RESULT_OK)
                {
                    String name = (data.getStringExtra("name"));
                    String Phone = (data.getStringExtra("phone"));
                    String Web = (data.getStringExtra("web"));
                    String Location = (data.getStringExtra("address"));

                    tvName.setText(name);
                    imgCall.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Phone));
                            startActivity(intent);
                        }
                    });

                    imgWeb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+Web));
                            startActivity(intent);
                        }
                    });

                    imgLocation.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+Location));
                            startActivity(intent);
                        }
                    });
                }
            }
        }
}