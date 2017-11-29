package com.tecmilenio.ev3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tecmilenio.ev3.model.User;
import com.tecmilenio.ev3.sql.DBHelper;

/**
 * Created by Gamez on 29/11/2017.
 */

public class SignActivity extends AppCompatActivity
{
    private EditText name;
    private EditText last_name;
    private EditText phone;
    private EditText country;
    private EditText mail;
    private EditText password;
    private EditText password_confirm;

    private DBHelper database_helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void onSignUp(View view)
    {
        if(view.getId() == R.id.signup)
        {

            name = (EditText) findViewById(R.id.name);
            last_name = (EditText) findViewById(R.id.last_name);
            phone = (EditText) findViewById(R.id.phone);
            country = (EditText) findViewById(R.id.country);
            mail = (EditText) findViewById(R.id.mail_login);
            password = (EditText) findViewById(R.id.password_signin);
            password_confirm = (EditText) findViewById(R.id.password_signin_2);

            String _name = name.getText().toString();
            String _last_name = last_name.getText().toString();
            String _phone = phone.getText().toString();
            String _country = country.getText().toString();
            String _mail = mail.getText().toString();
            String _password = password.getText().toString();
            String _password2 = password_confirm.getText().toString();

            if (!_password.equals(_password2))
            {
                Toast.makeText(this, "La contraseña no es la misma", Toast.LENGTH_LONG).show();
            }
            if(_name.equals("") || _last_name.equals("") || _phone.equals("") || _country.equals("") || _mail.equals(""))
            {
                Toast.makeText(this, "No puedes dejar campos vacios", Toast.LENGTH_LONG).show();
            }
            else
            {

                User u = new User();
                u.setName(_name);
                u.setLast_name(_last_name);
                u.setPhone(_phone);
                u.setCountry(_country);
                u.setMail(_mail);
                u.setPassword(_password);

                database_helper.insertUser(u);

                Toast.makeText(this, "Usuario Registrado ", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
        }
    }
}
