package com.tecmilenio.ev3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tecmilenio.ev3.model.User;
import com.tecmilenio.ev3.sql.DBHelper;

public class MainActivity extends AppCompatActivity
{

    private EditText correo;
    private EditText contrasena;
    private DBHelper database_helper = new DBHelper(this);
    private User u = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void onButtonClick(View view)
    {
        if(view.getId() == R.id.btnLogin)
        {
            correo = (EditText) findViewById(R.id.mail_login);
            String _correo = correo.getText().toString();
            contrasena = (EditText) findViewById(R.id.password_login);
            String _contrasena = contrasena.getText().toString();
            String pword = database_helper.searchPassSring(_correo);

            if(_contrasena.equals(pword))
            {
                Intent i = new Intent(this, MenuActivity.class);
                i.putExtra("usermail", _correo);
                startActivity(i);
                Toast.makeText(this , "Log In" , Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this , "Usuario o Contraseña incorrectos" , Toast.LENGTH_LONG).show();
            }

        }
        if(view.getId() == R.id.btnSignin)
        {
            Toast.makeText(this , "Go and SignUp " , Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, SignActivity.class);
            startActivity(i);
        }
    }
}
