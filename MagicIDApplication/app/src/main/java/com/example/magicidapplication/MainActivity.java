package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnsubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnsubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNumber = etID.getText().toString().trim();

                String dob = idNumber.substring(0,6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;

                if(gender < 5)
                    sGender = "FEMALE";
                else
                    sGender = "MALE";

                int Nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;

                if(Nationality == 0)
                    sNationality = "SA Citizen";
                else
                    sNationality = "Permanent Resident";

                String text = "Date of Birth" + dob + "\n" + "Gender" + sGender + "\n" + "Nationality" + sNationality;

                tvResults.setText(text);
                tvResults.setVisibility(View.VISIBLE);
            }
        });

    }
}