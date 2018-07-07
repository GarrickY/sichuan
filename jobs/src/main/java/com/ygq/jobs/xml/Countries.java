package com.ygq.jobs.xml;

import java.io.Serializable;
import java.util.List;

public class Countries implements Serializable {
    public List<Country> country;

    public Countries() {
    }
}

class Country implements Serializable {
    public String name;
    public String phoneCode;
    public Provinces provinces;

    public Country() {
    }

}

class Provinces implements Serializable {
    public List<Province> province;

    public Provinces() {
    }

}

class Province implements Serializable {
    public String name;
    public String area;
    public String people;
    public String gdp;

    public Province() {
    }
}