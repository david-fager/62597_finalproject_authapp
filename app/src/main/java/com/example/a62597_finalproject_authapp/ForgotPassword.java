package com.example.a62597_finalproject_authapp;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPassword extends Fragment implements View.OnClickListener  {

    Button send, backto_login;
    TextView forgot_password;
    EditText getpassword_studentno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_forgot_password, container, false);

        send = view.findViewById(R.id.send);
        send.setOnClickListener(this);

        backto_login = view.findViewById(R.id.backto_login);
        backto_login.setOnClickListener(this);

        forgot_password = view.findViewById(R.id.forgot_password);
        getpassword_studentno = view.findViewById(R.id.getpassword_studentno);

        return view;
    }

    @Override
    public void onClick(View v) {

        if ( v == send) {
            if (getpassword_studentno.getText().toString().equals("")) {
                getpassword_studentno.setHint("Angiv studienummer!");
                return;

            } else {
                Intent i = new Intent(getActivity(), Login.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //TODO: send email til studerendes mail med ny kode
                startActivity(i);
            }

        } else if ( v == backto_login) {
            ((Login) getActivity()).enableLayout();
            getFragmentManager().beginTransaction().remove(this).commit();

        }
    }
}
