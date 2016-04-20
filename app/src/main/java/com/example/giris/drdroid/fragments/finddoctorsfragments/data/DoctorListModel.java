package com.example.giris.drdroid.fragments.finddoctorsfragments.data;

/**
 * Created by giris on 27-03-2016.
 */
public class DoctorListModel {

    public String name, area, address, rating, specialization;
    public double lat, lon;

    public DoctorListModel(String name, String area, String address, String rating, String specialization) {
        this.name = name;
        this.area = area;
        this.address = address;
        this.rating = rating;
        this.specialization = specialization;
    }

}