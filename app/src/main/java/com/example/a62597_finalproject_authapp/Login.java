package com.example.a62597_finalproject_authapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    TextView forgot_password_reference;
    Button login_btn;
    EditText student_no_field, password_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgot_password_reference = findViewById(R.id.forgot_password_reference);
        forgot_password_reference.setOnClickListener(this);

        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);

        student_no_field = findViewById(R.id.student_no_field);
        password_field = findViewById(R.id.password_field);

    }

    public void enableLayout() {
        student_no_field.setEnabled(true);
        password_field.setEnabled(true);
        login_btn.setEnabled(true);
    }


    @Override
    public void onClick(View v) {

        if (v == forgot_password_reference) {
            student_no_field.setEnabled(false);
            password_field.setEnabled(false);
            login_btn.setEnabled(false);
            Fragment fragment = new ForgotPassword();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment).commit();

        } else if (v == login_btn) {

            if (student_no_field.getText().toString().equals("")) {
                student_no_field.setHint("Angiv studienummer!");
                return;

            } else if (password_field.getText().toString().equals("")) {
                password_field.setHint("Angiv kodeord!");
                return;

            } else {
                Intent i = new Intent(getApplicationContext(), Authentification.class);
                startActivity(i);
            }
        }
    }
}
