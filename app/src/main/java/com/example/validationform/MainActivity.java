package com.example.validationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button cancel,proceed;
    EditText first_name,last_name,email,password;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proceed = findViewById(R.id.proceed_button);
        cancel = findViewById(R.id.cancel_button);

        first_name = findViewById(R.id.firstname);
        last_name = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked = CheckAllFields();

                if(isAllFieldsChecked){
                    Intent i = new Intent(MainActivity.this , MainActivity2.class);
                    startActivity(i);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
                System.exit(0);
            }
        });
    }

    private boolean CheckAllFields() {
        if(first_name.length() == 0){
            first_name.setError("This field is required");
            return false;
        }
        if(last_name.length() == 0){
            last_name.setError("This field is required");
            return false;
        }
        if(email.length() == 0){
            email.setError("Email is required");
            return false;
        }
        else if(password.length() < 10){
            password.setError("Password must be minimum 10 characters");
            return false;
        }
        return true;
    }
}