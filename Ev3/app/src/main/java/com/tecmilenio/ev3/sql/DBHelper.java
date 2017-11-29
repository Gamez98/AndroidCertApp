package com.tecmilenio.ev3.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tecmilenio.ev3.model.User;

/**
 * Created by Gamez on 29/11/2017.
 */
public class DBHelper extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bookingApp.db" ;

    private static final String USER_TABLE_NAME = "users";
    private static final String USER_COLUMN_ID = "id" ;
    private static final String USER_COLUMN_NAME = "name";
    private static final String USER_COLUMN_LASTNAME = "last_name";
    private static final String USER_COLUMN_PHONE = "phone";
    private static final String USER_COLUMN_COUNTRY = "country";
    private static final String USER_COLUMN_MAIL = "mail";
    private static final String USER_COLUMN_PASSWORD = "password";

    private static final String HOTEL_TABLE_NAME = "hotels";
    private static final String HOTEL_COLUMN_ID = "id" ;
    private static final String HOTEL_COLUMN_NAME = "name" ;
    private static final String HOTEL_COLUMN_STARS = "stars" ;
    private static final String HOTEL_COLUMN_MAIL = "mail" ;
    private static final String HOTEL_COLUMN_PHONE = "phone" ;
    private static final String HOTEL_COLUMN_COUNTRY = "country" ;
    private static final String HOTEL_COLUMN_STATE = "state" ;
    private static final String HOTEL_COLUMN_CITY = "city" ;
    private static final String HOTEL_COLUMN_ROOMS = "rooms" ;
    private static final String HOTEL_COLUMN_FREE_ROOMS = "free_rooms" ;
    private static final String HOTEL_COLUMN_ROOM_COST = "room_cost" ;
    SQLiteDatabase db;

    private static final String USER_TABLE_CREATE = "CREATE TABLE " + USER_TABLE_NAME + " ( " +
            USER_COLUMN_ID + " integer primary key,  " +
            USER_COLUMN_NAME + " TEXT NOT NULL, " +
            USER_COLUMN_LASTNAME + " TEXT NOT NULL, " +
            USER_COLUMN_PHONE + " TEXT NOT NULL, " +
            USER_COLUMN_COUNTRY + " TEXT NOT NULL, " +
            USER_COLUMN_MAIL + " TEXT NOT NULL, " +
            USER_COLUMN_PASSWORD + " TEXT NOT NULL "
            + " ); ";

    private static final String HOTEL_TABLE_CREATE = "CREATE TABLE " + HOTEL_TABLE_NAME + " ( "  +
            HOTEL_COLUMN_ID + " integer primary key auto_increment ,  " +
            HOTEL_COLUMN_NAME + " TEXT NOT NULL, " +
            HOTEL_COLUMN_STARS + " TEXT NOT NULL, " +
            HOTEL_COLUMN_MAIL + " TEXT NOT NULL, " +
            HOTEL_COLUMN_PHONE + " TEXT NOT NULL, " +
            HOTEL_COLUMN_COUNTRY + " TEXT NOT NULL, " +
            HOTEL_COLUMN_STATE + " TEXT NOT NULL, " +
            HOTEL_COLUMN_CITY + " TEXT NOT NULL, " +
            HOTEL_COLUMN_ROOMS + " TEXT NOT NULL, " +
            HOTEL_COLUMN_FREE_ROOMS + " TEXT NOT NULL, " +
            HOTEL_COLUMN_ROOM_COST + " TEXT NOT NULL "
            + " ); ";

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(USER_TABLE_CREATE);
        db.execSQL(HOTEL_TABLE_CREATE);
    }

    /**
     *  Insertar usuario por su modelo
     */
    public void insertUser(User user)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from users";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(USER_COLUMN_ID, count);
        values.put(USER_COLUMN_NAME, user.getName());
        values.put(USER_COLUMN_LASTNAME, user.getLast_name());
        values.put(USER_COLUMN_PHONE, user.getPhone());
        values.put(USER_COLUMN_COUNTRY, user.getCountry());
        values.put(USER_COLUMN_MAIL, user.getMail());
        values.put(USER_COLUMN_PASSWORD, user.getPassword());
        db.insert(USER_TABLE_NAME, null, values);
        db.close();
    }

    /**
     * Evalua si la contraseña es del usuario "x" con un cursor de parametros (0) mail (1) password
     */
    public String searchPassSring(String mail)
    {
        db = this.getReadableDatabase();
        String query = "select mail, password from " + USER_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String correo, contrasena;
        contrasena = "Not found";
        if(cursor.moveToFirst())
        {
            do
            {
                correo = cursor.getString(0);

                if(mail.equals(correo))
                {
                    contrasena = cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
        return contrasena;
    }

    /**
     * Droping users & hotels tables
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String drop_users = "DROP DATABASE IF EXISTS " + USER_TABLE_NAME + "; ";
        String drop_hotels = "DROP DATABASE IF EXISTS " + HOTEL_TABLE_NAME + "; ";
        //String drop_hotels = "DROP DATABASE IF EXISTS " + HOTEL_TABLE_NAME + "; ";
        db.execSQL(drop_users);
        db.execSQL(drop_hotels);
        this.onCreate(db);
    }

}
