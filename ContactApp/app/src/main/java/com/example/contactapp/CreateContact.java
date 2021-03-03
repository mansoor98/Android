package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity {

    EditText etName,etPhone,etWeb,etAddress;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etWeb = findViewById(R.id.etWeb);
        etAddress = findViewById(R.id.etAddress);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = etName.getText().toString().trim();
                String Phone = etPhone.getText().toString().trim();
                String Web = etWeb.getText().toString().trim();
                String Address = etAddress.getText().toString().trim();

                if(Name.isEmpty() && Phone.isEmpty() && Web.isEmpty() && Address.isEmpty())
                {
                    Toast.makeText(CreateContact.this, "Kindly Fill All the Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent();
                    intent.putExtra("name",Name);
                    intent.putExtra("phone",Phone);
                    intent.putExtra("web",Web);
                    intent.putExtra("address",Address);
                    setResult(RESULT_OK,intent);

                    CreateContact.this.finish();
                }
            }
        });
    }
}