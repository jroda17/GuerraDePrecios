package com.example.alumno.guerra_de_precios;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUser = (EditText) findViewById(R.id.user_et);
        final EditText etPass = (EditText) findViewById(R.id.password_et);
        Button btnLogin = (Button) findViewById(R.id.login_btn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();
                String message;

                if (user.equals("bor") && pass.equals("1234")) {

                    message = "Credenciales Correctas";
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    LoginActivity.this.startActivity(intent);

                }else{

                    message = "Credenciales Incorrectas";
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Button btnList = (Button) findViewById(R.id.list_btn);
        //ListOnClickListener listOnClickListener = new ListOnClickListener();
        //btnList.setOnClickListener(listOnClickListener);

    }

    private class ListOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String message = "Yendo a Lista";
            Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, ListActivity.class);
            LoginActivity.this.startActivity(intent);
        }
    }
}
