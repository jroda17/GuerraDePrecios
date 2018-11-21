package com.example.alumno.guerra_de_precios;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (estaLogueado()) {

            String message = "Sesion Iniciada";
            Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
            cambiarAMain();

        }else{

            final EditText etUser = (EditText) findViewById(R.id.user_et);
            final EditText etPass = (EditText) findViewById(R.id.password_et);

            Button btnLogin = (Button) findViewById(R.id.login_btn);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String user = etUser.getText().toString();
                    String pass = etPass.getText().toString();
                    String message;

                    if (credencialesValidas(user, pass)) {

                        message = "Credenciales Correctas";
                        Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();

                        if (quiereMantenerSesionIniciada()){

                            guardarCredenciales(user,pass);
                        }

                        cambiarAMain();

                    }else{

                        message = "Credenciales Incorrectas";
                        Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    private boolean quiereMantenerSesionIniciada() {

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        return checkBox.isChecked();
    }

    private boolean credencialesValidas(String user, String pass) {
        //aca va la logica para validar los users y pass

        return user.equals("bor") && pass.equals("1234");
    }

    private boolean estaLogueado() {

        SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        return sharedPreferences.contains("user");
    }

    private void guardarCredenciales(String user, String pass) {
        SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user",user);
        editor.putString("pass",pass);
        editor.commit();
    }

    private void cambiarAMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(intent);
        LoginActivity.this.finish();
    }
}
