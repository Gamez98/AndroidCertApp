package com.tecmilenio.ev3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.tecmilenio.ev3.model.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamez on 29/11/2017.
 */

public class ReservationActivity extends AppCompatActivity {

    public static List<Hotel> hotelesReservadosList = new ArrayList<Hotel>();
    CustomListHoteles adapter;
    ListView list;

    public static void addHotelReserva(Hotel hotel){
        hotelesReservadosList.add(hotel);

    }

    public static void clearHotelReserva(){
        hotelesReservadosList.clear();

    }



    /**
     * Para actualizar la lista de mensajes cada que publicas uno!!
     */
    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        //volver a settear el adapter!
        adapter = new CustomListHoteles(ReservationActivity.this,hotelesReservadosList);
        list=(ListView)findViewById(R.id.hotelesReservadosList);
        list.setAdapter(adapter);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reservations);
        setTitle("Lista de hoteles reservados: ");
        adapter = new CustomListHoteles(ReservationActivity.this,hotelesReservadosList);
        list=(ListView)findViewById(R.id.hotelesReservadosList);
        list.setAdapter(adapter);

    }
}
