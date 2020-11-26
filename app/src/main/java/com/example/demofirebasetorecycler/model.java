package com.example.demofirebasetorecycler;

public class model
{
  String name,rate,purl;
    model()
    {

    }

    public model(String name, String rate, String purl) {
        this.name = name;
        this.rate = rate;
        this.purl = purl;
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
}
