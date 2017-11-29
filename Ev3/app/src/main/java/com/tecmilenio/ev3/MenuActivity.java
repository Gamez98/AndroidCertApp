package com.tecmilenio.ev3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tecmilenio.ev3.model.Hotel;

import org.w3c.dom.Text;

/**
 * Created by Gamez on 29/11/2017.
 */

public class MenuActivity extends AppCompatActivity {

    private TextView usermail, name;
    private Button verReservaciones;
    private Button buscarHoteles;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Menu principal: ");
        String mail = getIntent().getStringExtra("usermail");
        usermail = (TextView) findViewById(R.id.tv_mail);
        usermail.setText(mail);
        name = (TextView) findViewById(R.id.tv_name);
        name.setText("Encuentra los mejores hoteles con esta aplicación");
    }

    public void onButtonClick(View view)
    {
        if(view.getId() == R.id.verReservaciones)
        {
            Intent i = new Intent(this, ReservationActivity.class);
            startActivity(i);
            Toast.makeText(this , "Mis Reservaciones" , Toast.LENGTH_LONG).show();
        }
        if(view.getId() == R.id.buscarHoteles)
        {
            Intent i = new Intent(this, HotelActivity.class);
            startActivity(i);
            Toast.makeText(this , "Buscar Hoteles" , Toast.LENGTH_LONG).show();
        }
    }

}
