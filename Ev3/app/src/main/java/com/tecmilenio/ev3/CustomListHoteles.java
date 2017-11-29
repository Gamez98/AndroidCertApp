package com.tecmilenio.ev3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tecmilenio.ev3.model.Hotel;

import java.util.List;

import static com.tecmilenio.ev3.ReservationActivity.addHotelReserva;

/**
 * Created by GERALVARADO on 29/11/2017.
 */

public class CustomListHoteles extends ArrayAdapter<String> {
    List<Hotel> hoteles;



    private final Activity context;
    //MIKEEEE
    public CustomListHoteles(Activity context,
                      List<Hotel> hoteles) {
        super(context, R.layout.list_single_hotel,new String[hoteles.size()] );
        this.context = context;
        this.hoteles = hoteles;

    }

    ///
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single_hotel, null, true);
        //buscando los textviews para asignarles valor
        TextView txtTitle = (TextView) rowView.findViewById(R.id.nameHotel);
        TextView txtStars = (TextView) rowView.findViewById(R.id.starsHotel);
        TextView txtCiudad = (TextView) rowView.findViewById(R.id.ciudadHotel);
        final TextView txtFreeRooms = (TextView) rowView.findViewById(R.id.freeromsHotel);
        TextView txtCosto = (TextView) rowView.findViewById(R.id.costHotel);
        Button reservar = (Button) rowView.findViewById(R.id.reservar);
        //asignando valor
        try{
            txtTitle.setText(hoteles.get(position).getName().toString());
            txtStars.setText(hoteles.get(position).getStars().toString() + " estrellas");
            txtCiudad.setText("Se encuentra en "+hoteles.get(position).getCity().toString());
            txtFreeRooms.setText(hoteles.get(position).getFree_rooms().toString() + " habitaciones disponibles");
            txtCosto.setText("$"+ hoteles.get(position).getRoom_cost().toString());
            reservar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer.valueOf(hoteles.get(position).getFree_rooms());
                    txtFreeRooms.setText((Integer.valueOf(hoteles.get(position).getFree_rooms()) -1) + " habitaciones disponibles");
                    hoteles.get(position).setFree_rooms((Integer.valueOf(hoteles.get(position).getFree_rooms()) -1) +"");
                    Toast.makeText(getContext(), "Reservado!", Toast.LENGTH_SHORT).show();
                    addHotelReserva( hoteles.get(position));
                }
            });


        }catch(IndexOutOfBoundsException e){
            txtTitle.setText("error");
            txtStars.setText("error");
        }

        return rowView;
    }




}
