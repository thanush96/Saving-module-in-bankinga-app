package com.example.demofirebasetorecycler;

public class model
{
  String name,rate,purl,mail,address,tp;
    model()
    {

    }

    public model(String name, String rate, String purl, String mail, String address, String tp) {
        this.name = name;
        this.rate = rate;
        this.purl = purl;
        this.mail = mail;
        this.address = address;
        this.tp = tp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }
}
