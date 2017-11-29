package com.tecmilenio.ev3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tecmilenio.ev3.model.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamez on 29/11/2017.
 */

public class HotelActivity extends AppCompatActivity
{
    public List<Hotel> hoteles;
    ListView list;
    CustomListHoteles adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hotels);
        setTitle("Lista de hoteles: ");
        hoteles = new ArrayList<Hotel>();

        hoteles.add(new Hotel(1,"Holiday inn","3","dummy","1231231","Mexico","NL","Monterrey","50","20","900"));
        hoteles.add(new Hotel(2,"Holiday pro","4","dummy","1231231","Mexico","NL","Monterrey","50","20","700"));
        hoteles.add(new Hotel(3,"Holiday star","5","dummy","1231231","Mexico","NL","Monterrey","50","20","400"));
        hoteles.add(new Hotel(4,"Holiday Ja","2","dummy","1231231","Mexico","NL","Monterrey","50","20","1200"));
        hoteles.add(new Hotel(5,"Holiday Tecmi","5","dummy","1231231","Mexico","NL","Monterrey","50","20","1400"));
        hoteles.add(new Hotel(6,"Holiday Sanpeter","4","dummy","1231231","Mexico","NL","Monterrey","50","20","2200"));
        hoteles.add(new Hotel(7,"Holiday epicor","3","dummy","1231231","Mexico","NL","Monterrey","50","20","3300"));
        hoteles.add(new Hotel(8,"Holiday softek","3","dummy","1231231","Mexico","NL","Monterrey","50","20","4600"));
        adapter = new CustomListHoteles(HotelActivity.this,hoteles);
        list=(ListView)findViewById(R.id.hotelList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(HotelActivity.this, "You Clicked at " +hoteles.get(position).getName(), Toast.LENGTH_SHORT).show();
               // Intent myIntent = new Intent(getApplicationContext(), DescripcionMensajeActivity.class);
            }
        });

    }
}
