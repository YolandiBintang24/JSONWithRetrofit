package com.example.restwithretrofit;

import com.google.gson.annotations.SerializedName;

public class Kontak {

    @SerializedName("id")
    private String idContact;

    @SerializedName("nama")
    private String name;

    private String email;

    @SerializedName("nohp")
    private String phone;

    @SerializedName("alamat")
    private String addres;

    public Kontak( String name, String email, String phone, String addres) {
        //this.idContact = idContact;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addres = addres;
    }

    public String getIdContact() {
        return idContact;
    }

    public void setIdContact(String idContact) {
        this.idContact = idContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
