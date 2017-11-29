package com.tecmilenio.ev3.model;

/**
 * Created by Gamez on 29/11/2017.
 */

public class Hotel
{

    public int id;
    public String name;
    public String stars;
    public String mail;
    public String phone;
    public String country;
    public String state;
    public String city;
    public String rooms;
    public String free_rooms;
    public String room_cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getFree_rooms() {
        return free_rooms;
    }

    public void setFree_rooms(String free_rooms) {
        this.free_rooms = free_rooms;
    }

    public String getRoom_cost() {
        return room_cost;
    }

    public void setRoom_cost(String room_cost) {
        this.room_cost = room_cost;
    }
}
